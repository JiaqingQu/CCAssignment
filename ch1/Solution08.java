package ch1;


import java.util.Scanner;

public class Solution08 {

    public static void main(String[] args){

        int m = 0;
        int n = 0;
        int[][] mat;

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size m, n of matrix..");
        if (sc.hasNext())
            m = sc.nextInt();
        if (sc.hasNext())
            n = sc.nextInt();
        mat = new int[m][n];
        for (int i = 0; i < m; i++) {
            System.out.format("Enter the %dth row of the matrix (E.g. %d %d .. ) ..\n", i + 1, 1 + n * i, 2 + n * i, 3 + n * i);
            for (int j = 0; j < n; j++)
                mat[i][j] = sc.nextInt();
        }

//        System.out.println("The matrix after rotation is:");

        zeroMatrix(mat);

        printMatrix(mat);

    }

    /**
     * Firstly, check the first row and first column to see if there is any zero in it
     * Then, traverse the matrix, if there is a zero in it, set the first element of that column and row to be zero
     * Then, traverse the first row and first column from the index 1, set that row/column to be zero if zero occurs
     * At last, set the first row/column to 0 if needed
     * */
    public static void zeroMatrix(int[][] m){
        boolean hasZeroFirstRow = false;
        boolean hasZeroFirstCol = false;

        //check the first row and column of the matrix
        for(int i = 0; i < m[0].length; i++){
            if(m[0][i] == 0)
                hasZeroFirstRow = true;
        }

        for(int i = 0; i < m.length; i++){
            if(m[i][0] == 0)
                hasZeroFirstCol = true;
        }

        //traverse the matrix
        for(int i = 0; i < m.length; i++){
            for(int j = 0; j < m[0].length; j++){
                if(m[i][j] == 0){
                    //set the first element of that row is zero
                    m[i][0] = 0;
                    //set the first element of that column if zero
                    m[0][j] = 0;
                }
            }
        }

//        System.out.println("After first traverse..");
//        printMatrix(m);



        //set the corresponding row/column to zero
        for(int i = 1; i < m.length; i++){
            if(m[i][0] == 0){
                setRowZero(m,i);
            }
        }

//        System.out.println("After setting rows to zero ..");
//        printMatrix(m);



        for(int j = 1; j < m[0].length; j++){
            if(m[0][j] == 0){
                setColumnZero(m, j);
            }
        }

//        System.out.println("After setting columns to zero ..");
//        printMatrix(m);

        if(hasZeroFirstRow){
            setRowZero(m,0);
        }

        if(hasZeroFirstCol){
            setColumnZero(m, 0);
        }

    }

    public static void printMatrix(int [][] m){
        for(int i = 0; i < m.length; i++){
            for(int j = 0; j < m[0].length; j++)
                System.out.print(m[i][j] + " ");
            System.out.println();
        }
    }

    public static void setColumnZero(int[][] m, int col){
        for(int i = 0; i < m.length; i++)
            m[i][col] = 0;
    }

    public static void setRowZero(int[][] m, int row){
        for(int i = 0; i < m[0].length; i++)
            m[row][i] = 0;
    }



}
