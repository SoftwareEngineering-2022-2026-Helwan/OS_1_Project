#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include "lib/menu.c"
#include "lib/command.h"
#include "lib/validation.c" 
#include "lib/processUtils.c" 
#include "lib/debug.c"

int main(int argc, String argv[])
{
	if( argc >= 2)
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
		else if  ( !strcmp(argv[1],"-d") )
		{
			debug( atoi(argv[2]) );
		}
		else
		{
			printf("\n[!] Invalid Flag\n");
			printf("To Run ( Main App ): %s\n",argv[0]);
			printf("To Run ( Help Menu ): %s -h",argv[0]);		
			return -1;
		}
	}

	
	return 0;
}
