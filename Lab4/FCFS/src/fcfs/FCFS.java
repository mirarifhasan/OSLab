package fcfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class FCFS {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the number of process: ");
        int n = sc.nextInt();
        
        Process[] process = new Process[n];
        
        for(int i=0; i<n; i++){
            process[i] = new Process(i);
        }
        
        System.out.println("Enter CPU times: ");
        for(int i=0; i<n; i++){
            process[i].setCpuTime(sc.nextInt());
        }
        
        System.out.println("Enter the arrival times: ");
        for(int i=0; i<n; i++){
            process[i].setArrivalTime(sc.nextInt());
        }
        
        ArrayList<Process> processList = new ArrayList<>();
        for (int j = 0; j < n; j++) {
            processList.add(process[j]);
        }
        
        Collections.sort(processList);
        
        double totalWT = 0, totalTT = 0;
        
        int ganttTime = processList.get(0).getCpuTime() + processList.get(0).getArrivalTime();
        process[processList.get(0).getProcessID()].setWaitingTime(0);
        process[processList.get(0).getProcessID()].setTurnaroundTime( ganttTime - process[processList.get(0).getProcessID()].getArrivalTime() );
        totalTT = process[processList.get(0).getProcessID()].getTurnaroundTime();
        
        //Finding waiting & turnarround times
        int nextWT=0;
        for(int i=1; i<n; i++) {
            
            nextWT = ganttTime - processList.get(i).getArrivalTime();
            
            process[processList.get(i).getProcessID()].setWaitingTime(nextWT);
            
            ganttTime += processList.get(i).getCpuTime();
            
            process[processList.get(i).getProcessID()].setTurnaroundTime(ganttTime - process[processList.get(i).getProcessID()].getArrivalTime());
            
            totalWT += nextWT;
            totalTT += process[processList.get(i).getProcessID()].getTurnaroundTime();
        }
        
        for (int i=0; i<n; i++){
            System.out.println("Process" + (i+1) + ": Waiting time: " + process[i].getWaitingTime() + "  \tTurnarround Time: " + process[i].getTurnaroundTime());
        }
        
        System.out.println("Average waiting time:" + totalWT/n);
        System.out.println("Average turnarround time:" + totalTT/n);
        
    }
}
