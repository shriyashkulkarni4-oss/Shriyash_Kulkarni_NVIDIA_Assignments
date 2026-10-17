package Shriyash_Kulkarni_NVIDIA_Assignments.Week2;

import java.util.*;

public class Question4 {

    static long countPairs(int[] a) {
        return mergeSort(a, 0, a.length - 1);
    }

    static long mergeSort(int[] a, int left, int right) {
        if (left >= right) {
            return 0;
        }

        int mid = left + (right - left) / 2;

        long count = 0;

        count += mergeSort(a, left, mid);
        count += mergeSort(a, mid + 1, right);
        count += merge(a, left, mid, right);

        return count;
    }

    static long merge(int[] a, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];

        int i = left;
        int j = mid + 1;
        int k = 0;
        long count = 0;

        while (i <= mid && j <= right) {
            if (a[i] <= a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
                count += mid - i + 1;
            }
        }

        while (i <= mid) {
            temp[k++] = a[i++];
        }

        while (j <= right) {
            temp[k++] = a[j++];
        }

        for (int x = 0; x < temp.length; x++) {
            a[left + x] = temp[x];
        }

        return count;
    }

    public static void main(String[] args) {
        int[] a = {5, 3, 2, 4, 1};

        System.out.println(countPairs(a));
    }
}
