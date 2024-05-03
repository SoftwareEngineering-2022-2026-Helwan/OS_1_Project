import java.util.*;
import java.awt.*;
import java.io.*;


public class Main
{
    public static void main(String[] args) 
    {
        if(true)
        {
            Debug.startDebug(1);
        }
    }
}



class Debug
{

    public static void startDebug(int task)
    {
        System.out.println("[!] Task"+task);
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


    // |----------( Task methods )----------|
    static void task1()
    {
        InputFrame i = new InputFrame();
        i.setBounds(new Rectangle(800,600));
        i.setLocationRelativeTo(null);
    }
    static void task2()
    {

        CPU cpu = new CPU();
    }

}
