package domain;

import java.util.Arrays;

public class Exercise {

    public static String calculate(int[] arr) {
        // не буде сортування якшо масив порожній або там один елемент 
        if (arr == null || arr.length < 2) {
            return Arrays.toString(arr);
        }

        int n = arr.length;
        int[] buffer = new int[n]; // сховище щоб не зникли дані

        for (int step = 1; step < n; step *= 2) {
            
            for (int left = 0; left < n; left += 2 * step) {
                
                int mid = Math.min(left + step, n);
                int right = Math.min(left + 2 * step, n);
                
                // порівняня елементів з двох сусідніх груп
                int i = left;
                int j = mid;
                int k = left; 
                
                while (i < mid && j < right) {
                    // перший елемент в буфер іде той що менше
                    if (arr[i] <= arr[j]) {
                        buffer[k++] = arr[i++];
                    } else {
                        buffer[k++] = arr[j++];
                    }
                }
                
                // додаємо елемент якщо в лівій групі щось залишилось
                while (i < mid) buffer[k++] = arr[i++];
                
                // додаємо елемент якщо в правій групі щось залишилось
                while (j < right) buffer[k++] = arr[j++];
            }
            
            // завантажуємо в основний масив все з буфера
            for (int i = 0; i < n; i++) {
                arr[i] = buffer[i];
            }
        }

        return Arrays.toString(arr);
    }
}