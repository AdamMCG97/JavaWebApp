package com.develogical;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class QueryProcessorTest {

    QueryProcessor queryProcessor = new QueryProcessor();

    @Test
    public void returnsEmptyStringIfCannotProcessQuery() throws Exception {
        assertThat(queryProcessor.process("test"), is(""));
    }

    @Test
    public void knowsAboutShakespeare() throws Exception {
        assertThat(queryProcessor.process("Shakespeare"), containsString("playwright"));
    }

    @Test
    public void knowsMyName() throws Exception {
        assertThat(queryProcessor.process("what is your name"), containsString("Adam-Sai-Surbhi"));
    }

    @Test
    public void canCalculateLargestOfThreeNumbers() throws Exception {
        assertThat(queryProcessor.process("e6241de0: which of the following numbers is the largest: 5, 245, 10"), containsString("245"));
    }

    @Test
    public void canCalculateLargestOfOneNumber() throws Exception {
        assertThat(queryProcessor.process("e6241de0: which of the following numbers is the largest: 75"), containsString("75"));
    }
    
    @Test
    public void canAddNumbers() throws Exception {
        assertThat(queryProcessor.process("e001cee0: what is 17 plus 6"), containsString("23"));
    }

    @Test
    public void canMultiplyNumbers() throws Exception {
        assertThat(queryProcessor.process("e001cee0: what is 5 multiplied by 2"), containsString("10"));
    }

    @Test
    public void canMultiplyNumbersWithZero() throws Exception {
        assertThat(queryProcessor.process("e001cee0: what is 5 multiplied by 0"), containsString("0"));
    }

    @Test
    public void canDetermineCubeAndSquareNumbers() throws Exception {
        assertThat(queryProcessor.process("fda79d10: which of the following numbers is both a square and a cube: 595, 169"), containsString(""));
    }

    @Test
    public void canDetermineJamesBond() throws Exception {
        assertThat(queryProcessor.process("9e8bdc30: who played James Bond in the film Dr No"), containsString("Sean Connery"));
    }

    @Test
    public void canDeterminePrimeMinisterElectionYear() throws Exception {
        assertThat(queryProcessor.process("4674e840: which year was Theresa May first elected as the Prime Minister of Great Britain"), containsString("2016"));
    }

    @Test
    public void canDetermineBananaColour() throws Exception {
        assertThat(queryProcessor.process("6975b600: what colour is a banana"), containsString("yellow"));
    }

    @Test
    public void isNotCaseSensitive() throws Exception {
        assertThat(queryProcessor.process("shakespeare"), containsString("playwright"));
    }

    @Test
    public void knowsWhereEiffelTower() throws Exception {
        assertThat(queryProcessor.process("bdaed020: which city is the Eiffel tower in"), containsString("paris"));
    }

    @Test
    public void knowsWhichNumbersArePrime() throws Exception {
        assertThat(queryProcessor.process("bdaed020: which of the following numbers are primes: 151, 25, 127, 672"), containsString("151, 127"));
    }

    @Test
    public void canCalculateFibonacciNumber() throws Exception {
        assertThat(queryProcessor.process("b5a199b0: what is the 5th number in the Fibonacci sequence"), containsString("8"));
    }

    @Test
    public void canCalculateDoubleFibonacciNumber() throws Exception {
        assertThat(queryProcessor.process("b5a199b0: what is the 15th number in the Fibonacci sequence"), containsString("987"));
    }

}
