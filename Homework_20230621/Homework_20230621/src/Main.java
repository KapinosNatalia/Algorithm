public class Main {
    public static void main(String[] args) {
        /*
        * Task 1. Имея два отсортированных массива размера m и n соответственно, вам нужно найти элемент, который будет находиться на k-й позиции в конечном отсортированном массиве.
        Массив 1 - 100 112 256 349 770
        Массив 2 - 72 86 113 119 265 445 892
        к = 7
        Вывод : 256
        Окончательный отсортированный массив -
        72, 86, 100, 112, 113, 119, 256, 265, 349, 445, 770, 892
        7-й элемент этого массива равен 256.
        Массивы приведены для примера. Алгоритм должен работать и на других массивах.
        */
        int[] arr1 = {100, 112, 256, 349, 770}; //{1,2,3};
        int[] arr2 = {72, 86, 113, 119, 265, 445, 892}; //{4,5,6,7,8};
        int k = 7;
        getElement(arr1, arr2, k);


        /*
        Task 2. Реализовать рекурсивный алгоритм бинарного поиска. Используйте стратегию "разделяй и властвуй".
        * */
        System.out.println("Task 2: " + findIndex(arr2, 119));
    }

    // Task 1. --------------------------------------------------------------------------------------------------------
    public static void getElement(int[] arr1, int[] arr2, int k) {
        if (arr1[arr1.length -1] < arr2[0]) {
            firstCase(arr1, arr2, k);
        } else if (arr2[arr2.length -1] < arr1[0]) {
            firstCase(arr2, arr1, k);
        } else {
            mainCase(arr1, arr2, k);
        }

    }

    public static void firstCase(int[] arr1, int[] arr2, int k) {
        if (arr1.length > k) {
            System.out.println(arr1[k-1]);
        } else {
            System.out.println(arr2[k - arr1.length - 1]);
        }
    }

    public static void mainCase(int[] arr1, int[] arr2, int k){
        int count1 = 0;
        int count2 = 0;
        int count = 0;
        int[] arr3 = new int[arr1.length + arr2.length];
        while (count < k) {
            if (count1 < arr1.length && arr1[count1] < arr2[count2]) {
                arr3[count] = arr1[count1];
                count1++;
            }
            else {
                arr3[count] = arr2[count2];
                count2++;
            }
            count++;
        }
        System.out.println(arr3[k-1]);
    }

    // Task 2. --------------------------------------------------------------------------------------------------------
    public static int binarySearch(int[] arr, int left, int right, int value) {
        if (left == right) {
            if (arr[left] == value) {
                return left;
            } else {
                return -1;
            }
        }
        int mid = (right - left)/2;
        if (value == arr[left + mid])
            return left + mid;
        else if (value < arr[left + mid]) {
            return binarySearch(arr, left, left + mid - 1, value);
        } else {
            return binarySearch(arr, left + mid + 1, right, value);
        }
    }

    public static int findIndex(int[] arr, int value) {
        return binarySearch(arr, 0, arr.length - 1, value);
    }


}
