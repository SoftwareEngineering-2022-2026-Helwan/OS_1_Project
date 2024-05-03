public class TimeInterpretur
{
    // |----------------( variables )----------------|

    private int timeQuantum = 0;

    public static int consumedQuantum = 0;

    // |----------------( Methods )----------------|


    // |----------------( variable--Methods )----------------|


    public int getTimeQuantum() {
        return timeQuantum;
    }

    public void setTimeQuantum(int timeQuantum) {
        this.timeQuantum = timeQuantum;
    }

    // |----------------( class--Methods )----------------|
    TimeInterpretur()
    {

    }

    TimeInterpretur(int time)
    {
        this.timeQuantum = time;
    }

    private void processStatusHandler(Process process)
    {
        //task3
    }

    public void currentProcessHandler(Process process)
    {
        //task3
    }

    @Override
    public String toString() {
        return "\nTimeInterpretur{" +
                "timeQuantum=" + timeQuantum +
                "Consumed timeQuantum=" + consumedQuantum +
                '}';
    }
}
