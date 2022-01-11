// micro-translator.c
// CPSC 441 Assignment 2
// Written by Aiden Park
// Submitted on October 23, 2021

#include <sys/socket.h>
#include <netinet/in.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>

/*
 * Note:
 * Parts of this code have been adapted from the wordlen server
 * and client examples provided by the professor.
 */

#define PORT_NUMBER 8920 // Server port, change this if needed

int main()
{
    // Various Variables
    int tsocket; // Server socket
    struct sockaddr* server; // Server pointer
    struct sockaddr* client; // Client pointer
    struct sockaddr_in tserver; // Server address
    struct sockaddr_in tclient; // Client address
    char incoming[64]; // Incoming message from indirection server
    char outgoing[64]; // Message to return to indirection server
    int incoming_bytes; // Byte size of incoming message
    int length = sizeof(tserver);

    // Set up socket
    if ((tsocket = socket(AF_INET, SOCK_DGRAM, IPPROTO_UDP))==-1)
    {
        printf("\n> ERROR: Could not set up translator socket.\n");
        return -1;
    }

    memset((char *) &tserver, 0, sizeof(tserver));
    tserver.sin_family = AF_INET;
    tserver.sin_port = htons(PORT_NUMBER);
    tserver.sin_addr.s_addr = htonl(INADDR_ANY);
    server = (struct sockaddr *) &tserver;
    client = (struct sockaddr *) &tserver;

    // Connect socket to server
    if(bind(tsocket, server, sizeof(tserver)) == -1)
    {
        printf("\n> ERROR: Failed to bind() translator server!\n");
        return -1;
    }

    // Successful connection
    printf("\n> Micro Translator now running! Now listening for indirection server on port %d...\n", PORT_NUMBER);

    // Wait for message from indirection server
    while(1)
    {
        // Clear buffers
        bzero(incoming, 64);
        bzero(outgoing, 64);

        // Check for message from indirection server
        if((incoming_bytes=recvfrom(tsocket, incoming, 64, 0, client, &length)) < 0)
        {
            printf("\n> ERROR: Translator could not read message from indirection server.\n");
            return -1;
        }

        // Process message from server
        printf("\n> Received input '%s'\n", incoming);
        if(strcmp(incoming, "Hello") == 0)
        {
            sprintf(outgoing, "Bonjour");
        }
        else if(strcmp(incoming, "Goodbye") == 0)
        {
            sprintf(outgoing, "Au revoir");
        }
        else if(strcmp(incoming, "Red") == 0)
        {
            sprintf(outgoing, "Rouge");
        }
        else if(strcmp(incoming, "Yellow") == 0)
        {
            sprintf(outgoing, "Jaune");
        }
        else if(strcmp(incoming, "Blue") == 0)
        {
            sprintf(outgoing, "Bleu");
        }
        else
        {
            sprintf(outgoing, "That word is not currently in our dictionary!");
        }

        // Return the output
        printf("\n> Returning '%s' to server.\n", outgoing);
        sendto(tsocket, outgoing, strlen(outgoing), 0, client, sizeof(tserver));
    }

    // Close the server
    close(tsocket);
    return 0;
}