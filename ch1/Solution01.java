package ch1;

import java.util.Scanner;

public class Solution01 {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			String inputString = sc.next();
			System.out.println(isUnique(inputString));
		}
	}
	
	
	/**
	 * According to the ASCII encoding system,all characters are represented by 128 numbers
	 * Thus, an array of size of 128 can be used to represent the existence of each character
	 * With 0 representing the character exists, 1 in the other way
	 * 
	 * Complexity: O(n)
	 */
	public static boolean isUnique(String s){
		int[] checkCharacter = new int[128];
		
		
		for(int i = 0; i < s.length(); i++){
			int pos = s.charAt(i);		
			if(checkCharacter[pos] == 0){
				checkCharacter[pos] = 1;
			}
			else
				return false;
		}
		
		return true;
	}
	
}
