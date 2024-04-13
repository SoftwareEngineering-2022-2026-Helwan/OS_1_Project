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

int startService()
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
