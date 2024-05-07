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
			String manual = (String) malloc(255);
			getAppName(&manual,argv[0]);
			
			//display manual 
			system(manual);
			free(manual);
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
	String command = (String) malloc(5000), userName, processName;
	do
	{
		start = -2;
		printMainMenu();
		option = optionValidation(0,5);
	
		switch(option)
		{
			case 1:

				displayAllProcess(&command);

				break;
			case 2:
				
				getUserName(&userName);
				displayAllProcessByGroup(&command,userName);
				
				free(userName);
				break;
			case 3:

				displayAllProcessId(&command);          
				
				break;
			case 4:
				//[!] if service is started shall we start it again 
				printServiceHeader();
				getProcessName(&processName);
				start = startServiceNow();
				if(start == 1)
				{
					startProcess(&command,processName);

				}
				else if( start == 0)
				{	
					printf("\n[~] Stoping : %s\n",processName);

					stopProcess(&command, processName);
					free(processName); 
				}
				

				break;
			case 5:
				printServiceHeader();
				getProcessName(&processName); 

				printSignalMenu();
				int choice = optionValidation(0,9);

				if ( choice == 0)
				{
					free(processName);
					continue;
				} 
				sendSignal(selectedSignal(choice), &command, processName);

				printf("\n[-->] Sending %s Signal to %s\n",selectedSignal(choice),processName);

				free(processName);
				break;
			
		}

		if(option != 0 && start != -1 )
		{

			if(start == 1)
			{
				sprintf(command,"%s ;%s%s%s",command,IS_PROCESS_UP_PART1,processName,IS_PROCESS_UP_PART2);	
				free(processName);
			}

			system(command);

			free(command);
		}
		

	}while(option != 0);

	return 0;
}
