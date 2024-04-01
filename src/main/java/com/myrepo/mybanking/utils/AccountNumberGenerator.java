package com.myrepo.mybanking.utils;

import java.util.Random;

/**
 * AccountNumberGenerator returns 10 digit number, takes a long number input which is the account id.
 * This makes every single account number individual.
 * The number can be max 10 digits.
 * If the account id is 3 digits the generator will fill up the rest 7 digits with random number.
 * If the account id is 4 digits, the generator will fill up the rest with 6 digits and so on...
 */

public class AccountNumberGenerator {

    public Long generateNumber(Long inputId) {

        int totalLen = 10;
        int inputLen = String.valueOf(inputId).length();

        StringBuilder accNum = new StringBuilder();

        int genLen = totalLen - inputLen;

        for (int i = 0; i < genLen; i++) {

            Random ran = new Random();
            int x = ran.nextInt(10) + 0;

            accNum.append(x);
        }
        accNum.append(inputId);

        String accountNumberString = accNum.toString();

        return Long.valueOf(accountNumberString);
    }
}
