package Week2;
import java.util.*;

public class Question1 {

    public static int longestConsecutive(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int longest = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {

                int current = num;
                int length = 1;

                while (set.contains(current + 1)) {
                    current++;
                    length++;
                }

                longest = Math.max(longest, length);
            }
        }
        return longest;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();

        int arr[] = new int[size];
        for(int i = 0 ; i < size; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(longestConsecutive(arr));
    }
}