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
