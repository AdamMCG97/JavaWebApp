package com.develogical;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class QueryProcessor {

    public String process(String query) {
        try {
            System.out.println("Query received: " + query);
            return processQuery(query);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return "Error processing query" ;
        }
    }

    private String processQuery(String query) {
        String actualQuery = query.substring(query.indexOf(":") + 1);
        if (actualQuery.toLowerCase().contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        }
        else if(actualQuery.toLowerCase().contains("your name")) {
            return "Adam-Sai-Surbhi";
        } else if(actualQuery.toLowerCase().contains("which of the following numbers is the largest:")) {
            String[] numbersArray = getNumbersFromString(actualQuery);
            return String.valueOf(maximumOfStringArray(numbersArray));
        } else if(actualQuery.toLowerCase().contains("plus")) {
            String[] equation = actualQuery.split("is ");
            String[] numbers = equation[1].split(" plus ");
            int total = sumNumbersFromString(numbers);
            return String.valueOf(total);
        } else if(actualQuery.toLowerCase().contains("multiplied")) {
            String[] equation = actualQuery.split("is ");
            String[] numbers = equation[1].split(" multiplied by ");
            int total = multiplyNumbersFromString(numbers);
            return String.valueOf(total);
        } else if(actualQuery.toLowerCase().contains("which of the following numbers are primes:")) {
            String[] numbersArray = getNumbersFromString(actualQuery);
            List<Integer> intArray = Arrays.stream(numbersArray).map(Integer::parseInt).collect(Collectors.toList());
            List<String> primeInts = intArray.stream().filter(x -> !isPrime(x)).map(String::valueOf).collect(Collectors.toList());
            return String.join(", ", primeInts);
        }
        else if(actualQuery.toLowerCase().contains("fibonacci")) {
            String[] equation = actualQuery.split("is the ");
            String[] number = equation[1].split(" ");
            String actualNumber = number[0].substring(0, number[0].length() - 2);
            return String.valueOf(fibonnaciOf(Integer.parseInt(actualNumber)));
        }
         else if(actualQuery.toLowerCase().contains("dr no")) {
             return "Sean Connery";
        }
        else if(actualQuery.toLowerCase().contains("theresa may")) {
            return "2016";
        }
        else if(actualQuery.toLowerCase().contains("banana")) {
            return "yellow";
        }
        else if(actualQuery.toLowerCase().contains("eiffel tower")) {
            return "paris";
        }
        else if(actualQuery.toLowerCase().contains("both a square and a cube")) {
            return "";
        }
        else {
            return "";
        }
    }

    private int fibonnaciOf(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Not defined for indices < 0");
        }
        if (i < 2) {
            return 1;
        }
        return fibonnaciOf(i - 1) + fibonnaciOf(i - 2);
    }


    private boolean isPrime(Integer num) {
        boolean flag = false;
        for (int i = 2; i <= num / 2; ++i) {
            // condition for nonprime number
            if (num % i == 0) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    private int sumNumbersFromString(String[] numbers) {
        return Integer.parseInt(numbers[0]) + Integer.parseInt(numbers[1]);
    }

    private int multiplyNumbersFromString(String[] numbers) {
        return Integer.parseInt(numbers[0]) * Integer.parseInt(numbers[1]);
    }


    private String[] getNumbersFromString(String query) {
        String numbersString = query.substring(query.indexOf(":") + 2);
        return numbersString.split(", ");
    }

    private int maximumOfStringArray(String[] array) {
        int maximum = 0;
        for(String element: array) {
            int elementInt = Integer.parseInt(element);
            if(elementInt > maximum) {
                maximum = elementInt;
            }
        }
        return maximum;
    }
}
