package srtn;

public class Process implements Comparable{
    
    int processID;
    int cpuTime;
    int backUpCpuTime;
    int arrivalTime;
    int waitingTime;
    int turnarroundTime;

    public Process(int processID) {
        this.processID = processID;
    }

    public int getBackUpCpuTime() {
        return backUpCpuTime;
    }

    public void setBackUpCpuTime(int backUpCpuTime) {
        this.backUpCpuTime = backUpCpuTime;
    }

    public int getProcessID() {
        return processID;
    }

    public void setProcessID(int processID) {
        this.processID = processID;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getCpuTime() {
        return cpuTime;
    }

    public void setCpuTime(int cpuTime) {
        this.cpuTime = cpuTime;
    }

    public int getWaitingTime() {
        return waitingTime;
    }

    public void setWaitingTime(int waitingTime) {
        this.waitingTime = waitingTime;
    }

    public int getTurnarroundTime() {
        return turnarroundTime;
    }

    public void setTurnarroundTime(int turnarroundTime) {
        this.turnarroundTime = turnarroundTime;
    }
 
    @Override
    public int compareTo(Object t) {
        return this.arrivalTime - ((Process)t).getArrivalTime();
    }
    
}
