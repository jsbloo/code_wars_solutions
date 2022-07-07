package com.company;

import java.util.*;
import java.util.function.Function;

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

    final static String FNAME = "John";
    final static String LNAME = "Smith";
    final static String studentNum = "js123";

    public static Function<Student, Boolean> f = (p) -> (p.getFullName().equals(FNAME + " " + LNAME)
            && p.studentNumber.equals(studentNum));

    public static int[] sortArray(int[] array) {
        /* You have to sort the odd numbers in ascending order
         while leaving the even numbers at their original positions. */

        ArrayList<Integer> odds = new ArrayList<>();

        for (int i : array) {
            if(i%2!=0){odds.add(i);};
        }

        Collections.sort(odds);

        int j =0;
        for(int i =0; i<array.length;i++){
            if(array[i]%2!=0){array[i]=odds.get(j); j++;};
        }

        return array;
    }

    public static int countSmileys(List<String> arr) {
        /*
        given an array (arr) as an argument complete the function countSmileys that should return the total number of smiling faces.
        Rules for a smiling face:

        Each smiley face must contain a valid pair of eyes. Eyes can be marked as : or ;
        A smiley face can have a nose but it does not have to. Valid characters for a nose are - or ~
        Every smiling face must have a smiling mouth that should be marked with either ) or D
        No additional characters are allowed except for those mentioned.

        Valid smiley face examples: :) :D ;-D :~)
        Invalid smiley faces: ;( :> :} :]*/

        int current = 0;
        int count = 0;

        int finalCurrent = current;
        Function<String,Boolean> get2nd = (e)-> arr.get(finalCurrent +1).equals(e);

        int finalCurrent1 = current;
        Function<String,Boolean> get3rd = (e)-> arr.get(finalCurrent1 +2).equals(e);

        while(current< arr.size()){
            try {
                if (arr.get(current).equals(":")) {
                    if (get2nd.apply("-") || get2nd.apply("~")) {
                        if (get3rd.apply(")") || get3rd.apply("D")) {
                            count++;
                            current+=3;
                        } else {
                            if (get2nd.apply(")") || get2nd.apply("D")) {
                                count++;
                                current+=2;
                            }
                        }
                    }
                }
            }catch (ArrayIndexOutOfBoundsException e){
                return count;
            }
            current+=1;
        }
        return count;
    }

    static long[] productFib(long n) {

        long[] f = new long[10000];
        long i;
        f[0] = 0;
        f[1] = 1;
        long j = 0;

        for (i = 2; i <= n; i++) {
            f[(int) i] = f[(int) (i - 1)] + f[(int) (i - 2)];
            long l = f[(int) j] * f[(int) (j + 1)];
            if(l>n){
                return new long[]{f[(int) j], f[(int) (j + 1)],0};
            }
            else if(l==n) {
                return new long[]{f[(int) j], f[(int) (j + 1)],1};
            }
            j++;
        }

        return new long[]{1,1,1}; //idk why u need this code wars
    }

    public static String orderWeight(String str) {

        TreeMap<Integer, ArrayList<String>> weightedWeights = new TreeMap<>();
        String[] s = str.split(" ");

        for (String n:
             s) {
            int weight = 0;
            for (char c : n.toCharArray()) {
                weight+=Integer.parseInt(String.valueOf(c));
            }
            weightedWeights.computeIfAbsent(weight,k -> new ArrayList<>()).add(n);
        }

        StringBuilder f = new StringBuilder("");
        weightedWeights.keySet().forEach(k -> weightedWeights.get(k).stream().sorted().forEach(z -> f.append(z).append(" ")));

        return f.substring(0,f.toString().length()-1);
    }
}




