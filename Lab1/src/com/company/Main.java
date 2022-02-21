package com.company;

import java.sql.SQLOutput;

public class Main {

    public static void main(String[] args) {
        // write your code here
        System.out.println("Hello World!");
        String arrayCeva[] = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};

        int n = (int) (Math.random() * 1_000_000);
        System.out.println(n);

        int rez = n ;

        rez  *= 3;
        rez +=  0b10101;
        rez +=  0xFF;
        rez *= 6;

        int result = rez;
        int copy,digit,sum ;
        copy = n;
        while(result > 10 )
        {
            copy = result ;
            sum = 0;

            while(copy > 0)
            {
                digit = copy % 10;
                sum = sum + digit;
                copy = copy / 10;
            }
            result = sum;
//            System.out.println(result);
        }
        System.out.println(arrayCeva[result]);
    }

}
