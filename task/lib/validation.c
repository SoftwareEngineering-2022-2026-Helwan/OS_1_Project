#include<stdlib.h>
#include "command.h"
#include<string.h>
#include<ctype.h>
#include<stdio.h>

int optionValidation( int min, int max)
{
	String choice = (String)malloc(500);
	int ch;
	do{
		printf("\nEnter your choice: ");
		scanf("%s",choice);
		
		if(sscanf(choice,"%d",&ch)!=1)
		{
			ch=-1;
		}
		// c atoi(choice);
		
		if((ch < min || ch > max)){
			printf("\nInvalid input.\n");
		}
		

		

	}while(ch < min || ch > max);
	return ch;
}

void getGroupName(String* groupName)
{
	*groupName = (String)malloc(500);
	printf("\nEnter Group Name: ");
	scanf("%s",*groupName);
}

void getProcessName(String* serviceName)
{
    *serviceName = (String)malloc(500);
	printf("\nEnter Process Name: ");
	scanf("%s",*serviceName);   
}



String selectedSignal(int choice)
{
	switch(choice){
		case 1:
		return SIG_STOP;
		case 2:
		return SIG_INTURUPT;
		case 3:
		return SIG_ABORT;
		case 4:
		return SIG_QUIT;
		case 5:
		return SIG_CONTINUE;
		case 6:
		return SIG_TERMINATE;
		case 7:
		return SIG_KILL;
		case 8:
		return SIG_HANGUP;
		case 9:
		return SIG_TRAP;
		default:
		return "Invalid input.";
	}
}

void getAppName(String *manual, String arg0)
{
	String program = (String) malloc(strlen(arg0));
	strcpy(*manual,"man ");
			
	int length = strlen(arg0)-2;
	strncpy(program,arg0+2,length);
	program[length+1] = '\0';
	
	strcat(*manual,program);	
}