package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        System.out.println(Solutions.camelCase("hiMyNameIsJosh"));
        System.out.println(Solutions.whoLikesIt("Peter" ,"Alex","Josh","Ross"));
        System.out.println(Arrays.toString(Solutions.deleteNth(new int[]{20, 37, 20, 21}, 1)));
    }
}
