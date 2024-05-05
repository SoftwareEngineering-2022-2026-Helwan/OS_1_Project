public class Process implements Comparable{
    // |----------------( variables )----------------|

    private String processName;

    private int arrivalTime;

    private int burstTime;

    private int status;

    private int wasActive;

    private int finalWaitingTime;

    private int finalTurnAroundTime;

    private int finalResponseTime = -1;

    public static int NumberOfProcess = 0;

    // |----------------( Methods )----------------|


    // |----------------( variable--Methods )----------------|


    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getBurstTime() {
        return burstTime;
    }

    public void setBurstTime(int burstTime) {
        this.burstTime = burstTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getWasActive() {
        return wasActive;
    }

    public void setWasActive(int wasActive) {
        this.wasActive = wasActive;
    }

    public int getFinalWaitingTime() {
        return finalWaitingTime;
    }

    public void setFinalWaitingTime(int finalWaitingTime) {
        this.finalWaitingTime = finalWaitingTime;
    }

    public int getFinalTurnAroundTime() {
        return finalTurnAroundTime;
    }

    public void setFinalTurnAroundTime(int finalTurnAroundTime) {
        this.finalTurnAroundTime = finalTurnAroundTime;
    }

    public int getFinalResponseTime() {
        return finalResponseTime;
    }

    public void setFinalResponseTime(int finalResponseTime) {
        this.finalResponseTime = finalResponseTime;
    }

    // |----------------( class--Methods )----------------|
    Process() {

    }

    Process(String processName, int arrivalTime, int burstTime)
    {
        this.processName = processName;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;

        NumberOfProcess++;
    }

    public void consumeBurstTime()
    {
        burstTime -= 1;
    }

    public boolean isFinished()
    {
        if(burstTime == 0)
            return true;
        else
            return false;
    }

    @Override
    public  int compareTo(Object o)
    {
        if(((Process)o).getArrivalTime() == this.getArrivalTime())
        {
            return this.getProcessName().compareTo(((Process)o).getProcessName());
        }
        return Integer.compare(this.arrivalTime, ((Process)o).getArrivalTime());
    }

    @Override
    public String toString() {
        return "\nProcess{" +
                "processName='" + processName + '\'' +
                ", arrivalTime=" + arrivalTime +
                ", burstTime=" + burstTime +
                ", status=" + status +
                ", wasActive=" + wasActive +
                ", finalWaitingTime=" + finalWaitingTime +
                ", finalTurnAroundTime=" + finalTurnAroundTime +
                ", finalResponseTime=" + finalResponseTime +
                '}';
    }
}
