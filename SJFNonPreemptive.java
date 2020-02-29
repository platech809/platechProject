import java.util.*;
 
public class Main{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
        float avg_wt,avg_tat;
        int i,j,pos,temp,total=0;
        int waitingTime[] = new int[20];
		System.out.println ("Enter number of Process: ");
		int n = sc.nextInt();
		int pid[] = new int[n];
		int bt[] = new int[n];
		int st=0, tot=0;
		float avgwt=0, avgta=0;
 
		for(i=0;i<n;i++)
		{
			System.out.println ("Enter Process " + (i+1) + " Burst Time:");
			bt[i] = sc.nextInt();
			pid[i] = i+1;
		}
		for (i=0;i<n;i++)
		{
		    pos = i;
		    for(j=i+1;j<n;j++)
            {
                if(bt[j]<bt[pos])
                pos=j;
            }
            temp=bt[i];
            bt[i]=bt[pos];
            bt[pos]=temp;
  
            temp=pid[i];
            pid[i]=pid[pos];
            pid[pos]=temp;
	    }
	    waitingTime[0]=0;
	    for(i=1;i<n;i++)
        {
            waitingTime[i]=0;
            for(j=0;j<i;j++)
            waitingTime[i]+=bt[j];
  
            total+=waitingTime[i];
        }
        avg_wt=(float)total/n;      
        total=0;
        System.out.println("Process \tBurstTime \t WaitingTime");
        for(i=0;i<n;i++)
        {
            System.out.print("\n"+pid[i]);;
            System.out.print("\t\t"+bt[i]);
            System.out.print("\t\t\t"+waitingTime[i]);
            System.out.print("\n");
        }
        System.out.print("Average Waiting Time= "+avg_wt);
  
	}
}