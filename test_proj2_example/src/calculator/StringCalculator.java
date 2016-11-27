/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

public class StringCalculator {
    public static final int add(final String numbers) { // Changed void to int
        String[] numbersArray = numbers.split(",");
        if (numbersArray.length > 2) {
            throw new RuntimeException("Up to 2 numbers separated by comma (,) are allowed");
        } else {
            for (String number : numbersArray) {
                if (!number.isEmpty()) {
                Integer.parseInt(number);
                }
            }
        }
        return 0; // Added return
    }
}
