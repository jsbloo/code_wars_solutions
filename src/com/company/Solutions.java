package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Solutions {

    public static String camelCase(String input) {
        StringBuilder sb = new StringBuilder();

        int index = 0;

        for (int i = 0; i < input.length(); i++) {
            if(Character.isUpperCase(input.charAt(i))){
                sb.append(input, index, i).append(" ");

            }
            if(i==input.length()-1) {
                sb.append(input,index,i+1);
            }
        }
        return sb.toString();
    }

    public static String whoLikesIt(String... names) {
        var namesList = Arrays.stream(names).toList();

        return switch (names.length) {
            case 0 -> "No one likes this";
            case 1 -> namesList.get(0) + " likes this";
            case 2 -> namesList.get(0) + " and " + namesList.get(1) + " like this";
            case 3 -> namesList.get(0) + ", " + namesList.get(1) + " and " + namesList.get(2) + " like this";
            default -> namesList.get(0) + ", " + namesList.get(1) + " and " + (names.length - 2) + " others like this";
        };
    }

    public static int[] deleteNth(int[] elements, int maxOccurrences) {

        HashMap<Integer,Integer> setCount = new HashMap<>();
        ArrayList<Integer> intList = new ArrayList<>();

        if(maxOccurrences <=0){
            return new int[0];
        }

        for (int i:
             elements) {
            if(setCount.containsKey(i)){
                if(setCount.get(i) < maxOccurrences){
                    setCount.merge(i,1,Integer::sum);//fastest way to increment value
                    intList.add(i);
                }
            }
            else {
                intList.add(i);
                setCount.put(i,1);
            }
        }

        return intList.stream().mapToInt(i -> i).toArray();
        //converting to primitive array because im lazy
    }
}


