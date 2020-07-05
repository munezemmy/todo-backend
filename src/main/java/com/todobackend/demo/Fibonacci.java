package com.todobackend.demo;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Fibonacci {

    public static void main(String[] args) {
        System.out.println(fibb(15));
    }


    public static List<Integer> fibb(int num){
        return Stream.iterate(new int[]{0,1}, s->new int[]{s[1], s[0]+s[1]})
                .limit(num)
                .map(a->a[0])
                .collect(Collectors.toList());
    }
}
