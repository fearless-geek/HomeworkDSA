package Homework4;

public class MissingNumber {
    public static int findMissing(int[] arr) {
        int n = arr.length;

        long expectedSum = (long) n * (n + 1) / 2;

        long actualSum = 0;
        for (int num : arr) {
            actualSum += num;
        }

        return (int) (expectedSum - actualSum);
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 4};
        System.out.println("Пропущенное число: " + findMissing(arr));
    }
}
