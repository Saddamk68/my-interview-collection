/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myinterviewcollection.recruitmentProgramForComp.onlinetestprogram;

/**
 *
 * @author Saddam Khan
 */
public class FindMissingSmallestPosNbr {

    public static int findMissingNbr(int arr[], int size) {
        int shift = getNegNbrFromGivenArray(arr, size);
        int arr2[] = new int[size - shift];
        int j = 0;
        for (int i = shift; i < size; i++) {
            arr2[j] = arr[i];
            j++;
        }
        return findMissingPosNbr(arr2, j);
    }

    public static int findMissingPosNbr(int arr[], int size) {
        int i = 0;
        for (; i < size; i++) {
            int x = Math.abs(arr[i]);
            if (x - 1 < size && arr[x - 1] > 0) {
                arr[x - 1] = -arr[x - 1];
            }
        }

        for (i = 0; i < size; i++) {
            if (arr[i] > 0) {
                return i + 1;
            }
        }

        return size + 1;
    }

    public static int getNegNbrFromGivenArray(int arr[], int size) {
        int j = 0, i;
        for (i = 0; i < size; i++) {
            if (arr[i] <= 0) {
                int temp;
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }
        return j;
    }

}
