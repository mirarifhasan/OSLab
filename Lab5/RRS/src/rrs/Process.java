package rrs;


public class Process implements Comparable {
    
    int processID;
    int arrivalTime;
    int backUpCpuTime;
    int cpuTime;
    int turnaroundTime = 0;
    int waitingTime = 0;

    public Process(int id) {
        this.processID = id;
    }

    public void setBackUpCpuTime(int backUpCpuTime) {
        this.backUpCpuTime = backUpCpuTime;
    }

    public int getBackUpCpuTime() {
        return backUpCpuTime;
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

    public int getTurnaroundTime() {
        return turnaroundTime;
    }

    public void setTurnaroundTime(int turnaroundTime) {
        this.turnaroundTime = turnaroundTime;
    }

    public int getWaitingTime() {
        return waitingTime;
    }

    public void setWaitingTime(int waitingTime) {
        this.waitingTime = waitingTime;
    }

    @Override
    public int compareTo(Object comparestu) {
        int compareage=((Process)comparestu).getArrivalTime();
        return this.arrivalTime-compareage;
    }

}
