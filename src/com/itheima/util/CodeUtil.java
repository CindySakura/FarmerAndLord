package com.itheima.util;

import java.util.ArrayList;
import java.util.Random;

public class CodeUtil {
    static Random r = new Random();
    static int codelen = 5;
    public static String getCode(){
      //自己练习
        StringBuilder sb = new StringBuilder();
        char[] arr = new char[52];
        int arrlen = arr.length;
        char[] code = new char[codelen];
        int alph = 4;

        for (int i = 0; i < arrlen; i++) {
            if(i<26){
                arr[i] = (char)(97+i);
            } else {
                arr[i] = (char)(65+i-26);
            }
        }

        for (int i = 0; i < alph; i++) {
            int aplhindex = r.nextInt(arrlen);
            code[i] = arr[aplhindex];
        }
        code[codelen-1] = (char)(r.nextInt(10)+48); //add number char
        code = randomize(code);

        for (int i = 0; i < codelen; i++) {
            sb.append(code[i]);
        }

        return sb.toString();
    }

    public static String getCodeWoutO(){
        StringBuilder sb = new StringBuilder();
        char[] arr = new char[60]; //without O/o
        int count = 0;

        for (int i = 0; i < 62; i++) {
            if(i == 'o'-'a' || i == ('O'-'A')+26){
                continue;
            }
            if(i<26){
                arr[count] = (char)(97+i);
            } else if(i<52){
                arr[count] = (char)(65+i-26);
            }else{
                arr[count] = (char)(48+i-52);
            }
            count++;

        }

        for (int i = 0; i < codelen; i++) {
            sb.append(arr[r.nextInt(60)]);
        }

        return sb.toString();
    }

    public static String getCodeRandL(){
        int length = r.nextInt(2);
        StringBuilder sb = new StringBuilder();
        char[] arr = new char[62];
        int count = 1;

        if(length == 0){
            length = 4;
        }else {
            length = 5;
        }

        for (int i = 0; i < 62; i++) {
            if(i<26){
                arr[i] = (char)(97+i);
            } else if(i<52){
                arr[i] = (char)(65+i-26);
            }else{
                arr[i] = (char)(48+i-52);
            }
        }

        int index = r.nextInt(arr.length);
        sb.append(arr[index]);
        while(count != length){
            index = r.nextInt(arr.length);
            if ((sb.charAt(count-1) > '0' && sb.charAt(count-1) < '9')
                    && (arr[index] > '0' && arr[index] < '9')){
                continue;
            }else{
                sb.append(arr[index]);
                count ++;
            }
        }

        return sb.toString();
    }

    public static char[] randomize(char[] code){
        for (int i = 0; i < codelen; i++) {
            int index = r.nextInt(codelen);
            char tmp = code[index];
            code[index] = code[i];
            code[i] = tmp;
        }
        return code;
    }
}