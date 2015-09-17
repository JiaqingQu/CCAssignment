package ch1;

import java.util.Scanner;

public class Solution06 {

	public static void main(String[] args) {
		System.out.println("Enter the input (E.g.'aaabbbc') .. ");
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextLine()){
			String inputString = sc.nextLine();
			System.out.println(compressString(inputString));
			
		}
	}
	
	/**
	 * Use an array to store the number of each character, 
	 * 	e.g. s[0] is the number of 'a' occurs, s[1] is the number of 'b' occurs
	 * */
	public static String compressString(String s){
		StringBuilder result = new StringBuilder();
		
		int[] count = new int[26];
		
		for(int i = 0; i < s.length(); i++){
			char c = s.charAt(i);
			int cVal = c - 'a';
			count[cVal]++;
		}
		
		boolean ifCompressed = false;
		
		for(int i = 0; i < 26; i++){
			char c = (char)('a' + i);
			if((count[i]!= 0)){
				result.append(c);
				result.append(count[i]);
			}
			if((count[i]>1))
				ifCompressed = true;
		}
		
		if(ifCompressed)
			return result.toString();
		else
			return s;
	}

}
