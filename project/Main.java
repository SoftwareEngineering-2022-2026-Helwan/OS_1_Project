import java.util.*;
import java.awt.*;
import java.io.*;


public class Main
{
    public static void main(String[] args) 
    {
        if(true)
        {
            Debug.startDebug(3);
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
            case 3:
                task6();
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

    static void task6(){
        ArrayList<ProcessTable> pt = new ArrayList<>();
        pt.add(new ProcessTable("process1",0,3));
        pt.add(new ProcessTable("process2",4,6));
        pt.add(new ProcessTable("process1",7,10));
        pt.add(new ProcessTable("process3",11,15));
        pt.add(new ProcessTable("process2",16,20));

        pt = pt.get(1).sortProcessTable(pt);

        System.out.println(pt.toString());
    }
}
