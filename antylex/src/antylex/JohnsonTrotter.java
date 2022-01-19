package antylex;


import java.util.Scanner;
public class JohnsonTrotter {   
	
	 public static void main(String[] args) {
	
		  System.out.println("Wprowadz liczbê elementów");
		  Scanner liczbaelem = new Scanner(System.in);
		  int n = liczbaelem.nextInt();
		  liczbaelem.close();
		  int []arr = new int[n];
		  for (int i = 1; i <= n; i++) {
		   arr[i - 1] = i;
		  }
		  boolean[] kierunek = new boolean[n];
		// prawda odpowiada kierunkowi w prawo, fa³sz w lewo
		  Integer index;
		  while ((index = znajdzWiekszyElement(arr, kierunek)) != -1) {
		   print(arr);
		   zamien(arr, index, kierunek);
		  }
		 }
	 	//zmiana miejscami elementów s¹siaduj¹cych, i kierunków
		 private static void zamien(int[] arr, Integer index, boolean[] kierunek) {
		 
		int x = 2* ((kierunek[index]) ? 1 : 0); 
		   zamien(arr, index, index - 1 + x);
		   zamien(kierunek, index, index -1 + x);
		   index = index - 1 + x;
		  
		  odwrocInneWieksze(arr, kierunek, index);
		 }


		 private static void odwrocInneWieksze(int[] arr, boolean[] kierunek, Integer index) {
		  for (int i = 0; i < arr.length; i++) {
		   if (arr[i] > arr[index]) {
		    kierunek[i] = !kierunek[i];
		   }
		  }

		 }
   
		 
		
		 
		 
		 private static Integer znajdzWiekszyElement(int[] arr, boolean[] kierunek) {
		  Integer max = Integer.MIN_VALUE;
		  Integer maxIndex = -1;
		  boolean wynik;
		  for (int i = 0; i < arr.length; i++) {			  
			  if (kierunek[i])
			  { wynik = (i < (arr.length - 1));}
			    else 
		  	    {wynik = (i > 0);}  	     
		    if (wynik) {
		    	int x = 2 * ((kierunek[i]) ? 1 : 0);	
		     if (arr[i] > arr[i - 1 + x]) {
		      if (arr[i] > max) {
		       max = arr[i];
		       maxIndex = i;		      
		      }
		     }
		    }
		  }		    
		  return maxIndex;
		 }
		  
		 private static void zamien (int [] arr, int pierwszy, int drugi) {
		  int temp = arr[pierwszy];
		  arr[pierwszy] = arr[drugi];
		  arr[drugi] = temp;
		 }

		 private static void zamien(boolean[] arr, int pierwszy, int drugi) {
		  boolean temp = arr[pierwszy];
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
