import java.util.*;

class practice{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.println("enter the no. of processes");
        int n = s.nextInt();

        int pid[] = new int[n];
        int bt[] = new int[n];
        int pt[] = new int[n];
        int wt[] = new int[n];
        int ta[] = new int[n];

        for(int i = 0; i<n; i++){
            System.out.println("enter the process burst time");
            bt[i] = s.nextInt();
            System.out.println("enter the process priority");
            pt[i] = s.nextInt();
            pid[i] = i+1;
        }

        int pos = 0, temp;
        for(int i = 0; i<n; i++){
            pos = i;
            for(int j = i+1; j<n; j++){
                if(pt[j] < pt[pos]){
                    pos = j;
                }
            }

            temp = pt[pos];
            pt[pos] = pt[i];
            pt[i] = temp;

            temp = pid[pos];
            pid[pos] = pid[i];
            pid[i] = temp;

            temp = bt[pos];
            bt[pos] = bt[i];
            bt[i] = temp;  
        }

        wt[0] = 0;
        for(int i = 1; i<n; i++){
            wt[i] = wt[i-1] + bt[i-1];
            ta[i] = wt[i] + bt[i];
        }


        System.out.println("pid burst pririty turn wait");
        for(int i = 0; i<n; i++){
            System.out.println(pid[i]+"\t"+bt[i]+"\t"+pt[i]+"\t"+ta[i]+"\t"+wt[i]);
            
        }
    }
}