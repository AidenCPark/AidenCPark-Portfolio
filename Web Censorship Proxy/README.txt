Web Censorship Proxy
created by Aiden Park


--- Summary ---

This proxy will read the URL of any website accessed while it is running, and prevent the user from accessing it if it contains a blocked keyword. The user has the ability to set the keywords to be censored.


--- How to Run ---

Go to your browser's proxy settings (different depending on which browser) and manually add an HTTP proxy with your IP and port of choosing. (For example, port 8500)

Navigate to the directory where censor.c is located. Use the command-line command "cc -o censor censor.c" to compile.

Type the command "./censor (PORT NUMBER)" where (PORT NUMBER) is your chosen port. For example, for port 8500, type "./censor 8500"

The window should now display "Ready to connect..." (if not, try a different port). Open a second command line window, and type the command "telnet (IP) (PORT+1)" where (IP) is your IP address and (PORT) is your chosen port + 1 (for example, if you chose 8500, enter 8501). This is because a second socket is used to listen for commands, hence it has a different port number.


--- How to Use ---

The proxy can take the following commands:
censor (word)
reset
The censor command takes any word as input, and will stop the webpage from loading if a URL containing that word is encountered.
The reset command will remove all censored words (if any), and has no arguments.

NOTE: This proxy will only work on HTTP websites. It will have no effect on encrypted HTTPS pages.


--- What I Learned ---

In this project, I got a great deal of experience working with proxies, socket programming, and writing in C. I worked with TCP/IP and had to exercise my skills in network debugging in order to get the proxy to work successfully.