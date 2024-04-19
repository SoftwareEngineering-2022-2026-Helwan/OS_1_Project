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
        
    }
}


