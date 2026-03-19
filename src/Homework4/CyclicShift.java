package Homework4;

public class CyclicShift {
    public static boolean isCyclicShift(String s, String t) {

        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }

        int n = s.length();
        if (n == 0) return true;

        for (int i = 0; i < n; i++) {
            boolean match = true;

            for (int j = 0; j < n; j++) {
                if (s.charAt((i + j) % n) != t.charAt(j)) {
                    match = false;
                    break;
                }
            }

            if (match) return true;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(isCyclicShift("abcde", "cdeab"));
        System.out.println(isCyclicShift("abcde", "abced"));
    }
}
