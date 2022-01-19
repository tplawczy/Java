package bmi;

import java.util.Scanner;

public class PermzNajmLiczTransp {
	

	
	public static void main(String[] args) {
	
	System.out.println("Wprowadz liczbê elementów");
	Scanner liczbaelem = new Scanner(System.in);
	 int n = liczbaelem.nextInt();
	liczbaelem.close();
	int[] arr = new int[n];
	for (int i = 1; i <= n; i++) {
		
                   arr[i-1] = i;}
     
   
     		permutacja (arr,n);
     
	}
	
		private static void permutacja(int[]arr,int m )
		
		{				
			if( m == 1)
			 {
				print(arr);
			 }
			
		
			for (int i = 1; i <= m ; i++) {
				permutacja(arr,m-1);
				
		
				if (i < m) {
			

					
					System.out.print(bmi(m,i)+";"+m );
				  
				  System.out.println();
				 
					zamien(arr,(bmi(m,i)-1),m-1);
						 
				}
			  
					
			}
		}	
		
		

		private static int  bmi (int m, int i)
		{
			if(m % 2 == 0 && m > 2) {
				if(i < m - 1) return i;
				else return m-2;
			}
			else return m-1;
		}	
		
		private static void zamien (int[]arr ,int pierwszy, int drugi) {
			  int temp = arr[pierwszy];
			  arr[pierwszy] = arr[drugi];
			  arr[drugi] = temp;
			 }
		 private static void print(int[] arr) {
			  for (int i = 0; i < arr.length; i++) {
			   System.out.print(arr[i] + " ");
			  }
			  System.out.println();
			 }
		}
	
