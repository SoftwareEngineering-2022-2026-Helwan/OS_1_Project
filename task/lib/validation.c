#include<stdlib.h>
#include<string.h>

int optionValidation( int min, int max)
{
	
}

void getGroupName(String* groupName)
{
	
}

void getProcessName(String* serviceName)
{
        
}



String selectedSignal(int choice)
{
	
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