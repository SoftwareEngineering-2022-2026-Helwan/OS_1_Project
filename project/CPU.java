import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class CPU
{

    // |----------------( variables )----------------|

    private Queue<Process> readyQueue = new LinkedList<>();

    private Queue<Process> finishedQueue = new LinkedList<>();

    public Queue<Process> waitingQueue = new LinkedList<>();

    public ArrayList<Process> arrivalQueue = new ArrayList<>();

    private Process currentProcess;

    private static int nextIndex = 0;

    private static int currentIndex = 0;

    private  int remainingProcess = 0;

    public ArrayList<ProcessTable> processTableList = new ArrayList<>();

    private int clock = 0;

    private int maxClock = 0;

    private int currentProcessStartTime = -1;

    private int currentProcessEndTime = -1;

    public int timeQuantum = 0;

    private double totalAverageWaitingTime;

    private double totalAverageResponseTime;

    private double totalAverageTurnAroundTime;

    public TimeInterpretur timeInterpretur;

    // |----------------( Methods )----------------|

    CPU()
    {
    }

    CPU(ArrayList<Process> arrivalQueue, int timeQuantum)
    {
        this.arrivalQueue = arrivalQueue;
        sortArrivalQueue();

        setMaxClock(calculateMaxClock(arrivalQueue));

        this.timeQuantum = timeQuantum;
        timeInterpretur = new TimeInterpretur(this);
    }


    // |----------------( Variable--Methods )----------------|

    private int calculateMaxClock(ArrayList<Process> arrivalList)
    {
        int index = 0, maxClockCounter = 0;
        while (index < arrivalList.size())
        {
            maxClockCounter += arrivalList.get(index).getBurstTime();
            index++;
        }
        return maxClockCounter;
    }
    public double getTotalAverageWaitingTime() {
        return totalAverageWaitingTime;
    }

    public void setTotalAverageWaitingTime(double totalAverageWaitingTime) {
        this.totalAverageWaitingTime = totalAverageWaitingTime;
    }

    public double getTotalAverageResponseTime() {
        return totalAverageResponseTime;
    }

    public void setTotalAverageResponseTime(double totalAverageResponseTime) {
        this.totalAverageResponseTime = totalAverageResponseTime;
    }

    public double getTotalAverageTurnAroundTime() {
        return totalAverageTurnAroundTime;
    }

    public void setTotalAverageTurnAroundTime(double totalAverageTurnAroundTime) {
        this.totalAverageTurnAroundTime = totalAverageTurnAroundTime;
    }

    public Queue<Process> getReadyQueue() {
        return readyQueue;
    }

    public void setReadyQueue(Queue<Process> readyQueue) {
        this.readyQueue = readyQueue;
    }

    public Queue<Process> getFinishedQueue() {
        return finishedQueue;
    }

    public void setFinishedQueue(Queue<Process> finishedQueue) {
        this.finishedQueue = finishedQueue;
    }

    public Queue<Process> getWaitingQueue() {
        return waitingQueue;
    }

    public void setWaitingQueue(Queue<Process> waitingQueue) {
        this.waitingQueue = waitingQueue;
    }

    public ArrayList<Process> getArrivalQueue() {
        return arrivalQueue;
    }

    public void setArrivalQueue(ArrayList<Process> arrivalQueue) {
        this.arrivalQueue = arrivalQueue;
    }

    public Process getCurrentProcess() {
        return currentProcess;
    }

    public void setCurrentProcess(Process currentProcess) {
        this.currentProcess = currentProcess;
    }

    public  int getNextIndex() {
        return nextIndex;
    }

    public  void setNextIndex(int nextIndex) {
        this.nextIndex = nextIndex;
    }

    public  int getCurrentIndex() {
        return currentIndex;
    }

    public  void setCurrentIndex(int currentIndex) {
        this.currentIndex = currentIndex;
    }

    public  int getRemainingProcess() {
        return remainingProcess;
    }

    public  void setRemainingProcess(int remainingProcess) {
        this.remainingProcess = remainingProcess;
    }

    public ArrayList<ProcessTable> getProcessTableList() {
        return processTableList;
    }

    public void setProcessTableList(ArrayList<ProcessTable> processTableList) {
        this.processTableList = processTableList;
    }

    public int getClock() {
        return clock;
    }

    public void setClock(int clock) {
        this.clock = clock;
    }

    public  int getMaxClock() {
        return maxClock;
    }

    public void setMaxClock(int maxClock) {
        this.maxClock = maxClock;
    }

    public int getCurrentProcessStartTime() {
        return currentProcessStartTime;
    }

    public void setCurrentProcessStartTime(int currentProcessStartTime) {
        this.currentProcessStartTime = currentProcessStartTime;
    }

    public int getCurrentProcessEndTime() {
        return currentProcessEndTime;
    }

    public void setCurrentProcessEndTime(int currentProcessEndTime) {
        this.currentProcessEndTime = currentProcessEndTime;
    }

    public int getTimeQuantum() {
        return timeQuantum;
    }

    public void setTimeQuantum(int timeQuantum) {
        this.timeQuantum = timeQuantum;
    }

    public int getWasActiveProcess()
    {
        //if process was active and one arrival
        int ret = 0;
        if(!readyQueue.isEmpty())
        {
            LinkedList<Process> q2 = new LinkedList<>();
            Process p, wP = null;
            int i;
            
            for(i= 0;  !readyQueue.isEmpty();i++){
                p = readyQueue.remove();
                if(p.getWasActive() == 1){
                    ret = 1;
                    p.setWasActive(0);
                    wP = p;
                    if(readyQueue.isEmpty())
                    {
                        q2.add(wP);
                    }
                        continue;
                }

                q2.add(p);

                if(p.getArrivalTime() == clock && wP != null)
                {
                    q2.add(wP);
                    wP = null;
                }



            }

            readyQueue.addAll(q2);
            q2.clear();
        }

        if(!waitingQueue.isEmpty())
        {
            LinkedList<Process> q2 = new LinkedList<>();
            Process p;

            for(int i = 0;  !waitingQueue.isEmpty();i++){
                p = waitingQueue.remove();
                if(p.getWasActive() == 1){
                    ret = 1;
                    p.setWasActive(0);
                }
                q2.add(p);
            }
            waitingQueue.addAll(q2);
            q2.clear();
        }

        return ret;
    }

    public void sortArrivalQueue()
    {
        arrivalQueue.sort(Process::compareTo);        
    }

    // |----------------( Class--Methods )----------------|

    public void startProcess()
    {
        //reset variable to default
        setDefaultValues();

        do
        {
            //fill ready queue

            updateReadyQueue();

            //reset the was active variable
            if(getWasActiveProcess() == 1)
            {
                setCurrentIndex(0);
            }

            do
            {
                if(!readyQueue.isEmpty())
                {
                    handleReadyQueue();
                }

            }while (!readyQueue.isEmpty());


            if(!finishedQueue.isEmpty())
            {
                readyQueue.addAll(finishedQueue);
                finishedQueue.clear();
            }



            clock++;
        }while (maxClock >= clock);

        buildReport();

    }

    private void setDefaultValues()
    {
        currentProcess = null;

        nextIndex = 0;
        currentIndex = 0;

        totalAverageWaitingTime = 0.0;
        totalAverageTurnAroundTime = 0.0;
        totalAverageResponseTime = 0.0;

        currentProcessStartTime = -1;
        currentProcessEndTime = -1;

        clock = 0;
    }

    private void updateReadyQueue()
    {

        while (!arrivalQueue.isEmpty())
        {
            currentProcess = arrivalQueue.remove(0);

            if (clock >= currentProcess.getArrivalTime()) {
                readyQueue.add(currentProcess);
                remainingProcess++;
            } else {
                arrivalQueue.add(0, currentProcess);
                break;
            }
        }
    }

    private void handleReadyQueue()
    {
        currentProcess = readyQueue.remove();
        if(currentProcess != null)
        {
            processHandler(currentProcess);
        }

        if(getCurrentIndex() != -1)
        {
            if(remainingProcess != 0)
            {
                setCurrentIndex( (getCurrentIndex() + 1) % remainingProcess );
            }
        }
    }

    private void processHandler(Process process)
    {
        timeInterpretur.processHandler(process);
        if(process.getStatus()== 1){
            activeProcessHandler(process);
        }
        else {
            waitingProcessHandler(process);
        }

        if( TimeInterpretur.consumedQuantum == 0 && process.getWasActive() == 1 ){
            updateProcessTable(process);

            if(process.getBurstTime() != 0)
            {
                if(readyQueue.isEmpty())
                {
                    finishedQueue.add(process);
                    return;
                }
                readyQueue.add(process);
                return;
            }
        }

        if(process.isFinished()){
            if(TimeInterpretur.consumedQuantum < timeInterpretur.getTimeQuantum())
            {
                updateProcessTable(process);
                TimeInterpretur.consumedQuantum = timeInterpretur.getTimeQuantum();
                timeInterpretur.processHandler(process);
            }

            process.setFinalTurnAroundTime(clock - process.getArrivalTime()+ 1);
            waitingQueue.add(process);
        }
        else {
            finishedQueue.add(process);
        }
    }


    private void activeProcessHandler(Process process)
    {
        if(process.getFinalResponseTime() == -1)
        {
            process.setFinalResponseTime(clock);
        }

        if (getCurrentProcessStartTime() == -1)
        {
            setCurrentProcessStartTime(clock);
        }

    }

    private void waitingProcessHandler(Process process)
    {
        if(process.getWasActive() != 1)
        {
            process.setFinalWaitingTime( process.getFinalWaitingTime() + 1 );
        }
    }

    private void updateProcessTable(Process process)
    {
        if(getCurrentProcessStartTime() == -1)
        {
            return;
        }

        setCurrentProcessEndTime(clock+1);
        processTableList.add
        (
            new ProcessTable
            (
                process.getProcessName(),
                getCurrentProcessStartTime(),
                getCurrentProcessEndTime()
            )
        );

        setCurrentProcessEndTime(-1);
        setCurrentProcessStartTime(-1);


    }

    public void buildReport()
    {
        setTotalAverageWaitingTime(calculateAverageWaitingTime());
        setTotalAverageResponseTime(calculateAverageResponseTime());
        setTotalAverageTurnAroundTime(calculateAverageTurnAroundTime());

        processTableList = ProcessTable.sortProcessTable(processTableList);
        LinkedList<Process> waitingList = (LinkedList<Process>) waitingQueue;
        waitingList.sort(Process::compareTo);

        waitingQueue = waitingList;

    }

    public double calculateAverageWaitingTime()
    {
        int time = 0;
        LinkedList<Process> waitingList = new LinkedList<>();

        waitingList = (LinkedList<Process>) waitingQueue;


        for(int i = 0 ; i < waitingList.size(); i++)
        {
            time += waitingList.get(i).getFinalWaitingTime();
        }

        return (double) time /Process.NumberOfProcess;
    }

    public double calculateAverageResponseTime()
    {
        int time = 0;
        LinkedList<Process> waitingList = new LinkedList<>();

        waitingList = (LinkedList<Process>) waitingQueue;


        for(int i = 0 ; i < waitingList.size(); i++)
        {
            time += waitingList.get(i).getFinalResponseTime();
        }

        return (double) time /Process.NumberOfProcess;
    }

    public double calculateAverageTurnAroundTime()
    {
        int time = 0;
        LinkedList<Process> waitingList = new LinkedList<>();

        waitingList = (LinkedList<Process>) waitingQueue;


        for(int i = 0 ; i < waitingList.size(); i++)
        {
            time += waitingList.get(i).getFinalTurnAroundTime();
        }

        return (double) time /Process.NumberOfProcess;
    }

    @Override
    public String toString() {
        return "\nCPU{" +
                "\nreadyQueue=" + readyQueue +
                ", \nfinishedQueue=" + finishedQueue +
                ", \nwaitingQueue=" + waitingQueue +
                ", \narrivalQueue=" + arrivalQueue +
                ", \ncurrentProcess=" + currentProcess +
                ", \nnextIndex=" + nextIndex +
                ", \ncurrentIndex=" + currentIndex +
                ", \nremainingProcess=" + remainingProcess +
                ", \nprocessTableList=" + processTableList +
                ", \nclock=" + clock +
                ", \nmaxClock=" + maxClock +
                ", \ncurrentProcessStartTime=" + currentProcessStartTime +
                ", \ncurrentProcessEndTime=" + currentProcessEndTime +
                ", \ntimeQuantum=" + timeQuantum +
                ", \nTotalAverageResponseTime= " + totalAverageResponseTime +
                ", \nTotalAverageTurnAroundTime= " + totalAverageTurnAroundTime +
                ", \nTotalAverageWaitingTime= " + totalAverageWaitingTime +
                "\n}";
    }
}
