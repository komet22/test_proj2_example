/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import org.junit.Test;
import static org.junit.Assert.*;

public class StringCalculatorTest {
    /*@Test(expected = RuntimeException.class)
    public final void whenMoreThan2NumbersAreUsedThenExceptionIsThrown() {
        StringCalculator.add("1,2,3");
    }*/
    @Test
    public final void when2NumbersAreUsedThenNoExceptionIsThrown() {
        StringCalculator.add("1,2");
        assertTrue(true);
    }
    @Test(expected = RuntimeException.class)
    public final void whenNonNumberIsUsedThenExceptionIsThrown() {
        StringCalculator.add("1,X");
    }
    
    @Test
    public final void whenEmptyStringIsUsedThenReturnValueIs0() {
        assertEquals(0, StringCalculator.add(""));
    }
    
    @Test
    public final void whenOneNumberIsUsedThenReturnValueIsThatSameNumber() {
        assertEquals(3, StringCalculator.add("3"));
    }
 
    @Test
    public final void whenTwoNumbersAreUsedThenReturnValueIsTheirSum() {
        assertEquals(3+6, StringCalculator.add("3,6"));
    }
    
    @Test
    public final void whenAnyNumberOfNumbersIsUsedThenReturnValuesAreTheirSums() {
        assertEquals(3+6+15+18+46+33, StringCalculator.add("3,6,15,18,46,33"));
    }
    
    @Test
    public final void whenNewLineIsUsedBetweenNumbersThenReturnValuesAreTheirSums() {
        assertEquals(3+6+15, StringCalculator.add("3,6\n15"));
    }
    
    @Test
    public final void whenDelimiterIsSpecifiedThenItIsUsedToSeparateNumbers() {
        assertEquals(3+6+15, StringCalculator.add("//;\n3;6;15"));
    }
    
    @Test(expected = RuntimeException.class)
    public final void whenNegativeNumberIsUsedThenRuntimeExceptionIsThrown() {
        StringCalculator.add("3,-6,15,18,46,33");
    }
    
    @Test
    public final void whenNegativeNumbersAreUsedThenRuntimeExceptionIsThrown() {
    RuntimeException exception = null;
        try {
            StringCalculator.add("3,-6,15,-18,46,33");
        } catch (RuntimeException e) {
            exception = e;
        }
        assertNotNull(exception);
        assertEquals("Negatives not allowed: [-6, -18]", exception.getMessage());
    }
    
    @Test
    public final void whenOneOrMoreNumbersAreGreaterThan1000IsUsedThenItIsNotIncludedInSum() {
        assertEquals(3+1000+6, StringCalculator.add("3,1000,1001,6,1234"));
    }
    
    @Test
    public final void delimiterCanBeMultiCharacter() {
        assertEquals(1+2+3, StringCalculator.add("//[%%]\n1%%2%%3"));
    }
}
