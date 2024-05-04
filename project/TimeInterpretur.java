public class TimeInterpretur
{
    // |----------------( variables )----------------|

    private int timeQuantum = 0;

    private CPU cpu;

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

    TimeInterpretur(CPU cpu)
    {
        this.cpu = cpu;
        timeQuantum = cpu.timeQuantum;
    }

    private void processStatusHandler(Process process)
    {
        int currentIndex = cpu.getCurrentIndex();
        int nextIndex = cpu.getNextIndex();
        int remainingProcess = cpu.getRemainingProcess();
        int burstTime = process.getBurstTime();

        if (currentIndex == 0) {
            process.setStatus(1);
            cpu.setCurrentIndex(-1);
        }
        else if (consumedQuantum == timeQuantum)
        {
            process.setStatus(0);
            process.setWasActive(1);
            consumedQuantum = 0;

            if (burstTime != 0)
            {
                if(remainingProcess != 0)
                {
                    cpu.setNextIndex( (cpu.getNextIndex() + 1) % remainingProcess );
                }
                
            }
            else
            {
                remainingProcess--;
                cpu.setRemainingProcess(remainingProcess);

                if (remainingProcess == 1)
                {
                    cpu.setNextIndex(0);
                }

            }
        }
    }

    public void processHandler(Process process)
    {
        processStatusHandler(process);
        if (process.getStatus() == 1) {
            process.consumeBurstTime();
            consumedQuantum++;
            processStatusHandler(process);
        }
    }

    @Override
    public String toString() {
        return "\nTimeInterpretur{" +
                "timeQuantum=" + timeQuantum +
                "Consumed timeQuantum=" + consumedQuantum +
                '}';
    }
}
