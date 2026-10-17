package Shriyash_Kulkarni_NVIDIA_Assignments.Week2;

import java.util.*;

public class Question2 {

    public static int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();

        freq.put(0, 1);

        int prefixSum = 0;
        int count = 0;

        for (int num : nums) {
            prefixSum += num;

            if (freq.containsKey(prefixSum - k)) {
                count += freq.get(prefixSum - k);
            }

            freq.put(prefixSum, freq.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] nums = new int[n];
       
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println("Enter k");
        int k = sc.nextInt();

        System.out.println("Number of subarrays: " + subarraySum(nums, k));
    }
}