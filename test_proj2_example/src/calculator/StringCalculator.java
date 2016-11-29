/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
    public static int add(final String numbers) {
        String delimiter = ",|\n";
        String numbersWithoutDelimiter = numbers;
        if (numbers.startsWith("//")) {
            int delimiterIndex = numbers.indexOf("//") + 2;
            delimiter = "";
            if (numbers.startsWith("//[")) {
                while(numbers.startsWith("[", delimiterIndex)) {
                    delimiterIndex = numbers.indexOf("[", delimiterIndex) + 1;
                    if (!delimiter.isEmpty()) {
                        delimiter += "|" + numbers.substring(delimiterIndex, numbers.indexOf("]", delimiterIndex));
                    }
                    else delimiter = numbers.substring(delimiterIndex, numbers.indexOf("]", delimiterIndex));
                    delimiterIndex = numbers.indexOf("]", delimiterIndex) + 1;
                }
            }
            else delimiter = numbers.substring(delimiterIndex, delimiterIndex+1);
            numbersWithoutDelimiter = numbers.substring(numbers.indexOf("\n") + 1);
        }
        return add(numbersWithoutDelimiter, delimiter);
    }
 
    private static int add(final String numbers, final String delimiter) {
        int returnValue = 0;
        String[] numbersArray = numbers.split(delimiter);
        List negativeNumbers = new ArrayList();
        for (String number : numbersArray) {
            if (!number.trim().isEmpty()) {
                int numberInt = Integer.parseInt(number.trim());
                if (numberInt < 0) {
                    negativeNumbers.add(numberInt);
                } else if (numberInt <= 1000) {
                    returnValue += numberInt;
                }
            }
        }
        if (negativeNumbers.size() > 0) {
            throw new RuntimeException("Negatives not allowed: " + negativeNumbers.toString());
        }
        return returnValue;
    }
}
