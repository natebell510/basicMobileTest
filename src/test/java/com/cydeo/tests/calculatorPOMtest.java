package com.cydeo.tests;

import com.cydeo.pages.CalculatorPage;
import com.cydeo.utils.Driver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class calculatorPOMtest {
    CalculatorPage calculatorPage = new CalculatorPage();

    @Test
    public void test1() {

        calculatorPage.clickSingleDigit(5);
        calculatorPage.multiply.click();
        calculatorPage.clickSingleDigit(8);
        calculatorPage.equals.click();
        String result = calculatorPage.result.getText();

        System.out.println("result = " + result);

        assertEquals(40, Integer.parseInt(result) );


    }

    @BeforeEach
    public void tearDown() {
        Driver.closeDriver();
    }
}
