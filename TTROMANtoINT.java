package com.Tanmay.Practise;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

 public class RomanNumber {

	static Map<Character, Integer> map = new HashMap<>();
	static boolean flag = false ;
	static {
		
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		
	}
		
	public static boolean checkString(String str , Map<Character , Integer > map) {
		
		int len = str.length();
		for ( int i=0 ; i < len ; i++ ) {
			
			if (i != len && len > 2 ) {
				
				for(int j=i ; j < len-1 ; j++) {
					
					Integer n1 = (Integer) (map.get(str.charAt(i)));
					
					Integer temp = (Integer) (map.get(str.charAt(j)));
					
					// System.out.println(" LINE : 35 N =>  "+n1);
					
					if ( n1 >= temp || (n1 == 1 && ( temp == 5 || temp == 10 ) )) {  flag=true; }
					else{
						 System.out.println("Enter valid ROMAN NUMBER ");
						 flag = false ; 
						 System.exit(j);
						}
					}
				}else flag=true;
			}
			return flag ;
	}
	
	
	public static int convert(String s, Map<Character, Integer> map) {
		
		int sum = 0;
	   		
		s = s.replace("IV","IIII");  
        s = s.replace("IX","VIIII");  
        s = s.replace("XL","XXXX");  
        s = s.replace("XC","LXXXX");  
        s = s.replace("CD","CCCC");  
        s = s.replace("CM","DCCCC");
        
        int len = s.length();
        
	    	 for (int i = 0; i < len ; i++)  
	         {  Integer no = (Integer) ( map.get(s.charAt(i))) ;
	           sum = sum + no ;  
	         }  
	    return sum;
	    
	
	}
	public static void main(String[] args) {
		
		System.out.println("Enter s number for conversion :  ");
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		checkString(str.toUpperCase(), map);
		
		if(flag)
		System.out.println(" Value of " + str + " is " + 
convert(str.toUpperCase(), map));
		sc.close();
	}
	
 }
