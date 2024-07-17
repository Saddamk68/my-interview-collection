/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myinterviewcollection.epam;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author Saddam Khan
 */
public class Epam {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        System.out.println(test(0));
        System.out.println(test(1));
        
        int[] numbers = {1, 3, 4, 5, 78, 9};
        System.out.println("Matched indices are : " + Arrays.toString(findMatchedIndices(numbers, 13)));

        String[] strArr = {"jaVa", "Spring", "Microservices", "java", "SqL", "Java", "cLoud", "spring"};
        countDuplicates(strArr);
        
        
        PersonDAO personDAO = new PersonDAO();
        // Adding persons to the cache
        personDAO.addOrUpdate(new Person(1, "Alice"));
        personDAO.addOrUpdate(new Person(2, "Bob"));
        personDAO.addOrUpdate(new Person(3, "Charlie"));

        // Getting person by ID
        Person person1 = personDAO.getById(1);
        System.out.println("Person 1: " + person1.getName());

        // Removing person from cache
        personDAO.removeFromCache(2);
        Person person2 = personDAO.getById(2);
        if (person2 == null) {
            System.out.println("Person 2 not found in cache.");
        }

        // Clearing the cache
        personDAO.clearCache();
        Person person3 = personDAO.getById(3);
        if (person3 == null) {
            System.out.println("Person 3 not found in cache after clearing.");
        }

    }

    public static int[] findMatchedIndices(int[] numArr, int sumElem) {
        for (int i = 0; i < numArr.length - 1; i++) {
            for (int j = i + 1; j < numArr.length; j++) {
                if (sumElem == numArr[i] + numArr[j]) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public static void countDuplicates(String[] strArr) {
        HashMap<String, Integer> map = new HashMap<>();
        List<String> strList = Arrays.asList(strArr);

        strList.forEach(str -> {
            String tepStr = str.toLowerCase();
            if (map.containsKey(tepStr)) {
                map.put(tepStr, map.get(tepStr) + 1);
            } else {
                map.put(tepStr, 1);
            }
        });

//        map.entrySet().forEach(entry -> {
        for (Map.Entry entry : map.entrySet()) {
            System.err.println(entry.getKey() + " : " + entry.getValue());
        }
//        });
    }

    public static int test(int i) {
        try {
            if (i == 0) {
                throw new Exception();
            }
            return 0;
        } catch (Exception e) {
            return 1;
        } finally {
            return 2;
        }
    }

}
