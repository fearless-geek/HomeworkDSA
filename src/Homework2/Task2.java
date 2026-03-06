package Homework2;

import java.util.Scanner;

class MyHeap {

    int[] heap;
    int size;

    MyHeap(int capacity) {
        heap = new int[capacity];
        size = 0;
    }

    void insert(int x) {

        heap[size] = x;
        int i = size;
        size++;

        while (i > 0 && heap[(i - 1) / 2] > heap[i]) {

            int temp = heap[i];
            heap[i] = heap[(i - 1) / 2];
            heap[(i - 1) / 2] = temp;

            i = (i - 1) / 2;
        }
    }

    int remove() {

        int root = heap[0];
        heap[0] = heap[size - 1];
        size--;

        int i = 0;

        while (true) {

            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int smallest = i;

            if (left < size && heap[left] < heap[smallest]) {
                smallest = left;
            }

            if (right < size && heap[right] < heap[smallest]) {
                smallest = right;
            }

            if (smallest == i) break;

            int temp = heap[i];
            heap[i] = heap[smallest];
            heap[smallest] = temp;

            i = smallest;
        }

        return root;
    }
}

public class Task2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Размер первой очереди:");
        int n = scanner.nextInt();

        System.out.println("Размер второй очереди:");
        int m = scanner.nextInt();

        MyHeap heap = new MyHeap(n + m);

        System.out.println("Введите элементы первой:");
        for (int i = 0; i < n; i++) {
            heap.insert(scanner.nextInt());
        }

        System.out.println("Введите элементы второй:");
        for (int i = 0; i < m; i++) {
            heap.insert(scanner.nextInt());
        }

        System.out.println("Объединённая очередь:");

        while (heap.size > 0) {
            System.out.print(heap.remove() + " ");
        }
    }
}