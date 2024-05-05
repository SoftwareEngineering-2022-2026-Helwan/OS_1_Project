#include "command.h"
#include<stdlib.h>
#include<string.h>



void displayAllProcess(String *command)
{
	strcpy(*command,PS);
	strcat(*command,PS_ALL_OPTION);
	printListHeader();
}

void displayAllProcessByGroup(String *command, String userName)
{
	
	strcpy(*command,PS);
	strcat(*command,PS_USER_OPTION);
	strcat(*command,userName);
	strcat(*command," | less");
	printListHeader();

}


void displayAllProcessId(String *command)
{
	sprintf(*command,"%s %s",PS,PS_IDS_OPTION);
	printListHeader();
}



void startProcess(String *command, String serviceName)
{
	sprintf(*command,"%s%s%s",START_BACKGROUND_PROCESS_PART1,serviceName,START_BACKGROUND_PROCESS_PART2);
}

void stopProcess(String *command, String processName)
{

	sprintf(*command, "(%s%s\"%s\") &>/dev/null",PKILL,SIG_KILL,processName);

}

void sendSignal(String signal, String *command, String processName)
{
	sprintf(*command, "(%s%s\"%s\") &>/dev/null",PKILL,signal,processName); 
	
}


