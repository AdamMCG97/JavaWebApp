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
    public void isNotCaseSensitive() throws Exception {
        assertThat(queryProcessor.process("shakespeare"), containsString("playwright"));
    }
}
