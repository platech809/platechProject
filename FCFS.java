import java.text.ParseException; 
import java.util.*;
  
class FCFS { 
  
    static void findWaitingTime(int processes[], int n, int bursTime[], int waitingTime[]) { 
        waitingTime[0] = 0; 
  
        for (int i = 1; i < n; i++) { 
            waitingTime[i] = bursTime[i - 1] + waitingTime[i - 1]; 
        } 
    } 
  
  
    static void findavgTime(int processes[], int n, int bursTime[]) { 
        int waitingTime[] = new int[n];
        int total_waitingTime = 0;

        findWaitingTime(processes, n, bursTime, waitingTime); 
  
        System.out.printf("Processes\tBurst Time\tWaiting Time\n");

        for (int i = 0; i < n; i++) { 
            total_waitingTime+=waitingTime[i]; 
            System.out.printf("  \n"+(i + 1)); 
            System.out.printf("  \t\t\t\t"+bursTime[i]); 
             System.out.printf("\t\t\t"); 
            System.out.printf("  "+waitingTime[i]); 
            System.out.printf("\n"); 
        } 
        float s = (float)total_waitingTime /(float) n; 
        System.out.printf("Average waiting time = " +s); 
    } 
  
    public static void main(String[] args) throws ParseException { 
        int processes[] = {1, 2, 3, 4};
        int n = processes.length; 
  
        int burst_time[] = {21, 3, 6, 2};
  
        findavgTime(processes, n, burst_time); 
  
    } 
} 