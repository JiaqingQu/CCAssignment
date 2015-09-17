package ch1;

import java.util.Scanner;

public class Solution05 {

	public static void main(String[] args) {
		System.out.println("Enter the input (E.g.'pale bale') .. ");
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextLine()){
			String inputString = sc.nextLine();
			String[] s = inputString.split(" ");
			System.out.println(isOneWay(s[0], s[1]));
			
		}
	}
	
	/**
	 * Scan the two strings from left to right
	 * Use two indexes to scan the two strings separately
	 * When encountering the difference, 
	 * 	mark it down, increase the long string's index while keeping the short one's the same, then keep scanning
	 */
	public static boolean isOneWay(String s1, String s2){
		//check remove/insert
		if(s1.length()!=s2.length()){
			String longString = s2.length() > s1.length() ? s2 : s1;
			String shortString = s2.length() > s1.length() ? s1 : s1;
			
			//obviously not one edit away
			if((longString.length() - shortString.length())>=2)
				return false;
			
			int countDiffer = 0;
			
			int j = 0;	//index for the long string
			int i = 0;	//index for the short string
			for(j = 0; j < longString.length(); j++){
				if(shortString.charAt(i) == longString.charAt(j))
					i++;
				else{
					countDiffer++;
					if(countDiffer>1)
						return false;
				}
			} 
		}
		//check replacement
		else {
			int countDiffer = 0;
			
			int i = 0; 
			int j = 0;
			for(i = 0; i < s1.length(); i++){
				if(s1.charAt(i)==s2.charAt(i))
					j++;
				else{
					countDiffer++;
					if(countDiffer > 1)
						return false;
				}
			}
		}
		
		
		return true;
	}

}
