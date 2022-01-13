// micro-client.c
// Written by Aiden Park

#include <sys/socket.h>
#include <stdio.h>
#include <stdlib.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#include <unistd.h>
#include <string.h>

int main(int argc, char** argv)
{
    // Various Variables
    char ip[15]; // indirection server IP address
    char port[6]; // indirection server port
    int sockfd; // sockfd for server socket
    struct sockaddr_in server; // server struct
    int service; // user-selected service
    char outgoing[64]; // outgoing message
    char incoming[64]; // incoming message
    int incoming_bytes; // byte size of incoming message
    int key; // encryption key
    int vote; // outgoing vote
    int has_voted = 0; // changes to 1 once client has voted
    int chosen; // chosen voting option

    // Check for user-supplied IP and port number
    if(argc == 3)
    {
        int i;
        // Read IP from command line args
        for(i = 0; argv[1][i] != '\0'; i++)
        {
            ip[i] = argv[1][i];
        }
        ip[i] = '\0';
        // Read port from command line args
        for(i = 0; i < argv[2][i] != '\0'; i++)
        {
            port[i] = argv[2][i];
        }
        port[i] = '\0';
    }
    else
    {
        printf("\n> ERROR: Invalid arguments!\n\n> Expected: ./micro-client [IP] [PORT]\n\n");
        exit(-1);
    }

    // Assign IP and PORT
    server.sin_family = AF_INET;
    server.sin_port = htons(atoi(port));
    server.sin_addr.s_addr = htonl(INADDR_ANY);
    server.sin_addr.s_addr = inet_addr(ip);

    // Create client socket
    if((sockfd = socket(PF_INET, SOCK_STREAM, 0)) == -1)
    {
        printf("\n> ERROR: Could not initialize socket() in client.\n");
        exit(-1);
    }

    // Connect socket to server
    if(connect(sockfd, (struct sockaddr *) &server, sizeof(struct sockaddr_in)) == -1)
    {
        printf("\n> ERROR: Could not connect() to server.\n\nMake sure that the server is running, and you supplied the correct IP/PORT!\n\n");
        exit(-1);
    }

    // Server connected, go to main menu
    printf("\n> You are now connected to the indirection server!\n");
    printf("\n> Choose a service:\n");
    printf("\n1 - Translator\n2 - Currency Converter\n3 - Voting\n0 - Exit Program\n");
    scanf("%d", &service);
    fflush(stdin);

    // Check user input
    while(service != 0)
    {

        if(service == 1) // Translator
        {
            outgoing[0] = '1';
            outgoing[1] = '\0';
            send(sockfd, outgoing, 64, 0);

            if((incoming_bytes = recv(sockfd, incoming, 64, 0)) > 0)
            {
                incoming[incoming_bytes] = '\0';
                printf("\n%s", incoming);
                service = 4;
                scanf("%s", outgoing);
                fflush(stdin);
                send(sockfd, outgoing, 64, 0);
                bzero(incoming, 64);
                bzero(outgoing, 64);
                while(1)
                {
                    if((incoming_bytes = recv(sockfd, incoming, 64, 0)) > 0)
                    {
                        incoming[incoming_bytes] = '\0';
                        printf("\n> French translation: %s\n", incoming);
                        break;
                    }
                }

            }
            else
            {
                printf("\n> ERROR: Failed to receive a response back from server!\n");
                close(sockfd);
                exit(1);
            }
        }

        else if(service == 2) // Currency
        {
            outgoing[0] = '2';
            outgoing[1] = '\0';
            send(sockfd, outgoing, 64, 0);

            if((incoming_bytes = recv(sockfd, incoming, 64, 0)) > 0)
            {
                incoming[incoming_bytes] = '\0';
                printf("\n%s", incoming);
                service = 4;
                fgets(outgoing, 63, stdin);
                fflush(stdin);
                outgoing[strlen(outgoing) - 1] = '\0';
                send(sockfd, outgoing, 64, 0);
                bzero(incoming, 64);
                bzero(outgoing, 64);
                while(1)
                {
                    if((incoming_bytes = recv(sockfd, incoming, 64, 0)) > 0)
                    {
                        incoming[incoming_bytes] = '\0';
                        printf("\n> Conversion amount: %s\n", incoming);
                        break;
                    }
                }

            }
            else
            {
                printf("\n> ERROR: Failed to receive a response back from server!\n");
                close(sockfd);
                exit(1);
            }
        }

        else if(service == 3) // Voting
        {
            outgoing[0] = '3';
            outgoing[1] = '\0';
            send(sockfd, outgoing, 64, 0);

            if((incoming_bytes = recv(sockfd, incoming, 64, 0)) > 0)
            {
                incoming[incoming_bytes] = '\0';
                printf("\n%s\n", incoming);
                printf("\n1 - Show Candidates\n2 - Secure Voting\n3 - Voting Summary\n");
                service = 4;
                fgets(outgoing, 63, stdin);
                fflush(stdin);
                outgoing[strlen(outgoing) - 1] = '\0';

                if((strcmp(outgoing, "3")) == 0 && (has_voted == 0))
                {
                    while(strcmp(outgoing, "3") == 0)
                    {
                        printf("\n> You must vote before you can view the results!\n");
                        printf("\n%s\n", incoming);
                        printf("\n1 - Show Candidates\n2 - Secure Voting\n3 - Voting Summary\n");
                        fgets(outgoing, 63, stdin);
                        fflush(stdin);
                        outgoing[strlen(outgoing) - 1] = '\0';
                    }
                }
                if((strcmp(outgoing, "2")) == 0 && (has_voted == 1))
                {
                    while(strcmp(outgoing, "2") == 0)
                    {
                        printf("\n> You have already voted!\n");
                        printf("\n%s\n", incoming);
                        printf("\n1 - Show Candidates\n2 - Secure Voting\n3 - Voting Summary\n");
                        fgets(outgoing, 63, stdin);
                        fflush(stdin);
                        outgoing[strlen(outgoing) - 1] = '\0';
                    }
                }

                // Send chosen option
                send(sockfd, outgoing, 64, 0);
                chosen = atoi(outgoing);
                bzero(outgoing, 64);
                bzero(incoming, 64);

                // Show candidates
                if(chosen == 1)
                {
                    while(1)
                    {
                        if((incoming_bytes = recv(sockfd, incoming, 64, 0)) > 0)
                        {
                            incoming[incoming_bytes] = '\0';
                            printf("\nID  Name\n%s\n", incoming);
                            break;
                        }
                    }
                    bzero(outgoing, 64);
                    bzero(incoming, 64);
                }


                // Secure voting
                else if(chosen == 2)
                {
                    while(1)
                    {
                        if((incoming_bytes = recv(sockfd, incoming, 64, 0)) > 0)
                        {
                            incoming[incoming_bytes] = '\0';
                            printf("\n> Enter the ID of the candidate you are voting for: ");
                            fgets(outgoing, 63, stdin);
                            fflush(stdin);
                            outgoing[strlen(outgoing) - 1] = '\0';
                            while ((strcmp(outgoing, "1") != 0) && (strcmp(outgoing, "2") != 0)
                                   && (strcmp(outgoing, "3") != 0) && (strcmp(outgoing, "4") != 0)) {
                                printf("\n> Invalid ID!\n");
                                printf("\n> Enter the ID of the candidate you are voting for: ");
                                fgets(outgoing, 63, stdin);
                                fflush(stdin);
                                outgoing[strlen(outgoing) - 1] = '\0';
                            }

                            // Send the vote
                            key = atoi(incoming);
                            vote = atoi(outgoing);
                            vote = key * vote;
                            sprintf(outgoing, "%d", vote);
                            outgoing[strlen(outgoing)+1] = '\0';
                            outgoing[strlen(outgoing)] = '!';
                            send(sockfd, outgoing, 64, 0);
                            break;
                        }
                    }
                    if((incoming_bytes = recv(sockfd, incoming, 64, 0)) > 0)
                    {
                        incoming[incoming_bytes] = '\0';
                        printf("\n%s\n", incoming);
                    }

                    bzero(outgoing, 64);
                    bzero(incoming, 64);
                    has_voted = 1;
                }

                // Voting summary
                else
                {
                    while(1)
                    {
                        if((incoming_bytes = recv(sockfd, incoming, 64, 0)) > 0)
                        {
                            incoming[incoming_bytes] = '\0';
                            printf("\n-- Voting Results --\n%s\n", incoming);
                            break;
                        }
                    }
                    bzero(outgoing, 64);
                    bzero(incoming, 64);
                }


            }
            else
            {
                printf("\n> ERROR: Failed to receive a response back from server!\n");
                close(sockfd);
                exit(1);
            }
        }

        else// Invalid input
        {
            printf("\n> Choose a service:\n");
            printf("\n1 - Translator\n2 - Currency Converter\n3 - Voting\n0 - Exit Program\n");

            scanf("%d", &service);
            fflush(stdin);
        }
    }

    // Close socket connection
    printf("\n> Goodbye!\n");
    close(sockfd);
    return 0;
}