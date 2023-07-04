import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        task1(new int[] {5, 2, 4, 1, 3});

        int[] arr = {9, 7, 9, 9};//{1, 2, 3};
        System.out.println(Arrays.toString(task2_v1(arr)));
        System.out.println(Arrays.toString(task2_v2(arr)));
    }

    public static void task1(int[] arr) {
        int[] result = mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(result));
    }

    public static int[] mergeSort(int[] arr, int left, int right) {
        if (left > right) {
            return new int[] {};
        }
        else if (left == right) {
            return new int[] {arr[left]};
        }
        int mid = left + (right - left)/2;
        int[] a1 = mergeSort(arr, left, mid);
        int[] a2 = mergeSort(arr, mid + 1, right);
        int i = 0;
        int j = 0;
        int k = 0;
        int[] a3 = new int[a1.length + a2.length];
        while (i < a1.length && j < a2.length) {
            if (a1[i] <= a2[j]) {
                a3[k] = a1[i];
                i++;
            }
            else if (a1[i] > a2[j]) {
                a3[k] = a2[j];
                j++;
            }
            k++;
        }
        while (i < a1.length) {
            a3[k] = a1[i];
            i++;
            k++;
        }
        while (j < a2.length) {
            a3[k] = a2[j];
            j++;
            k++;
        }

        return a3;
    }

    public static int[] task2_v2(int[] arr) {
        if (arr == null || arr.length == 0) {
            return new int[] {};
        }
        if (arr[arr.length - 1] < 9) {
            arr[arr.length - 1] = arr[arr.length - 1] + 1;
            return arr;
        }

        // сделаем результирующий массив на 1 больше, на случай переноса 1 в новый разряд
        int[] result = new int[arr.length + 1];
        int additionalOne = 1;
        for (int i = arr.length - 1; i >=0 ; i--) {
            if (additionalOne != 1) {
                result[i + 1] = arr[i];
            }
            else if (arr[i] == 9) {
                result[i + 1] = 0;
            }
            else {
                result[i + 1] = arr[i] + additionalOne;
                additionalOne = 0;
            }
        }
        result[0] = additionalOne;
        return result;
    }

    public static int[] task2_v1(int[] arr) {
        int number = 0;
        for (int i = 0; i < arr.length; i++) {
            number += arr[i]*Math.pow(10,arr.length - i - 1);
        }
        number++;
        int[] result = new int [(int) Math.log10(number) + 1];
        int curElement;
        int i = result.length;
        while (number!=0) {
            curElement = number % 10;
            number = (number - curElement)/10;
            result[i-1] = curElement;
            i--;
        }
        return result;
    }
}
