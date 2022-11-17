import java.util.*;
class fifo{

   public static void main(String args[]){
      Scanner s = new Scanner(System.in);
      System.out.print("Enter the number of elements : ");
      int cnt = s.nextInt();
      
      char arr[] = new char[cnt];
      System.out.print("Enter the element : ");
      for(int i=0; i<cnt; i++){
	arr[i] = s.next().charAt(0);
      }
      System.out.print("Enter the size of frame : ");
      int fSize = s.nextInt();
      char frame[] = new char[fSize];
      
      int hit = 0;
      int mis = 0;
      int ptr = 0;

      
      for(int i=0; i<cnt; i++){
      boolean ans = false;
         for(int j=0; j<fSize; j++){
            if(arr[i] == frame[j]){
            	ans = true;
            	break;
            }
         }
         if(ans){
         	hit++;
         	
         }
         else{
            mis++;
            frame[ptr] = arr[i];
            
            if(ptr ==fSize-1){
               ptr = 0;
               
           }
           else{
              ptr++;
          }
           
       }
       for(int k=0; k<fSize; k++){
          System.out.print(frame[k]+" ");
       }
      //  System.out.print(hit+" "+mis);
       System.out.println();
    }
    System.out.println("hits : "+hit);
    System.out.println("mis : "+mis);
      
	      
   }
 }