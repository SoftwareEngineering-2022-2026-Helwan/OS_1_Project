#include<stdlib.h>
#include<string.h>

int optionValidation( int min, int max)
{
	int option = 0;
	char* sOption = (char*) malloc(2);
	

	do
	{
		printf("\n[+] Option: ");
		scanf("%s",sOption);
		option = ((int) *sOption) - 48;
		if(option > max || option < min)
		{
			printf("\n[!] Invalid Option!\n");
		}
	}while(option > max || option < min);
	
	return option;

}

void getGroupName(char** groupName)
{
	*groupName = (char *) malloc(1000);

	printf("[+] Enter Group Name: ");
	scanf("%s",*groupName);
}

void getServiceName(char** serviceName)
{
        *serviceName = (char *) malloc(5000);
                                                                
	printf("\n[+] Enter process name : ");
        scanf(" %[^\n]",*serviceName);
}

int startServiceNow()
{
	int option;
	do
	{
		printServiceMenu();
		option = optionValidation(0,2);

		if(option == 1) 
		{
			return 1;
		}
		else if(option == 2) 
		{
			return 0;
		}

	}while(option != 0);
	return -1;
}


String selectedSignal(int choice)
{
	switch(choice)
	{
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
	}
	
	return "Invalid";
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