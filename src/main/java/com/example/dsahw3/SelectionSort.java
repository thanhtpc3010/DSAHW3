package com.example.dsahw3;

import Entity.Student;

public class SelectionSort {
    public static void sort(Student[] students) {
        int n = students.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (students[j].getScore() < students[minIndex].getScore()) {
                    minIndex = j;
                }
            }

            // Hoán đổi vị trí
            Student temp = students[minIndex];
            students[minIndex] = students[i];
            students[i] = temp;
        }
    }
}
