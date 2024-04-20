#include "command.h"
#include<stdlib.h>
#include<string.h>

// |--------( Waiting for Doctor to use simple way )--------|

// void getProcessId(String* getServiceID, String serviceName);
// void IsProcessRun(String serviceName);
// void prepareCommandWithProcessId(String *command, String getProcessId);


void displayAllProcess(String *command)
{
	
}

void displayAllProcessByGroup(String *command, String groupName)
{
	
	
}


void displayAllProcessId(String *command)
{
	
}

void startProcess(String *command, String serviceName)
{
	strcpy(*command , serviceName);
    strcat(*command , " &");
    system(*command);
    free(*command);
}

void stopProcess(String *command, String processName)
{
    strcpy(*command ,PKILL);
    strcat(*command ,SIG_STOP);
    strcat(*command , processName); 
    system(*command);
    free(*command);
}

void sendSignal(String signal, String *command)
{
	strcpy(*command ,PKILL);
    strcat(*command ,signal); 
    system(*command);
    free(*command);
}
