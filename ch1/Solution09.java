package ch1;

import java.util.Scanner;

public class Solution09 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String s1 = "";
        String s2 = "";
        System.out.println("Enter the 1st string (E.g. cat) ..");
        if(sc.hasNext())
            s1 = sc.next();

        System.out.println("Enter the 2nd string (E.g. atc) ..");
        if(sc.hasNext())
            s2 = sc.next();

        System.out.println(isRotation(s1,s2));

    }

    /**
     * Concatenate two s2 together and check if s1 is substring of s2
     * */
    public static boolean isRotation(String s1, String s2){
        if(s1.length() != s2.length())
            return false;
        if(s1.equals(""))
            return false;

        String s = s2 + s2;

        return s.contains(s1);
    }





}
