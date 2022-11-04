import java.util.*;

 class Optimal
{
	public static void main(String []args)
	{
		System.out.println("Enter number of frames");
		Scanner sc = new Scanner(System.in);
		int fr = sc.nextInt();
		System.out.println("Enter number of elements");
		int n = sc.nextInt();
		int []a = new int[fr];
		String s;
		System.out.println("Enter elements : ");
		s = sc.next();
		int []visited={0,0,0,0,0,0,0,0,0,0};
		int miss=0;
		int hit=0;
		int ptr = 0;
		for(int i=0;i<fr;i++)
		{
			a[i]=-1;
		}
		for(int i=0;i<n;i++)
		{
			int k=0;
			if(visited[(int)s.charAt(i)-48] == 0)
			{
				miss++;
				if( i>= n-fr)
				{
					if(a[ptr] !=  -1)
						visited[a[ptr]] = 0;
					a[ptr]= (int)s.charAt(i)-48;
					ptr = (ptr+1)%fr;
				}
				else
				{
					int y=i;
					if(i>=fr)
					{
						for(int j=i+1;j<n;j++)
						{
							k++;
							if(k>=fr && s.charAt(j) != s.charAt(j-1) && visited[(int)s.charAt(j)-48]==1)
							{
								int x = (int)s.charAt(j)-48;
						
								for(int z=0;z<fr;z++)
								{
									if(a[z] == x)
									{
										y = z;
										break;
									}
								}	
							}		
						}
					}
					if(a[y] != -1)
						visited[a[y]] = 0;
					a[y] = (int)s.charAt(i)-48;
				}
				
			}
			else
				hit++;
			
			visited[(int)s.charAt(i)-48] = 1;
			for(int j=0;j<fr;j++)
			{
				System.out.print(a[j]+" ");
			}
			System.out.println();
		}
		System.out.println("Miss : "+ miss);
		System.out.println("Hit : "+ hit);
		float hr = (float)hit/(float)n;
		System.out.println("Hit ratio = "+hr);
	}
}