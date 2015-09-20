package ch1;

import java.util.Scanner;

public class Solution03 {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the string and the true length (E.g. cat is    ,6)..");

		while(sc.hasNextLine()){
			String inputString = sc.nextLine();

			String[] s = inputString.split(",");
			char[] inputChar = s[0].toCharArray();
			int trueLength = Integer.parseInt(s[1]);

			char[] outputChar = urlify(inputChar, trueLength);
			String output = new String(outputChar);
			System.out.println(output);
		} 
	}

	public static char[] urlify(char[] input, int length){
		int count_space = 0;
		for(int i = 0; i < length; i++){
			if(input[i] == ' ')
				count_space++;
		}

		int url_length = length + 2 * count_space;
		int url_i = url_length - 1;
		for(int i = length - 1; i >= 0; i--){
			if(input[i] == ' '){
				input[url_i] = '0';
				input[url_i - 1] = '2';
				input[url_i - 2] = '%';
				url_i -= 3;
			}
			else{
				input[url_i] = input[i];
				url_i--;
			}
		}

		return input;

	}



}
