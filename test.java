
import java.util.Arrays;

public class test {


	static void NextFit(int blockSize[], int m, int processSize[], int n) {
	
		int allocation[] = new int[n], j = 0;

		int c =0;
		for (int i = 0; i < n; i++) {
			
			while (j < m) {
				 if(c == 0){
					if (blockSize[j] >= processSize[i]) {

					allocation[i] = j;
					blockSize[j] -= processSize[i];
                    c = j+1;
					break;
					}
				}
				else{
					if (blockSize[c] >= processSize[i]) {

					allocation[i] = c;

					blockSize[c] -= processSize[i];
					break;
					}
				}
				c = c + 1;
			
			}
		}

		System.out.print("\nProcess No.\tProcess Size\tBlock no.\n");
		for (int i = 0; i < n; i++) {
			System.out.print( i + 1 + "\t\t" + processSize[i]
					+ "\t\t");
			if (allocation[i] != -1) {
				System.out.print(allocation[i] + 1);
			} else {
				System.out.print("Not Allocated");
			}
			System.out.println("");
		}
	}

// Driver program
	static public void main(String[] args) {
		int blockSize[] = {5, 10, 20};
		int processSize[] = {10, 20, 5};
		int m = blockSize.length;
		int n = processSize.length;
		NextFit(blockSize, m, processSize, n);
	}
}

// This code is contributed by Rajput-Ji