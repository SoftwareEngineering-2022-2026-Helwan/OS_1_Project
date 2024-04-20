package lib;

public class Debug
{

    public void startDebug(int task)
    {
        System.out.println("[!] Task"+task+"\n");
        switch(task)
        {
            case 1:
                task1();
                break;
            case 2:
                task2();
                break;
            case 3: 
                task1();
                task2();
                break;
            
        }
    }


    // |----------( Task methods )----------|
    void task1()
    {
        System.out.println("Option menu");
    }

    void task2()
    {
        System.out.println("validation menu");
    }
}
