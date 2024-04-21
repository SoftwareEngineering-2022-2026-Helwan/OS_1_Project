#include <stdio.h>
#include "command.h"

// |--------( Test Methods )--------|
void task1()
{
    printf("\noption menu");
}

void task2()
{
    printf("\nsignal validation menu");
}

void test3()
{
    task1();
    task2();
}


void test4()
{
    String name = (String)malloc(500);

    strcpy(name,selectedSignal(10));

    printf("\n name = %s", name);


    // printf("\nyour choice: %d",optionValidation(0,6));
}

// |--------( Debug Methods )--------|

void debug(int task)
{
    printf("\n[!] Task%d:\n",task);
    switch(task)
    {
        case 1:
            task1();
            break;
        case 2:
        
            task2();
            break;
        case 3: 
            test3();
            break;
        case 4:
            test4();
            break;
    }
}


