package rrs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class RRS {

    public static void main(String[] args) {
        
        int timeQuantam = 3;
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the number of process: ");
        int n = sc.nextInt();
        
        Process[] process = new Process[n];
        ArrayList<Process> processListAT = new ArrayList<>();
        
        System.out.println("Enter CPU times: ");
        for(int i=0; i<n; i++){
            process[i] = new Process(i);
            int a = sc.nextInt();
            process[i].setCpuTime(a);
            process[i].setBackUpCpuTime(a);
        }
        
        System.out.println("Enter the arrival times: ");
        for(int i=0; i<n; i++){
            process[i].setArrivalTime(sc.nextInt());
            processListAT.add(process[i]);
        }
        
        //Sorted by arrival time
        Collections.sort(processListAT);
        
        int ganttTime = processListAT.get(0).getArrivalTime(); // Usually it is 0
        
        Queue<Process> waitingQueue = new LinkedList<>();
        waitingQueue.add(process[processListAT.get(0).getProcessID()]);
        
        processListAT.remove(0);
        
        while(!waitingQueue.isEmpty())
        {
            Process p = waitingQueue.poll();
            
            if(p.getCpuTime() <= timeQuantam){
                ganttTime += p.getCpuTime();
                
                process[p.getProcessID()].setWaitingTime(ganttTime - (process[p.getProcessID()].getArrivalTime() + process[p.getProcessID()].getBackUpCpuTime()));
                process[p.getProcessID()].setTurnaroundTime(ganttTime - process[p.getProcessID()].getArrivalTime());
            }
            else{
                ganttTime += timeQuantam;
                p.setCpuTime( p.getCpuTime() - timeQuantam );
                
                while(!processListAT.isEmpty() && ganttTime>=processListAT.get(0).getArrivalTime())
                {
                    waitingQueue.add(process[processListAT.get(0).getProcessID()]);
                    processListAT.remove(0);
                }
                
                waitingQueue.add(p);
            }
        }
        
        double awt=0, att=0;
        for(int i=0; i<n ;i++){
            awt += process[i].getWaitingTime();
            att += process[i].getTurnaroundTime();
            
            System.out.println("Process " + (i+1) + ":  Waiting Time: " + process[i].getWaitingTime() + "\tTurnarround Time: " + process[i].getTurnaroundTime());
        }
        System.out.println("Average waiting time: " + awt/n);
        System.out.println("Average turnarround time: " + att/n);
    }
}
