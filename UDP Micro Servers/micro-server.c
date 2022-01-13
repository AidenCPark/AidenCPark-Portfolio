// micro-server.c
// Written by Aiden Park

#include <sys/socket.h>
#include <stdio.h>
#include <stdlib.h>
#include <netinet/in.h>
#include <string.h>
#include <unistd.h>
#include <arpa/inet.h>

#define MICRO_IP "192.168.1.1" // IP address of micro servers
#define PORT_NUMBER 8810 // Server port, change this if needed
#define MICRO_PORT_1 8820 // Translator server port
#define MICRO_PORT_2 8830 // Currency server port
#define MICRO_PORT_3 8840 // Voting server port

int othersockfd; // Used for child socket with fork()
int status = 0; // current micro server
char incoming[64]; // message received from user on client
char outgoing[64]; // message returned to user from server

// Function used by the server to communicate with a micro server
void micro_server(int port)
{
    int incoming_bytes;
    struct sockaddr_in micro_server;
    int length = sizeof(micro_server);
    struct sockaddr* server1;
    int s;
    if((s=socket(AF_INET, SOCK_DGRAM, IPPROTO_UDP))==-1)
    {
        printf("\n> ERROR: Failed to set up UDP socket.\n");
        exit(-1);
    }
    memset((char *) &micro_server, 0, sizeof(micro_server));
    micro_server.sin_family = AF_INET;
    micro_server.sin_port = htons(port);
    server1 = (struct sockaddr *) &micro_server;

    if(inet_pton(AF_INET, MICRO_IP, &micro_server.sin_addr)==0)
    {
        printf("\n> ERROR: Call to inet_pton() failed.\n");
        exit(-1);
    }
    sprintf(outgoing, incoming);
    printf("\n> Sending '%s' to micro server.\n", outgoing);
    if(sendto(s, incoming, strlen(incoming), 0, server1, sizeof(micro_server)) == -1)
    {
        printf("\n> ERROR: Failed to sendto() on micro service.\n");
        exit(-1);
    }
    if((incoming_bytes = recvfrom(s, outgoing, 64, 0, server1, &length)) == -1)
    {
        printf("\n> ERROR: Failed to read message from micro server.\n");
        exit(-1);
    }
    printf("\n> Received '%s' from micro server.\n", outgoing);
    outgoing[incoming_bytes] = '\0';
    printf("\n> Sending '%s' to client.\n", outgoing);
    send(othersockfd, outgoing, strlen(outgoing), 0);
    bzero(incoming, 64);
    bzero(outgoing, 64);
    status = 0;
}

int main()
{
    // Various Variables
    struct sockaddr_in server; // server struct
    int mainsockfd; // fd for the server socket
    pid_t pid; // pid for fork()
    char buffer[64]; // buffer

    // Set up server IP/port
    memset(&server, 0, sizeof(server));
    server.sin_family = AF_INET;
    server.sin_port = htons(PORT_NUMBER);
    server.sin_addr.s_addr = htonl(INADDR_ANY);

    // Socket setup
    if((mainsockfd = socket(PF_INET, SOCK_STREAM, 0)) == -1)
    {
        printf("\n> ERROR: Could not initialize socket() in server.\n");
        exit(-1);
    }

    // Bind socket
    if(bind(mainsockfd, (struct sockaddr *)&server, sizeof(struct sockaddr_in)) == -1)
    {
        printf("\n> ERROR: Could not bind() server socket.\n");
        exit(-1);
    }

    // Get ready to listen for client
    if (listen(mainsockfd, 5) == -1)
    {
        printf("\n> ERROR: The server was not able to listen()\n");
        exit(-1);
    }

    printf("\n> Indirection server ready, now listening for a client on port %d...\n", PORT_NUMBER);

    // Loop listening for client
    while(1)
    {
        // Clear buffers
        bzero(incoming, 64);
        bzero(outgoing, 64);

        // Connect to client
        if((othersockfd = accept(mainsockfd, NULL, NULL)) == -1)
        {
            printf("\n> Server lost connection to the client.\n");
            close(mainsockfd);
            close(othersockfd);
            exit(1);
        }

        // New process for client
        pid = fork();

        // Check if fork() was successful
        if(pid < 0)
        {
            printf("\n> ERROR: Server failed to fork() a new process.\n");
            exit(-1);
        }
        else if(pid == 0)
        {
            close(mainsockfd);

            // Check message received from client
            while(recv(othersockfd, incoming, 64, 0) > 0)
            {
                printf("\n> Server received '%s' from the client!\n",incoming);

                if(status == 0)
                {
                    if(incoming[1] == '!' || incoming[2] == '!') // Special case for Voting
                    {
                        micro_server(MICRO_PORT_3);
                    }
                    else if(incoming[0] == '1') // Translator
                    {
                        status = 1;
                        sprintf(outgoing, "> Enter an English word: ");
                        printf("\n> Sending '%s' to the client.\n", outgoing);
                        send(othersockfd, outgoing, strlen(outgoing), 0);
                        bzero(incoming, 64);
                        bzero(outgoing, 64);
                    }
                    else if(incoming[0] == '2') // Currency
                    {
                        status = 2;
                        sprintf(outgoing, "> Enter your conversion [amount] [currency1] [currency2]: ");
                        printf("\n> Sending '%s' to the client.\n", outgoing);
                        send(othersockfd, outgoing, strlen(outgoing), 0);
                        bzero(incoming, 64);
                        bzero(outgoing, 64);
                    }
                    else if(incoming[0] == '3') // Voting
                    {
                        status = 3;
                        sprintf(outgoing, "> Choose an option:");
                        printf("\n> Sending '%s' to the client.\n", outgoing);
                        send(othersockfd, outgoing, strlen(outgoing), 0);
                        bzero(incoming, 64);
                        bzero(outgoing, 64);
                    }
                }

                // Translator
                else if(status == 1)
                {
                    micro_server(MICRO_PORT_1);
                }

                // Currency
                else if(status == 2)
                {
                    micro_server(MICRO_PORT_2);
                }

                // Voting
                else if(status == 3)
                {
                    micro_server(MICRO_PORT_3);
                }
            }
        }
        else
        {
            // This is the process that will continue to listen() for commands
            printf("\n> Connected to client.\n");
            close(othersockfd);
        }
    }
}


