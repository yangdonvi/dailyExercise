package com.donvi;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class test {


    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.forEach(i -> {
            if (i == 2){
                return;
            }
            System.out.println(i);
        });


    }



}
