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
	printListHeader();

}


void displayAllProcessId(String *command)
{
	sprintf(*command,"%s %s",PS,PS_IDS_OPTION);
	printListHeader();
}



void startProcess(String *command, String serviceName)
{
	strcpy(*command , serviceName);
    strcat(*command , " &");
}

void stopProcess(String *command, String processName)
{
    strcpy(*command ,PKILL);
    strcat(*command ,SIG_KILL);
    strcat(*command , processName);

}

void sendSignal(String signal, String *command, String processName)
{
	sprintf(*command, "%s%s \"%s\"",PKILL,signal,processName); 
	
}


