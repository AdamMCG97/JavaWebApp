package com.develogical;


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
        }
        else {
            return "";
        }
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
