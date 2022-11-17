import java.util.*;

class LRU
{
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);	
		System.out.println("enter the no. of elements:");
		int n = s.nextInt();
		int []a = new int[n];
		
		for(int i = 0; i < n; i++)
		{
			System.out.println("enter element");
			a[i] = s.nextInt();
		}
		/*System.out.println("enter the size of frame:");
		int size = s.nextInt();*/
		int[] frame ={0, 0, 0};
		


		
		
		
			int hit = 0;
			int miss = 0;
			int ptr = 0;
		for(int i = 0; i < n; i++)
		{
			int temp = a[i];
			boolean ans = false;

		for(int k = 0; k < 3; k++)
		{
			if(frame[k] == temp)
			{
				ans = true;
				break;
			}
		}
			if(ans)
			{
				hit++;
			}
			else
			{
				miss++;
				frame[ptr] = temp;
				if(ptr == 3 - 1){
					ptr = 0;
				}
				else
				{
					ptr++;
				}
			}
		

}
		System.out.println("the number of hits: "+hit);
		System.out.println("the number of miss: "+miss);
		System.out.println("ratio: "+(hit/miss));
	
	}
}