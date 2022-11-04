// Java implementation of worst - Fit algorithm 
  
public class GFG  
{ 
    // Method to allocate memory to blocks as per worst fit 
    // algorithm 
    static void worstFit(int blockSize[], int m, int processSize[],  
                                                     int n) 
    { 
        // Stores block id of the block allocated to a 
        // process 
        int allocation[] = new int[n]; 
       
        // Initially no block is assigned to any process 
        for (int i = 0; i < allocation.length; i++) 
            allocation[i] = -1; 
       
        // pick each process and find suitable blocks 
        // according to its size ad assign to it 
        for (int i=0; i<n; i++) 
        { 
            // Find the best fit block for current process 
            int wstIdx = -1; 
            for (int j=0; j<m; j++) 
            { 
                if (blockSize[j] >= processSize[i]) 
                { 
                    if (wstIdx == -1) 
                        wstIdx = j; 
                    else if (blockSize[wstIdx] < blockSize[j]) 
                        wstIdx = j; 
                } 
            } 
       
            // If we could find a block for current process 
            if (wstIdx != -1) 
            { 
                // allocate block j to p[i] process 
                allocation[i] = wstIdx; 
       
                // Reduce available memory in this block. 
                blockSize[wstIdx] -= processSize[i]; 
            } 
        } 
       
        System.out.println("Process No.	Process Size	Block no."); 
        for (int i = 0; i < n; i++) 
        { 
            System.out.print("   " + (i+1) + " " + processSize[i] + " "); 
            if (allocation[i] != -1) 
                System.out.print(allocation[i] + 1); 
            else
                System.out.print("Not Allocated"); 
            System.out.println(); 
        } 
    } 
      
    // Driver Method 
    public static void main(String[] args) 
    { 
         int blockSize[] = {100, 500, 200, 300, 600}; 
         int processSize[] = {212, 417, 112, 426}; 
         int m = blockSize.length; 
         int n = processSize.length; 
           
         worstFit(blockSize, m, processSize, n); 
    } 
}