package srtn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SRTN {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the number of process: ");
        int n = sc.nextInt();
        
        Process process[] = new Process[n];
        ArrayList<Process> processListAT = new ArrayList<>();
        
        System.out.println("Enter arrival times of process: ");
        for(int i=0; i<n; i++){
            process[i] = new Process(i);
            process[i].setArrivalTime(sc.nextInt());
        }
        
        System.out.println("Enter CPU times of process: ");
        for(int i=0; i<n; i++){
            int a = sc.nextInt();
            process[i].setCpuTime(a);
            process[i].setBackUpCpuTime(a);
            processListAT.add(process[i]);
        }
        
        //Sort all process acording arrival time
        Collections.sort(processListAT);
        
        //Taking current execution process and next execution process
        int cid = processListAT.get(0).getProcessID(); //First arrival process's ID
        int nid = processListAT.get(1).getProcessID(); //Secound arraival process's ID
        
        int ganttTime = process[cid].getArrivalTime(); //Consider first arrival time is 0
        int temp;
        
        double awt=0, att=0;
        while(!processListAT.isEmpty()){
            
            int exeTime = Integer.MAX_VALUE;
            
            for(temp = 0; temp<processListAT.size(); temp++){
                if(cid == processListAT.get(temp).getProcessID()) break;
            }
            temp++;
            
            if(processListAT.size()>=2)
                exeTime = process[temp].getArrivalTime();
            
            if(exeTime < process[cid].getCpuTime()) {
                ganttTime += exeTime;
                process[cid].setCpuTime(process[cid].getCpuTime() - exeTime);
            }
            else {
                ganttTime += process[cid].getCpuTime();
                process[cid].setCpuTime(0);
                
                process[cid].setTurnarroundTime(ganttTime - process[cid].getArrivalTime());
                process[cid].setWaitingTime(process[cid].getTurnarroundTime() - process[cid].getBackUpCpuTime());
                
                for(temp=0; temp<n; temp++){
                    if(cid == processListAT.get(temp).getProcessID()) 
                        break;
                }
                
                processListAT.remove(temp);
            }

            int srt = Integer.MAX_VALUE;
            for(int i=0; i<n; i++){
                if(ganttTime >= process[i].getArrivalTime() && process[i].getCpuTime() > 0 && process[i].getCpuTime() < srt){
                    srt = process[i].getCpuTime();
                    cid = i;
                }
            }
        }
        
        
        for(int i=0; i<n; i++){
            awt += process[i].getWaitingTime();
            att += process[i].getTurnarroundTime();
            
            System.out.println("Process " + (i+1) + ": \tWaiting time: " + process[i].getWaitingTime() + "\t\tTurnarround Time: " + process[i].getTurnarroundTime());
        }
        System.out.println("Waiting time: " + awt/n);
        System.out.println("Turnarround time: " + att/n);
    }   
}
