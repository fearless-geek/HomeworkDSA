package Homework2;

import java.util.Scanner;

class MyStack {

    String[] data;
    int top;

    MyStack(int size) {
        data = new String[size];
        top = -1;
    }

    void push(String x) {
        top++;
        data[top] = x;
    }

    String pop() {
        String x = data[top];
        top--;
        return x;
    }
}

public class Task1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите постфиксное выражение:");
        String s = scanner.nextLine();

        MyStack stack = new MyStack(100);

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            if (c == '+' || c == '-' || c == '*') {

                String b = stack.pop();
                String a = stack.pop();

                stack.push("(" + a + c + b + ")");
            }
            else {
                stack.push("" + c);
            }
        }

        System.out.println("Результат:");
        System.out.println(stack.pop());
    }
}