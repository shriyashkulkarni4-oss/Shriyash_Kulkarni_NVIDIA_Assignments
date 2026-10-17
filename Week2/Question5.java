package Shriyash_Kulkarni_NVIDIA_Assignments.Week2;

import java.util.*;

public class Question5 {

    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<Integer>();
        boolean flag = true;

        for (int i = 0; i < asteroids.length; i++) {
            boolean visFlag = false;
            flag = asteroids[i] < 0;

            if (st.isEmpty()) {
                st.push(asteroids[i]);
                continue;
            }

            while (!st.isEmpty() && st.peek() >= 0 && flag) {
                visFlag = true;

                int a = Math.abs(st.peek());
                int b = Math.abs(asteroids[i]);

                if (a < b) {
                    st.pop();
                } 
                else if (a == b) {
                    st.pop();
                    flag = false;
                } 
                else {
                    flag = false;
                }
            }

            if (flag || !visFlag) {
                st.push(asteroids[i]);
            }
        }

        int[] newArr = new int[st.size()];
        int cnt = st.size() - 1;

        while (!st.isEmpty()) {
            newArr[cnt] = st.pop();
            cnt--;
        }

        return newArr;
    }

    public static void main(String[] args) {

        int[] asteroids = {5, 10, -5};

        int[] result = asteroidCollision(asteroids);

        System.out.println(Arrays.toString(result));
    }
}