package ch1;

import java.util.Scanner;

public class Solution02 {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			String s1 = sc.next();
			String s2 = sc.next();
			System.out.println(checkPermutation(s1,s2));
		}
	}
	
	/**
	 * Check if two strings are consisted of same characters
	 * Note that if two strings are exactly the same, they are not permutation to each other
	 * */
	public static boolean checkPermutation(String s1, String s2){
		if(s1.equals(s2))
			return false;
		else{
			int[] checkCharacterStr1 = new int[128];
			int[] checkCharacterStr2 = new int[128];
			
			for(int i = 0; i < s1.length(); i++){
				checkCharacterStr1[s1.charAt(i)]++;
			}
			for(int i = 0; i < s2.length(); i++){
				checkCharacterStr2[s2.charAt(i)]++;
			}
			for(int i = 0; i < 128; i++){
				if(checkCharacterStr1[i] != checkCharacterStr2[i])
					return false;
			}
			
			return true;
		}
	}
}
