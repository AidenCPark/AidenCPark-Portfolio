// micro-currency.c
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

#define PORT_NUMBER 8930 // Server port, change this if needed

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
    char dollars[64]; // amount of money
    char source_currency; // currency to be converted
    char dest_currency; // currency to convert to
    int i;
    char return_dollars[64]; // amount of money to return
    double dollars_d;
    double return_dollars_d;
    char* end;

    // Set up socket
    if ((tsocket = socket(AF_INET, SOCK_DGRAM, IPPROTO_UDP))==-1)
    {
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
    if(bind(tsocket, server, sizeof(tserver)) == -1)
    {
        printf("\n> ERROR: Failed to bind() currency server!\n");
        return -1;
    }

    // Successful connection
    printf("\n> Micro Currency now running! Now listening for indirection server on port %d...\n", PORT_NUMBER);

    // Wait for message from indirection server
    while(1)
    {
        // Clear buffers
        bzero(incoming, 64);
        bzero(outgoing, 64);
        bzero(dollars, 64);
        bzero(return_dollars, 64);

        // Check for message from indirection server
        if((incoming_bytes=recvfrom(tsocket, incoming, 64, 0, client, &length)) < 0)
        {
            printf("\n> ERROR: Currency could not read message from indirection server.\n");
            return -1;
        }

        // Process message from server
        printf("\n> Received input '%s'\n", incoming);

        for(i = 0; incoming[i] != ' '; i++)
        {
            dollars[i] = incoming[i];
        }
        dollars[i] = '\0';
        printf("\n> %s dollars ", dollars);
        i++;
        source_currency = incoming[i];
        printf("converted from %c ", source_currency);
        for(i; incoming[i] != ' '; i++){}
        i++;
        dest_currency = incoming[i];
        printf("to %c is ", dest_currency);

        dollars_d = strtod(dollars, &end);



        // Canadian Dollar
        if(source_currency == 'C' && dest_currency == 'U')
        {
            return_dollars_d = dollars_d * 0.81;
            sprintf(return_dollars, "%0.2f", return_dollars_d);
        }
        if(source_currency == 'C' && dest_currency == 'E')
        {
            return_dollars_d = dollars_d * 0.69;
            sprintf(return_dollars, "%0.2f", return_dollars_d);
        }
        if(source_currency == 'C' && dest_currency == 'P')
        {
            return_dollars_d = dollars_d * 0.59;
            sprintf(return_dollars, "%0.2f", return_dollars_d);
        }
        if(source_currency == 'C' && dest_currency == 'B')
        {
            return_dollars_d = dollars_d * 0.00001336;
            sprintf(return_dollars, "%0.2f", return_dollars_d);
        }

        // US Dollar
        if(source_currency == 'U' && dest_currency == 'C')
        {
            return_dollars_d = dollars_d * 1.24;
            sprintf(return_dollars, "%0.2f", return_dollars_d);
        }
        if(source_currency == 'U' && dest_currency == 'E')
        {
            return_dollars_d = dollars_d * 0.86;
            sprintf(return_dollars, "%0.2f", return_dollars_d);
        }
        if(source_currency == 'U' && dest_currency == 'P')
        {
            return_dollars_d = dollars_d * 0.73;
            sprintf(return_dollars, "%0.2f", return_dollars_d);
        }
        if(source_currency == 'U' && dest_currency == 'B')
        {
            return_dollars_d = dollars_d * 0.00001641;
            sprintf(return_dollars, "%0.2f", return_dollars_d);
        }

        // Euro
        if(source_currency == 'E' && dest_currency == 'C')
        {
            return_dollars_d = dollars_d * 1.44;
            sprintf(return_dollars, "%0.2f", return_dollars_d);
        }
        if(source_currency == 'E' && dest_currency == 'U')
        {
            return_dollars_d = dollars_d * 1.16;
            sprintf(return_dollars, "%0.2f", return_dollars_d);
        }
        if(source_currency == 'E' && dest_currency == 'P')
        {
            return_dollars_d = dollars_d * 0.85;
            sprintf(return_dollars, "%0.2f", return_dollars_d);
        }
        if(source_currency == 'E' && dest_currency == 'B')
        {
            return_dollars_d = dollars_d * 0.00001908;
            sprintf(return_dollars, "%0.2f", return_dollars_d);
        }

        // British Pound
        if(source_currency == 'P' && dest_currency == 'C')
        {
            return_dollars_d = dollars_d * 1.70;
            sprintf(return_dollars, "%0.2f", return_dollars_d);
        }
        if(source_currency == 'P' && dest_currency == 'U')
        {
            return_dollars_d = dollars_d * 1.38;
            sprintf(return_dollars, "%0.2f", return_dollars_d);
        }
        if(source_currency == 'P' && dest_currency == 'E')
        {
            return_dollars_d = dollars_d * 1.18;
            sprintf(return_dollars, "%0.2f", return_dollars_d);
        }
        if(source_currency == 'P' && dest_currency == 'B')
        {
            return_dollars_d = dollars_d * 0.00002264;
            sprintf(return_dollars, "%0.2f", return_dollars_d);
        }

        // BTC Bitcoin
        if(source_currency == 'B' && dest_currency == 'C')
        {
            return_dollars_d = dollars_d * 74886.9;
            sprintf(return_dollars, "%0.2f", return_dollars_d);
        }
        if(source_currency == 'B' && dest_currency == 'U')
        {
            return_dollars_d = dollars_d * 60954.06;
            sprintf(return_dollars, "%0.2f", return_dollars_d);
        }
        if(source_currency == 'B' && dest_currency == 'E')
        {
            return_dollars_d = dollars_d * 52416.48;
            sprintf(return_dollars, "%0.2f", return_dollars_d);
        }
        if(source_currency == 'B' && dest_currency == 'P')
        {
            return_dollars_d = dollars_d * 44181.24;
            sprintf(return_dollars, "%0.2f", return_dollars_d);
        }


        // Return dollar amount
        printf("%s\n", return_dollars);
        sprintf(outgoing, return_dollars);

        // Return the output
        printf("\n> Returning '%s' to server.\n", outgoing);
        if(strcmp(outgoing, "") == 0)
        {
            sprintf(outgoing, "Unknown Currency!");
        }
        sendto(tsocket, outgoing, strlen(outgoing), 0, client, sizeof(tserver));

        bzero(dollars, 64);
        bzero(return_dollars, 64);
        dollars_d = 0;
        return_dollars_d = 0;
    }

    // Close the server
    close(tsocket);
    return 0;
}