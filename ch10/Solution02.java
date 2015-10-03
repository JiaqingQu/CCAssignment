package ch10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Solution02 {

    public static void main(String[] args) {
        String[] input = {"cat","ctc","baac","atc","cta","234234","atc"};
        ArrayList<String> output = groupAnagram(input);

        for(int i = 0; i < output.size(); i++) {
            System.out.println(output.get(i) + " ");
        }


    }

    private static ArrayList<String> groupAnagram(String[] input){
        HashMap<String,ArrayList<String>> map = new HashMap<String, ArrayList<String>>();

        for(int i = 0; i < input.length; i++) {
            String word = input[i];
            char[] sortedWord = input[i].toCharArray();
            Arrays.sort(sortedWord);
            String sortedWordStr = new String(sortedWord);

            if(!map.containsKey(sortedWordStr)) {
                ArrayList<String> arr = new ArrayList<String>();
                arr.add(word);

                map.put(sortedWordStr, arr);
            } else {
                ArrayList<String> arr = map.get(sortedWordStr);
                arr.add(word);

                map.put(sortedWordStr, arr);
            }
        }

        ArrayList<String> output = new ArrayList<String>();
        for(String key: map.keySet()) {
            output.addAll(map.get(key));
        }

        return output;
    }

}
