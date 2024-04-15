#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include "lib/menu.c"
#include "lib/command.h"
#include "lib/validation.c" 
#include "lib/processUtils.c" 

int main(int argc, String argv[])
{
	if( argc == 2)
	{
		if ( !strcmp(argv[1],"-h") )
		{
			String program = (String) malloc(strlen(argv[0]));
			String manual = (String) malloc(255);
			strcpy(manual,"man ");
			
			int length = strlen(argv[0])-2;
			strncpy(program,argv[0]+2,length);
			program[length+1] = '\0';
			
			strcpy(manual,program);
			system(manual);
			
			free(manual);
			free(program);
			return 1;
		}
		else
		{
			printf("\n[!] Invalid Flag\n");
			printf("To Run ( Main App ): %s\n",argv[0]);
			printf("To Run ( Help Menu ): %s -h",argv[0]);		
			return -1;
		}
	}

	int option, start;
	String command = (String) malloc(500), groupName, serviceName, getServiceID;
	do
	{
		printMainMenu();
		option = optionValidation(0,5);
	
		switch(option)
		{
			case 1:

				displayAllProcess(&command);

				break;
			case 2:
				
				getGroupName(&groupName);
				displayAllProcessByGroup(&command,groupName);
				
				free(groupName);
				break;
			case 3:

				displayAllProcessId(&command);          
				
				break;
			case 4:
				//[!] if service is started shall we start it again 
				printServiceHeader();
				getServiceName(&serviceName);
				start = startServiceNow();
				if(start == 1)
				{
					startProcess(&command,serviceName);

				}
				else if( start == 0)
				{	
					printf("\n[~] Stoping : %s\n",serviceName);

					// Store service id in ENV variable 
					getProcessId( &getServiceID,serviceName);

					//stop the process	
					sendSignal(selectedSignal(1), &command);

					// run the env save and execute in the same time due to session per system call
					prepareCommandWithProcessId(&command,getServiceID);

					free(getServiceID);
					free(serviceName);
					
				}
				

				break;
			case 5:
				printServiceHeader();
				getServiceName(&serviceName); 

				printSignalMenu();
				int choice = optionValidation(0,9);

				// Store service id in ENV variable 
				getProcessId( &getServiceID,serviceName);
				//stop the process	
				sendSignal(selectedSignal(choice), &command);

				// run the env save and execute in the same time due to session per system call
				prepareCommandWithProcessId(&command,getServiceID);

				printf("\n[-->] Sending %s Signal to %s\n",selectedSignal(choice),serviceName);
				
				free(getServiceID);
				free(serviceName);
					

				break;
			
		}

		if(option != 0)
		{
			system(command);

			if(option == 4 && start == 1)
			{
				IsProcessRun(serviceName);

				free(serviceName);
			}
		}
		

	}while(option != 0);

	free(command);
	return 0;
}
