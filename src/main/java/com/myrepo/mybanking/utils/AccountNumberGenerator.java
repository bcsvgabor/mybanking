package com.myrepo.mybanking.utils;

import java.util.Random;

public class AccountNumberGenerator {

    public Long generateNumber(Long inputId){

        int totalLen = 10;
        int inputLen = String.valueOf(inputId).length();

        StringBuilder accNum = new StringBuilder();

        int genLen = totalLen - inputLen;

        for(int i = 0; i <= genLen; i++){

            Random ran = new Random();
            int x = ran.nextInt(10) + 0;

            accNum.append(x);
        }
        accNum.append(inputId);

        String accountNumberString = accNum.toString();

        return Long.valueOf(accountNumberString);
    }
}
