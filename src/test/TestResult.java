package test;

import domain.Exercise;
import java.util.Arrays;

public class TestResult {
    public static void main(String[] args) {
        int[] arr = {20, 5, 10, 1, 15, 3, 7};
        
        System.out.println("до: " + Arrays.toString(arr));
        
        String res = Exercise.calculate(arr);
        
        System.out.println("після: " + res);
    }
}
