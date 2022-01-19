class Armstrong{
	//String liczba[];
	boolean isArmstrongNumber(int numberToCheck) {
		int Obliczona=0;
		int a=0;
		String numberToStr = Integer.toString(numberToCheck); 
		
		
		int ilosc = String.valueOf(numberToCheck).length(); 
		int liczba[] = new int [ilosc]; 
		//String number[] =new String[ilosc];
		for(int i=0; i < ilosc;i++) 
		{
			
			char actualValue = numberToStr.charAt(i);
			 a=Integer.parseInt(String.valueOf(actualValue));  	
			liczba[i]=a;			
		}
		
		
		do { Obliczona =+ liczba[ilosc]*( 10*(ilosc-1));
		                  ilosc--;
		}
		 while(ilosc==0);
		if(numberToCheck ==Obliczona)
			return true;
		else if(numberToCheck==0)
			return true;
		else 
		return false;
		
	
		
	}
}