
package sjf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SJF {

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
        
        ArrayList<Process> processListAT = new ArrayList<>();
        
        for (int j = 0; j < n; j++) {
            processListAT.add(process[j]);
        }
        
        //Sorted by arrival time
        Collections.sort(processListAT);
        
        double totalWT = 0, totalTT = 0;
        
        int ganttTime = processListAT.get(0).getCpuTime() + processListAT.get(0).getArrivalTime();
        process[processListAT.get(0).getProcessID()].setWaitingTime(0);
        process[processListAT.get(0).getProcessID()].setTurnaroundTime(ganttTime - process[processListAT.get(0).getProcessID()].getArrivalTime() );
        totalTT = process[processListAT.get(0).getProcessID()].getTurnaroundTime();
        
        //Finding waiting & turnarround times
        int nextWT=0;
        for(int i=1; i<n; i++) {
            
            int shortCPU = Integer.MAX_VALUE, shortID = Integer.MIN_VALUE;
            for(int j=i; j<n; j++){
                
                if (processListAT.get(j).getArrivalTime() <= ganttTime && shortCPU > processListAT.get(j).getCpuTime() && processListAT.get(j).isExe()==true){
                    shortCPU = processListAT.get(j).getCpuTime();
                    shortID = processListAT.get(j).getProcessID();
                    processListAT.get(j).setExe(false);
                }
            }
            
            if(shortID < 0) shortID = i;
            
            nextWT = ganttTime - process[shortID].getArrivalTime();
            
            process[shortID].setWaitingTime(nextWT);
            
            ganttTime += process[shortID].getCpuTime();
            
            process[shortID].setTurnaroundTime(ganttTime - process[shortID].getArrivalTime());
            
            totalWT += nextWT;
            totalTT += process[shortID].getTurnaroundTime();
        }
        
        for (int i=0; i<n; i++){
            System.out.println("Process" + (i+1) + ": Waiting time: " + process[i].getWaitingTime() + "  \tTurnarround Time: " + process[i].getTurnaroundTime());
        }
        
        System.out.println("Average waiting time:" + totalWT/n);
        System.out.println("Average turnarround time:" + totalTT/n);
        
        
    }
}
