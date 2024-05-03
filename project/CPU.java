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

    private int nextIndex = 0;

    private int currentIndex = 0;

    private int remainingProcess = 0;

    public ArrayList<ProcessTable> processTableList = new ArrayList<>();

    private int clock = 0;

    private int maxClock = 0;

    private int currentProcessStartTime = -1;

    private int currentProcessEndTime = -1;

    public int timeQuantum = 0;

    private double totalAverageWaitingTime;

    private double totalAverageResponseTime;

    private double totalAverageTurnAroundTime;


    // |----------------( Methods )----------------|

    CPU()
    {
    }

    CPU(ArrayList<Process> arrivalQueue, int timeQuantum)
    {
        this.arrivalQueue = arrivalQueue;
        this.timeQuantum = timeQuantum;
    }


    // |----------------( Variable--Methods )----------------|


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

    public int getNextIndex() {
        return nextIndex;
    }

    public void setNextIndex(int nextIndex) {
        this.nextIndex = nextIndex;
    }

    public int getCurrentIndex() {
        return currentIndex;
    }

    public void setCurrentIndex(int currentIndex) {
        this.currentIndex = currentIndex;
    }

    public int getRemainingProcess() {
        return remainingProcess;
    }

    public void setRemainingProcess(int remainingProcess) {
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

    public int getMaxClock() {
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
        int ret = 0;
        if(!readyQueue.isEmpty())
        {
            Queue<Process> q2 = new LinkedList<>();
            Process p;
            
            for(int i = 0; i < readyQueue.size();i++){
                p = readyQueue.remove();
                if(p.getWasActive() == 1){
                    ret = 1;
                    p.setWasActive(0);   
                }
                q2.add(p);
            }
            readyQueue.addAll(q2);
        }
        else 
            return -1;

        return ret;
    }

    private void sortArrivalQueue()
    {
        arrivalQueue.sort(Process::compareTo);        
    }

    // |----------------( Class--Methods )----------------|

    public void startProcess()
    {
        //task5

    }

    private void processHandler(Process process)
    {
        //task4
    }


    private void activeProcessHandler(Process process)
    {
        //task1
    }

    private void waitingProcessHandler(Process process)
    {
        //task1
    }

    private void updateProcessTable(Process process)
    {
        //task2
    }

    public void buildReport()
    {
        //task2
    }

    private double calculateAverageWaitingTime()
    {
        //task7
        return 0.0;
    }

    private double calculateAverageResponseTime()
    {
        //task7
        return 0.0;
    }

    private double calculateAverageTurnAroundTime()
    {
        //task7
        return 0.0;
    }

    @Override
    public String toString() {
        return "\nCPU{" +
                "readyQueue=" + readyQueue +
                ", finishedQueue=" + finishedQueue +
                ", waitingQueue=" + waitingQueue +
                ", arrivalQueue=" + arrivalQueue +
                ", currentProcess=" + currentProcess +
                ", nextIndex=" + nextIndex +
                ", currentIndex=" + currentIndex +
                ", remainingProcess=" + remainingProcess +
                ", processTableList=" + processTableList +
                ", clock=" + clock +
                ", maxClock=" + maxClock +
                ", currentProcessStartTime=" + currentProcessStartTime +
                ", currentProcessEndTime=" + currentProcessEndTime +
                ", timeQuantum=" + timeQuantum +
                '}';
    }
}
