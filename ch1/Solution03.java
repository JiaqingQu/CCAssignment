package ch1;

import java.util.Scanner;

public class Solution03 {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextLine()){
			String inputString = sc.nextLine();
			String[] s = inputString.split(",");
			//System.out.println(urlify(s[0],Integer.parseInt(s[1])));
		} 
	}
//	/*
//	 * Use the Stringbuilder to build the output string when scanning the input string
//	 * Note that Stringbuilder is faster when appending the string
//	 * */
//	public static String urlify(String s, int length){
//		StringBuilder builder = new StringBuilder();
//		
//		for(int i = 0; i < length; i++){
//			if(s.charAt(i)==' ')
//				builder.append("%20");
//			else
//				builder.append(s.charAt(i));
//		}
//		
//		return builder.toString();
//	}
}
