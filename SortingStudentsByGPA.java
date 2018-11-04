package pract6;

import java.util.Scanner;

public class SortingStudentsByGPA implements Comparator{
    static Student[] students = new Student[3];

    public static void main(String[] args) {

        for(int i = 0; i < students.length; i++) {
            Scanner in = new Scanner(System.in);
            students[i] = new Student();
            students[i].setScore(in.nextInt());
            students[i].setName(in.next());
        }

        SortingStudentsByGPA s = new SortingStudentsByGPA();
        s.sortByScore(students, 0, students.length - 1);
        for(Student s1 : students) {
            System.out.println("Student name - " + s1.getName());
            System.out.println("Score - " + s1.getScore());
        }

    }

    @Override
    public void sortByScore(Student[] students, int low, int high) {
        if(students.length == 0) return;
        if(low >= high) return;

        int middle = low + (high - low) / 2;
        int middleElement = students[middle].getScore();

        int i = low, j = high;
        while (i < j) {
            while(students[i].getScore() > middleElement) i++;
            while(students[j].getScore() < middleElement) j--;

            if(i <= j) {
                Student s = students[i];
                students[i] = students[j];
                students[j] = s;
                i++;
                j--;
            }
        }

        if(low < j) {
            sortByScore(students, low, j);
        }
        if(high > i) {
            sortByScore(students, i, high);
        }
    }
}