package myinterviewcollection.test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author $ADDAM
 */
public class ArrayInterviewProg {

    /* 
     * find subarray with given sum 
     * time compelexity is n^2
     */
    public static int subArraySum(int[] arr, int arrLength, int sum) {
        int currSum;
        for (int i = 0; i < arrLength; i++) {
            currSum = arr[i];
            for (int j = i + 1; j <= arrLength; j++) {
                if (currSum == sum) {
                    System.out.println("sum found between indexs : " + i + " " + (j - 1));
                    return 1;
                }
                if (currSum > sum || j == arrLength) {
                    break;
                }
                currSum = currSum + arr[j];
            }
        }
        System.out.println("no sub array found");
        return 0;
    }

    /* 
     * find subarray with given sum 
     * time compelexity is n
     */
    public static int eficientSubArraySum(int[] arr, int arrLength, int sum) {
        int currSum = arr[0];
        int start = 0;
        for (int i = 1; i <= arrLength; i++) {
            while (currSum > sum && start < i - 1) {
                currSum = currSum - arr[start];
                start++;
            }
            if (currSum == sum) {
                System.out.println("sum found between indexs : " + start + " " + (i - 1));
                return 1;
            }
            if ( i < arrLength) {
                currSum += arr[i];
            }
        }
        System.out.println("no sub array found");
        return 0;
    }

}
