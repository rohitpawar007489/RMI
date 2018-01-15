Readme Instructions

1) Login to tesla and download code PawarA3.zip

2) Unzip PawarA3.zip

3) Now change current directory to PawarA3 using command cd PawarA3

4) Now login to 10.234.136.55 [This machine will act as a server]

5) To Compile Files:
   a) Run command: chmod +x CompileFiles.sh
   b) Run command: ./CompileFiles.sh

6) Start RMI Registry 
   a) Run command: chmod +x StartRmiRegistry.sh
   b) Run command: ./StartRmiRegistry.sh

7) Open another putty terminal and login to machine 10.234.136.55

8) Repeat Step 2 and Step 3 

9) To run server
   a) Run command: chmod +x ExecuteServer.sh
   b) Run command: ./ExecuteServer.sh

7) Login to any other provided machine for our lab i.e.
   10.234.136.56
   10.234.136.57
   10.234.136.58
   10.234.136.59
   10.234.136.60

8) Repeat step 2 and step 3

9) To run client:
   a) Run command: chmod +x ExecuteClient.sh
   b) Run command: ./ExecuteClient.sh

10) To Run Multiple client repeat step 7 to step 9

Note: Server should run on IP 10.234.136.55 as makefile for client contain this IP.
