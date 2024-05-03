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

    public static ArrayList<ProcessTable> sortProcessTable(ArrayList<ProcessTable> processTableList)
    {
        ProcessTable p1 = new ProcessTable();
        ProcessTable p2 = new ProcessTable();
        ArrayList<ProcessTable> list = new ArrayList<>();

        for(int i = 0;i < processTableList.size() -1; i++){
            p1 = list.get(i);
            for(int j = 0;j < processTableList.size() -1; j++){
                p2 = list.get(j);
                if(p1.processName.compareTo(p2.processName) == 0)
                    list.add(p2);
            }
        }

        return list;
    }
}
