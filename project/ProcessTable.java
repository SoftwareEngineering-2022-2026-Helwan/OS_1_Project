import java.util.ArrayList;

public class ProcessTable
{
    // |----------------( variables )----------------|

    private String processName;

    private int startTime;

    private int endTime;
    // |----------------( Methods )----------------|


    // |----------------( variable--Methods )----------------|


    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    // |----------------( class--Methods )----------------|
    ProcessTable()
    {

    }
    ProcessTable(String processName, int startTime, int endTime)
    {
        this.processName = processName;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public ArrayList<ProcessTable> sortProcessTable(ArrayList<ProcessTable> processTableList)
    {
        

        return null;
    }
}
