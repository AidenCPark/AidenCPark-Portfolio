UDP Micro Servers
created by Aiden Park


--- Summary ---

This program provides three unique "micro services" that run via UDP and an indirection server. It has a translator that allows the user to translate pre-defined words from English to French, a currency converter that can convert between 5 different currencies (USD, CAD, GBP, EUR, BTC), and a voting system that requires users to vote before you can view results.


--- How to Run ---

Check micro-server.c and ensure that MICRO_IP is defined as the IP address of the machine that you will be running the micro servers on.

Navigate to the directory where all 5 C files are located, and compile using the "make" command (makefile provided).

Run each of the micro servers and the main server using "./micro-server", "./micro-translator" etc. Then, run your client with the command "./micro-client [IP] [PORT]" where [IP] is the IP of the server and [PORT] is the port of the server (8810 by default).


--- How to Use ---

If connected successfully, the client should now display a main menu that can be interacted with by typing the number you want to choose and pressing enter. The options are the three micro servers provided (Translator, Currency Converter, and Voting Services) and you can exit the client by entering 0.


--- What I Learned ---

This project was my first experience working with UDP. It allowed me to improve upon my socket programming and gave me more experience working with servers. Up until this point I was only working with programs running on my machine, so it was an interesting experience working with servers running on multiple different machines on different networks.