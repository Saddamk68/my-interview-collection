/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myinterviewcollection.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author saddam
 */
public class Java8MainClass {

    public static void main(String[] arg) {
        Java8FeaturesImpl java8FeatureImpl = new Java8FeaturesImpl();

        String[] strArr = {"jaVa", "Spring", "Microservices", "java", "SqL", "Java", "cLoud", "spring"};
        java8FeatureImpl.countOccurrence(strArr);

        List<Integer> intList = Arrays.asList(10, 15, 8, 49, 25, 98, 12);
        java8FeatureImpl.filterUsingStartWith(intList);

        System.out.println("Sort list using stream functionality : " + java8FeatureImpl.sortList(intList));
        System.out.println("Multiply each element of list : " + java8FeatureImpl.multiplyEachElement(intList, 3));

        System.out.println("Non-repeated first character from a string is : "
                + java8FeatureImpl.nonRepeatedCharecter("Ava"));

        java8FeatureImpl.findRecentThreeOrders();

        String strDollar = "#1 Tickets $50,000 Received $40. Expenses $800 . Cheque$2,00,000.";
        System.out.println("Given string is : " + strDollar);
        java8FeatureImpl.findSumOfAmountFromGivenString(strDollar);

        System.out.println("Max length string is : " + java8FeatureImpl.findMaxLengthWordFromGivenString(strDollar));
        java8FeatureImpl.sortGivenStringUsingStream(strDollar);
        
        int[] intArr = {1, 2, 3, 4, 5, 6, 7, 8, 2, 7, 7, 6};
        java8FeatureImpl.filterOddEvenNumber(intArr);
        
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 2, 7, 7, 6);
        System.out.println("Sum of given integer array is : " 
                + java8FeatureImpl.findSumOfIntegerList(new ArrayList<>(integerList)));
        
        java8FeatureImpl.removeDuplicates(new ArrayList<>(integerList));
        java8FeatureImpl.findDuplicates(new ArrayList<>(integerList));
        java8FeatureImpl.findMaxValueFromIntegerList(new ArrayList<>(integerList));
        java8FeatureImpl.findCubeOfIntegerListNotGreaterThan50(new ArrayList<>(integerList));
        
    }

}
