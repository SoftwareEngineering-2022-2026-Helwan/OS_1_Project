#include "command.h"
#include<stdlib.h>
#include<string.h>

void getProcessId(String* getServiceID, String serviceName)
{
	*getServiceID = (char *) malloc(1000);
	strcpy( *getServiceID, SET_PROCESS_NAME);
	strcat( *getServiceID, serviceName);
	strcat( *getServiceID, CLOSE_QUOTE);
	strcat( *getServiceID, " && ");
					
}

void sendSignal(String signal, String *command)
{
    strcpy( *command, KILL);
	strcat( *command, signal); 
	strcat( *command, GET_PROCESS_ID);
}


void displayAllProcess(String *command)
{
	strcpy(*command,PS);
	strcat(*command,PS_ALL_OPTION);
	printListHeader();
}

void displayAllProcessByGroup(String *command, String groupName)
{
	
	strcpy(*command,PS);
	strcat(*command,PS_GROUP_OPTION);
	strcat(*command,groupName);
	printListHeader();

}


void displayAllProcessId(String *command)
{
	strcpy( *command, PS);
	///print id of aux or -A
	//strcat( *command, PS_ALL_OPTION);
	strcat( *command, PS_IDS_OPTION);
	printListHeader();
}

void startProcess(String *command, String serviceName)
{
	printf("\n[~] Starting : %s\n",serviceName);
	strcpy(*command,START_BACKGROUND_PROCESS_PART1);
	strcat(*command,serviceName);
	strcat(*command,START_BACKGROUND_PROCESS_PART2);
}

void IsProcessRun(String serviceName)
{
	String command = (String) malloc(500);

	strcpy(command, IS_PROCESS_UP_PART1);
	strcat(command,serviceName);
	strcat(command,IS_PROCESS_UP_PART2);

	system(command);

	free(command);
}