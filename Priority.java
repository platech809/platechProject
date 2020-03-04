
  
import java.util.*;
 
public class Main{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
        int x,n,pid[],pr[],bt[],w[],i,t[];
        float awt;
        pid = new int[20];
        pr = new int[20];
        bt = new int[20];
        w = new int[20];
        t = new int[20];
        
        System.out.print("Enter the number of process : ");
        n = sc.nextInt();
        System.out.print("\n");
        System.out.println("Enter burst time : time priorities ");
        for(i=0;i<n;i++)
        {
            System.out.print("Enter Process " + (i+1) + " Burst Time: "+"\n");
            bt[i] = sc.nextInt();
            System.out.print("Enter Process " + (i+1) + " Priority: "+"\n");
            pr[i] = sc.nextInt();
            pid[i]=i+1;
        }
        for(i=0;i<n-1;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                if(pr[i]>pr[j])
                {
                 x=pr[i];
                 pr[i]=pr[j];
                 pr[j]=x;
                 x=bt[i];
                 bt[i]=bt[j];
                 bt[j]=x;
                 x=pid[i];
                 pid[i]=pid[j];
                 pid[j]=x;
                }
            }
        }
        w[0]=0;
        awt=0;
        t[0]=bt[0];
        for(i=1;i<n;i++)
        {
            w[i]=t[i-1];
            awt+=w[i];
            t[i]=w[i]+bt[i];
        }
        System.out.println("Process \tBurstTime \t Priority");
        awt=(float)awt/n;
        for(i=0;i<n;i++)
        {
            System.out.print("\n"+pid[i]);;
            System.out.print("\t\t"+bt[i]);
            System.out.print("\t\t\t"+pr[i]);
            System.out.print("\n");
        }
        System.out.print("Average Waiting Time= "+awt);
	}
}

