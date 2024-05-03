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
            case 3:
                task6();
                task6_b();
                task6_c();
                break;
            case 9:
                task9();
                break;
            case 10:
                task3();
                break;
            case 7:
                task7();
                break;
            case 8:
                task8();
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
        pt.add(new ProcessTable("process1",0,6));
        pt.add(new ProcessTable("process2",4,6));
        pt.add(new ProcessTable("process1",7,10));
        pt.add(new ProcessTable("process3",11,15));
        pt.add(new ProcessTable("process3",13,15));
        pt.add(new ProcessTable("process2",16,20));
        pt.add(new ProcessTable("process3",15,15));

        pt = ProcessTable.sortProcessTable(pt);

        System.out.println(pt.toString());
    }

    static void task6_b()
    {
        ArrayList<Process> arrival = new ArrayList<>();

        arrival.add(new Process("p1",0,4));
        arrival.add(new Process("p2",1,4));
        arrival.add(new Process("p3",0,4));
        arrival.add(new Process("p4",2,4));
        arrival.add(new Process("p5",1,4));

        CPU cpu = new CPU(arrival,0);

        cpu.sortArrivalQueue();

        System.out.println(arrival.toString());
    }
    static void task6_c()
    {

        LinkedList<Process> arrival = new LinkedList<>();

        arrival.add(new Process("p1",0,4));
        arrival.add(new Process("p2",1,4));
        arrival.get(1).setWasActive(0);
        arrival.add(new Process("p3",0,4));
        arrival.add(new Process("p4",2,4));
        arrival.add(new Process("p5",1,4));



        CPU cpu = new CPU();
        cpu.setReadyQueue(arrival);
        System.out.println("ret = "+ cpu.getWasActiveProcess() +" was active now: "+ arrival.get(1).getWasActive());


    }

    static void task9()
    {
        ArrayList<Process> arrival = new ArrayList<>();

        arrival.add(new Process("p1",0,4));
        arrival.get(0).setFinalResponseTime(19);
        arrival.get(0).setFinalWaitingTime(5);
        arrival.get(0).setFinalTurnAroundTime(2);
        arrival.add(new Process("p2",1,4));
        arrival.get(1).setFinalResponseTime(29);
        arrival.get(1).setFinalWaitingTime(25);
        arrival.get(1).setFinalTurnAroundTime(22);
        arrival.add(new Process("p3",0,4));
        arrival.get(2).setFinalResponseTime(90);
        arrival.get(2).setFinalWaitingTime(50);
        arrival.get(2).setFinalTurnAroundTime(20);
        arrival.add(new Process("p4",2,4));
        arrival.get(3).setFinalResponseTime(49);
        arrival.get(3).setFinalWaitingTime(45);
        arrival.get(3).setFinalTurnAroundTime(42);
        arrival.add(new Process("p5",1,4));
        arrival.get(4).setFinalResponseTime(39);
        arrival.get(4).setFinalWaitingTime(76);
        arrival.get(4).setFinalTurnAroundTime(7);

        ArrayList<ProcessTable> pt = new ArrayList<>();
        pt.add(new ProcessTable("process1",0,2));
        pt.add(new ProcessTable("process1",6,15));
        pt.add(new ProcessTable("process2",2,4));
        pt.add(new ProcessTable("process3",4,10));

        pt = ProcessTable.sortProcessTable(pt);

        CPU cpu = new CPU(arrival,0);

        cpu.setProcessTableList(pt);
        cpu.setMaxClock(15);

        cpu.setTotalAverageWaitingTime(19.5);
        cpu.setTotalAverageTurnAroundTime(30.0);
        cpu.setTotalAverageResponseTime(9.5);
        System.out.println(cpu.toString());

        ReportFrame r = new ReportFrame(cpu);
        r.setLocationRelativeTo(null);
    }

    static void task3()
    {
        Process p1 = new Process("p1",0,4);
        Process p2 = new Process("p2",1,2);
        Process p3 = new Process("p3",1,2);

        ArrayList<Process> pl = new ArrayList<>();
        pl.add(p1);
        pl.add(p2);
        pl.add(p3);

        CPU cpu = new CPU(pl,2);


        TimeInterpretur timeInterpretur = new TimeInterpretur(cpu);

        cpu.setRemainingProcess(3);

        //clock 0
        timeInterpretur.processHandler(p1);
        timeInterpretur.processHandler(p2);
        timeInterpretur.processHandler(p3);


        //clock 1
        timeInterpretur.processHandler(p1);
        timeInterpretur.processHandler(p2);
        timeInterpretur.processHandler(p3);

        //clock 2
        timeInterpretur.processHandler(p1);
        cpu.setCurrentIndex(cpu.getNextIndex());
        timeInterpretur.processHandler(p2);
        timeInterpretur.processHandler(p3);


        System.out.println(cpu.toString());



    }

    static void task7()
    {
        Process p1 = new Process("p1",0,4);
        p1.setFinalWaitingTime(1);
        p1.setFinalTurnAroundTime(4);
        p1.setFinalResponseTime(0);
        Process p2 = new Process("p2",1,2);
        p2.setFinalWaitingTime(1);
        p2.setFinalTurnAroundTime(6);
        p2.setFinalResponseTime(2);
        Process p3 = new Process("p3",1,2);
        p3.setFinalWaitingTime(2);
        p3.setFinalTurnAroundTime(8);
        p3.setFinalResponseTime(4);

        LinkedList<Process> pl = new LinkedList<>();
        pl.add(p1);
        pl.add(p2);
        pl.add(p3);

        CPU cpu = new CPU();

        cpu.setWaitingQueue(pl);

        double time = cpu.calculateAverageWaitingTime();
        System.out.print("\nwaiting: ") ;
        System.out.printf("%.3f",time) ;

        time = cpu.calculateAverageResponseTime();
        System.out.print("\nresponse: ") ;
        System.out.printf("%.3f",time) ;


        time = cpu.calculateAverageTurnAroundTime();
        System.out.print("\nTurnAround: ") ;
        System.out.printf("%.3f",time) ;

    }

    static void  task8()
    {
        ArrayList<ProcessTable> pt = new ArrayList<>();
        pt.add(new ProcessTable("process1",0,2));
        pt.add(new ProcessTable("process1",6,15));
        pt.add(new ProcessTable("process2",2,4));
        pt.add(new ProcessTable("process3",4,10));

        pt = ProcessTable.sortProcessTable(pt);
        CPU cpu = new CPU();
        cpu.setProcessTableList(pt);
        cpu.setMaxClock(15);
        GanttChart gc=new GanttChart(cpu);
    }

}
