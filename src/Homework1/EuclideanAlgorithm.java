
package Homework1;

public class EuclideanAlgorithm {

    public static int findGCD(int a, int b) {
        if (a == 0 || b == 0) return 0;

        int remainder = a % b;
        if (remainder == 0) return b;

        return findGCD(b, a % b);
    }

    public static void main(String[] args) {
        System.out.println(findGCD(210, 45));
        System.out.println(findGCD(45, 210));
        System.out.println(findGCD(5, 0));
        System.out.println(findGCD(0, 5));
    }
}