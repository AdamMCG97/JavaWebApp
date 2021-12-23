package com.develogical;

public class QueryProcessor {

    public String process(String query) {
        if (query.toLowerCase().contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        }
        else if(query.toLowerCase().contains("your name")) {
            return "Adam-Sai-Surbhi";
        } else if(query.toLowerCase().contains("which of the following numbers is the largest:")) {
            String numbersString = query.substring(query.indexOf(":") + 2);
            String[] numbersArray = numbersString.split(", ");
            return String.valueOf(maximumOfStringArray(numbersArray));
        }
        else {
            return "";
        }

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
