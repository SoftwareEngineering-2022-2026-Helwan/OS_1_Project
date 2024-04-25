
void printServiceHeader()
{
	printf("\n|----------( Process Control )----------|\n");
}


void printListHeader()
{
	printf("\n|----------( Process List )----------|\n");
}
void printMainMenu()
{
	printf("\n|----------( Main Menu )----------|\n\n0) Exit\n1) List all processes.\n2) List processes of Specific user.\n3) List Processes Ids.\n4) Start or Stop Specific Process.\n5) Send Signal To Specific Process.\n");
}

void printServiceMenu()
{
        printf("\n|----------( Control options )----------|\n\n0) Back.\n1) Start process.\n2) Stop process\n");
}


void printSignalMenu()
{
	printf("\n|----------( Signal Menu )----------|\n\n0) Back.\n1) Stop.\n2) Interput.\n3) Abort.\n4) Quit.\n5) Continue.\n6) Terminate.\n7) Kill.\n8) Hang Up.\n9) Trap.\n");
}