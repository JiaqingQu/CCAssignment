package ch1;

import java.util.Scanner;

public class Solution07 {

	public static void main(String[] args) {
		int n = 0;
		int[][] m;

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size n of matrix..");
		if (sc.hasNext())
			n = sc.nextInt();
		m = new int[n][n];
		for (int i = 0; i < n; i++) {
			System.out.format("Enter the %dth row of the matrix (E.g. %d %d .. ) ..\n", i + 1, 1 + n * i, 2 + n * i, 3 + n * i);
			for (int j = 0; j < n; j++)
				m[i][j] = sc.nextInt();
		}

		System.out.println("The matrix after rotation is:");

		rotateMatrix(m);

		printMatrix(m);

	}

	/**
	 * Rotate edges of the matrix from the outer layer to inner layer
	 * Note that the rotate is clockwise
	 * */
	public static void rotateMatrix(int[][] m){
		int size = m[0].length;


		for (int layer = 0; layer < size/2 ; layer++){

			int size_layer = size - 2 * layer; //size of layer layer

			int s = layer;	//start index of this layer
			int e = size - layer - 1;	//end index of this layer

			for(int i = 0; i <= size_layer/2; i++){

				int tmp = m[s+i][s]; //number on the left edge
				m[s+i][s] = m[e][s+i]; //bottom edge -> left edge
				m[e][s+i] = m[e-i][e]; //right edge -> bottom edge
				m[e-i][e] = m[s][e-i]; //up edge -> right edge
				m[s][e-i] = tmp; //left edge -> up

			}

		}

	}

	public static void printMatrix(int [][] m){
		for(int i = 0; i < m.length; i++){
			for(int j = 0; j < m[0].length; j++)
				System.out.print(m[i][j] + " ");
			System.out.println();
		}
	}

	

}
