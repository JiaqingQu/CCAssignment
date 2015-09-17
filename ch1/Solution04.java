package ch1;

import java.util.Scanner;

public class Solution04 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextLine()){
			String inputString = sc.nextLine();
			System.out.println(hasPalindromePermutation(inputString));
		}
	}

	/**
	 * For a string has permutation to a palindrome, there are 2 cases:
	 * 	1) each distinct characters have even numbers
	 * 	2) each distinct characters have even numbers + only one have odd number 
	 * Use bit vector and xor operation to check the identity char
	 * To check to probable single char, use the following property:
	 * 	x = 00..010..0, x - 1 = 11..101..1, x && x-1 = 0
	 * */
	public static boolean hasPalindromePermutation(String s) {
		int checker = 0;
		
		String lowerString = s.toLowerCase();
		
		for(int i = 0; i < s.length(); i++){
			char c = lowerString.charAt(i);
			if(c!=' '){
				int cVal = (int) c;
				checker ^= (1 << cVal);
			}
			
		}
		
		if(checker == 0)
			return true;
		if((checker & (checker -1))==0)
				return true;
		
		return false;
	}
	
}
