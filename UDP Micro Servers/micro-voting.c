// micro-voting.c
// Written by Aiden Park

#include <sys/socket.h>
#include <netinet/in.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>

#define PORT_NUMBER 8840 // Server port, change this if needed

int candidate_1 = 33; // Candidate 1's votes
int candidate_2 = 44; // Candidate 2's votes
int candidate_3 = 55; // Candidate 3's votes
int candidate_4 = 66; // Candidate 4's votes
int encryption_key = 4; // Secure voting encryption key

int main() {
    // Various Variables
    int tsocket; // Server socket
    struct sockaddr *server; // Server pointer
    struct sockaddr *client; // Client pointer
    struct sockaddr_in tserver; // Server address
    struct sockaddr_in tclient; // Client address
    char incoming[64]; // Incoming message from indirection server
    char outgoing[64]; // Message to return to indirection server
    int incoming_bytes; // Byte size of incoming message
    int length = sizeof(tserver);

    // Set up socket
    if ((tsocket = socket(AF_INET, SOCK_DGRAM, IPPROTO_UDP)) == -1) {
        printf("\n> ERROR: Could not set up currency socket.\n");
        return -1;
    }

    memset((char *) &tserver, 0, sizeof(tserver));
    tserver.sin_family = AF_INET;
    tserver.sin_port = htons(PORT_NUMBER);
    tserver.sin_addr.s_addr = htonl(INADDR_ANY);
    server = (struct sockaddr *) &tserver;
    client = (struct sockaddr *) &tserver;

    // Connect socket to server
    if (bind(tsocket, server, sizeof(tserver)) == -1) {
        printf("\n> ERROR: Failed to bind() voting server!\n");
        return -1;
    }

    // Successful connection
    printf("\n> Micro Voting now running! Now listening for indirection server on port %d...\n", PORT_NUMBER);

    // Wait for message from indirection server
    while (1) {
        // Clear buffers
        bzero(incoming, 64);
        bzero(outgoing, 64);

        // Check for message from indirection server
        if ((incoming_bytes = recvfrom(tsocket, incoming, 64, 0, client, &length)) < 0) {
            printf("\n> ERROR: Voting could not read message from indirection server.\n");
            return -1;
        }

        // Process message from server
        printf("\n> Received input '%s'\n", incoming);
        if(incoming[1] == '!' || incoming[2] == '!')
        {
            incoming[strlen(incoming) - 1] = '\0';
            int vote = atoi(incoming);
            vote = vote / encryption_key;

            if(vote == 1)
            {
                candidate_1++;
            }
            else if(vote == 2)
            {
                candidate_2++;
            }
            else if(vote == 3)
            {
                candidate_3++;
            }
            else if(vote == 4)
            {
                candidate_4++;
            }
            bzero(incoming, 64);
            bzero(outgoing, 64);
            sprintf(outgoing, "> Vote received successfully!");
        }
        else if(strcmp(incoming, "1") == 0)
        {
            sprintf(outgoing, " 1  John Smith\n 2  Jane Doe\n 3  Michael Steven\n 4  Sarah David");
        }
        else if(strcmp(incoming, "2") == 0)
        {
            sprintf(outgoing, "%d", encryption_key);
        }
        else if(strcmp(incoming, "3") == 0)
        {
            sprintf(outgoing, "John Smith: %d\nJane Doe: %d\nMichael Steven: %d\nSarah David: %d",
                    candidate_1, candidate_2, candidate_3, candidate_4);
        }
        else
        {
            sprintf(outgoing, "Invalid Input!");
        }

        // Return output to the server
        printf("\n> Returning '%s' to server.\n", outgoing);
        sendto(tsocket, outgoing, strlen(outgoing), 0, client, sizeof(tserver));
    }

    // Close the server
    close(tsocket);
    return 0;
}