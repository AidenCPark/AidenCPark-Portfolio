// censor.c
// Created by: Aiden Park

#include <printf.h>
#include <stdlib.h>
#include <sys/socket.h>
#include <arpa/inet.h>
#include <string.h>
#include <unistd.h>
#include <netdb.h>

int connecttcp(char address[],int port);
int connecthttp(int sock, char name[], char httpath[]);

int main(int argc, char** argv)
{
    char client_query[2048];
    char http_req[2048];
    char url[2048];
    char hostname[2048];
    char page[20480];
    char page_return[20480];
    int j;
    int pid;
    int length;
    int bad_url = 0;
    int tcp;
    int text;
    int html;
    int min;
    int max;
    int head_len_final;
    int info;
    char head[2048];
    int head_len;
    int input;
    char output[2048];
    char output_len[30];
    int output_len_int;
    int head_status = 1;
    char type[30];
    char holder[30];
    char head_output[2048];
    char httppath[2048];
    int i;
    int word_count = 0; // Number of censored words
    int port_number; // Holds the port number
    char censored_words[25][25]; // Holds all censored words (25 words, 25 letters long each)

    //------------------------------------------------------------//
    // STARTUP/PORT                                               //
    //------------------------------------------------------------//

    // Check if user has given a port number
    if(argc == 2)
    {
        port_number = 0; // Set port_number to the supplied port
        for(i = 0; argv[1][i] != '\0'; i++)
        {
            port_number = (port_number*10)+(argv[1][i]-'0');
        }
    }
    else // No port number supplied
    {
        printf("Please specify a port number when running the program!");
        exit(0);
    }

    //------------------------------------------------------------//
    // SOCKET NUMBER 1 (main_socket)                              //
    //------------------------------------------------------------//

    int main_socket = 0;
    struct sockaddr_in serv_addr;

    // Establish TCP connection
    if((main_socket = socket(AF_INET, SOCK_STREAM, 0)) < 0)
    {
        printf("Socket creation error!\n");
        exit(0);
    }

    // Part of this code adapted from:
    // https://code-examples.net/en/q/104e11e
    memset(&serv_addr, 0, sizeof(serv_addr));
    serv_addr.sin_addr.s_addr = htonl(INADDR_ANY);
    serv_addr.sin_family = AF_INET;
    serv_addr.sin_port = htons(port_number);
    // end of adapted code.

    if(bind(main_socket, (struct sockaddr*) &serv_addr,sizeof(struct sockaddr_in))==-1)
    {
        printf("There was a problem with the port, try another one!");
        exit(0);
    }
    if(listen(main_socket,20)==-1)
    {
        printf("Failed to bind first socket. Try again?");
        exit(0);
    }

    //------------------------------------------------------------//
    // SOCKET NUMBER 2 (other_socket)                             //
    //------------------------------------------------------------//

    int other_socket = 0;

    // TCP again
    if((other_socket = socket(AF_INET, SOCK_STREAM, 0)) < 0)
    {
        printf("Second socket creation error!\n");
        exit(0);
    }

    // Part of this code adapted from:
    // https://code-examples.net/en/q/104e11e
    memset(&serv_addr, 0, sizeof(serv_addr));
    serv_addr.sin_addr.s_addr = htonl(INADDR_ANY);
    serv_addr.sin_family = AF_INET;
    serv_addr.sin_port = htons(port_number+1);
    // end of adapted code.
    struct timeval timer;
    timer.tv_sec = 60;
    timer.tv_usec = 0;

    if(setsockopt(other_socket,SOL_SOCKET,SO_RCVTIMEO,(char*)&timer,sizeof(timer))<0)
    {
        printf("Error with socket options.");
        exit(0);
    }

    if(bind(other_socket,(struct sockaddr*)&serv_addr,sizeof(struct sockaddr_in))==-1)
    {
        printf("There was a problem with the port, try another one!");
        exit(0);
    }

    if(listen(other_socket,2)==-1)
    {
        printf("Failed to bind second socket, try again?");
        exit(0);
    }
    //------------------------------------------------------------//
    // BEGIN CONNECTION                                           //
    //------------------------------------------------------------//
    else
    {
        printf("Ready to connect...\n");

        int new_socket;
        int success = 0;

        if((new_socket = accept(other_socket,NULL,NULL)) == -1)
        {
            printf("There was a problem connecting. Try again!");
            exit(0);
        }
        else
        {
            success++;
            printf("Connected successfully.\n");
            timer.tv_sec = 1;
            timer.tv_usec = 0;
            if(setsockopt(new_socket,SOL_SOCKET,SO_RCVTIMEO,(char*)&timer,sizeof(timer))<0)
            {
                printf("Error with socket options.");
                exit(0);
            }
        }

        //------------------------------------------------------------//
        // START WAITING FOR USER TO ADD CENSORED WORDS               //
        //------------------------------------------------------------//

        while(1)
        {
            if(success)
            {
                printf("Waiting for a command...\n");
                if(recv(new_socket, client_query, 2048, 0) > 0)
                {
                    printf("Received a command!\n");
                    if((client_query[0] == 'C' || client_query[0] == 'c') && client_query[1] == 'e'
                    && client_query[2] == 'n' && client_query[3] == 's' && client_query[4] == 'o' && client_query[5] == 'r') // Censor/censor
                    {
                        j = 0;
                        while(client_query[j+7] != '\n' && client_query[j+7] != '\r')
                        {
                            censored_words[word_count][j] = client_query[j+7];
                            j++;
                        }
                        censored_words[word_count][j] = '\0';

                        printf("'%s' is now a censored word.\n",&censored_words[word_count][0]);
                        word_count++;

                        continue;
                    }
                    if((client_query[0] == 'R' || client_query[0] == 'r') && client_query[1] == 'e' && client_query[2] == 's')
                    { // Reset/reset
                        word_count = 0;
                        printf("Reset all censored words!\nNow nothing is censored...\n");
                    }
                    else
                    {
                        printf("Unknown command!\n");
                    }
                }
            }
            if((other_socket = accept(main_socket,NULL,NULL))==-1)
            {
                printf("Error making connection with second socket!\n");
                exit(0);
            }

            //------------------------------------------------------------//
            // TALK TO BROWSER                                            //
            //------------------------------------------------------------//

            // fork() code adapted from the following website:
            // https://www.csl.mtu.edu/cs4411.ck/www/NOTES/process/fork/create.html
            pid = fork();
            if(pid==-1)
            {
                printf("Failed to fork!\n");
                exit(0);
            }
            if(pid>0)
            {
                close(other_socket);
            }
            // end of adapted code
            else
            {
                close(main_socket);
                while(recv(other_socket,http_req,2048,0) > 0)
                {
                    char* http_path = strtok(http_req,"\r\n");
                    if(sscanf(http_path,"GET http://%s",url)==1)
                    {
                        printf("Got website, URL is %s\n", url);
                    }
                    for(i=0;i<strlen(url);i++)
                    {
                        if(url[i]=='/')
                        {
                            strncpy(hostname,url,i);
                            hostname[i]='\0';
                            break;
                        }
                    }

                    //------------------------------------------------------------//
                    // CHECK IF CENSORED WORD IS IN THE URL                       //
                    //------------------------------------------------------------//

                    for(int w=0;w<word_count;w++)
                    {
                        printf("Scanning url for '%s'...\n",&censored_words[w][0]);
                        int pos = 0;
                        length = strlen(&censored_words[w][0]);
                        int found = 0;
                        for(int x=0;x<strlen(url);x++)
                        {
                            if(url[x]==censored_words[w][pos])
                            {
                                pos++;
                                found++;
                            }
                            else
                            {
                                pos = 0;
                                found = 0;
                            }
                            if(length == found)
                            {
                                bad_url = 1;
                                x = strlen(url);
                            }
                        }
                        if(bad_url == 1)
                        {
                            printf("There is a censored word in that url!!!\n");
                        }
                        else
                        {
                            printf("Scan complete, nothing found.\n");
                        }
                    }
                    // The following code is adapted from this website: (also a couple other small areas in this code):
                    // https://dailion.com/what-is-bzero-function-in-c/#What_is_Bzero_function_in_C
                    bzero(httppath, 500);

                    for(;i<strlen(url);i++)
                    {
                        strcat(httppath,&url[i]);
                        break;
                    }
                    if(bad_url)
                    {
                        printf("Redirecting to a safe website...\n");
                        strcpy(httppath,"/blocked/");
                    }
                    tcp = connecttcp(hostname,80);
                    if(tcp>0)
                    {
                        connecthttp(tcp, hostname, httppath);
                    }
                    else
                    {
                        printf("Could not make socket...\n");
                    }

                    bzero(head,2048);
                    head_len = 0;
                    head_status = 1;

                    while((input = read(tcp,output,2048)))
                    {
                        html = 0;
                        text = 0;
                        while(head_status == 1)
                        {
                            char* cursor = output;
                            for(i=0;i< input-4;i++)
                            {
                                if(strncmp(cursor+i,"\r\n\r\n", 4) ==0)
                                {
                                    strncpy(head,output,i);
                                    char* line = strtok(head,"\r\n");
                                    do
                                    {
                                        if(strstr(line,"Content-Length: "))
                                        {
                                            sscanf(line,"Content-Length: %s\n",output_len);
                                            output_len_int = atoi(output_len);
                                        }
                                        if(strstr(line,"Content-Type: "))
                                        {
                                            sscanf(line,"Content-Type: %s\n",type);
                                            type[10] = '\0';
                                            strcpy(holder,type);
                                            if(strcmp(holder,"text/plain") ==0)
                                            {
                                                text = 1;
                                            }
                                            else
                                            {
                                                text = 0;
                                            }
                                            type[9] = '\0';
                                            strcpy(holder,type);
                                            if(strcmp(holder,"text/html")==0)
                                            {
                                                html = 1;
                                            }
                                            else
                                            {
                                                html = 0;
                                            }
                                        }
                                    } while((line=strtok(NULL,"\r\n")));
                                    head_len+=i;
                                    strncpy(head_output,output,head_len+4);
                                    puts(head_output);
                                    head_status=0;
                                    i=input;
                                }
                            }
                        }

                        //------------------------------------------------------------//
                        // PROCESS THE FILE                                           //
                        //------------------------------------------------------------//

                        if(html == 1 || text == 1)
                        {
                            min = 0;
                            max = output_len_int-1;
                            tcp = connecttcp(hostname,80);
                            if(tcp>0)
                            {
                                bzero(output,2048);
                                connecthttp(tcp,hostname,httppath);
                            }
                            else
                            {
                                printf("Error with http request...\n");
                            }
                            input = read(tcp,output,2048);

                            for(head_len_final=0;head_len_final<input;head_len_final++)
                            {
                                if((output[head_len_final]=='\r')&&(output[head_len_final+1]=='\n')&&(output[head_len_final+2]=='\r')&&(output[head_len_final+3]=='\n'))
                                {
                                    break;
                                }
                            }
                            strncpy(&page[min],&output[head_len_final+4],input-(head_len_final+4));
                            info = input-(head_len_final+4);
                            while(info<output_len_int)
                            {
                                input = read(tcp,output,2048);
                                min=info;
                                strncpy(&page[min],&output[0],input);
                                max+=input;
                                info+=input;
                            }

                            //------------------------------------------------------------//
                            // RETURN THE PAGE                                            //
                            //------------------------------------------------------------//

                            bzero(page_return,2048);
                            strncpy(page_return,head_output,head_len+4);
                            strncpy(&page_return[head_len+4],page,output_len_int);
                            page_return[head_len+output_len_int+4]='\0';
                            puts(page_return);
                            send(other_socket,page_return,head_len+4+output_len_int,0);
                        }
                        else
                        {
                            send(other_socket,output,input,0);
                        }
                        bzero(output,2048);
                        bzero(http_req,2048);
                    }

                    //------------------------------------------------------------//
                    // CLOSE THE SOCKET                                           //
                    //------------------------------------------------------------//

                }

                close(other_socket);
                printf("Finished socket-proxy-server interaction.\n");
                exit(0);
            }
        }
    }
    printf("Reached end of main.");
}

int connecttcp(char address[], int port)
{
    struct sockaddr_in serv_addr;
    struct hostent *server;
    int sock = socket(AF_INET, SOCK_STREAM, 0);
    if(sock < 0)
    {
        printf("Socket error\n");
    }
    else printf("Socket success\n");
    server = gethostbyname(address);
    if(server == NULL)
        printf("Failed to get host\n");
    bzero((char*)&serv_addr, sizeof(serv_addr));
    serv_addr.sin_family = AF_INET;
    bcopy((char*)server -> h_addr, (char*)&serv_addr.sin_addr.s_addr, server->h_length);
    serv_addr.sin_port = htons(80);
    if(connect(sock,(struct sockaddr *)&serv_addr,sizeof(serv_addr)) < 0)
        printf("Error creating TCP socket with connect()\n");

    return sock;
}

int connecthttp(int sock, char name[], char httpath[])
{
    char out[2048];
    bzero(out, 2048);
    sprintf(out, "GET %s HTTP/1.1\r\nHost: %s\r\n\r\n", httpath, name);
    if(send(sock, out, strlen(out), 0) < 0)
        printf("error sending HTTP request over TCP socket\n");

    return 0;
}