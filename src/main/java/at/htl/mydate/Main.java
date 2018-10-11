package at.htl.mydate;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int counter = 1;
        MyDate date;
        MyDate youngestDate = new MyDate("0.0.0");

        System.out.println("Date-Manager");
        System.out.println("============");

        System.out.print(counter + ". Datum: ");
        date = new MyDate(scanner.next());

        while (!(date.getDate().equals("quit"))) {
            if (date.isYoungerThan(youngestDate)) {
                youngestDate = date;
            }
            System.out.println(youngestDate.formatDate());

            System.out.print(counter + ". Datum: ");
            date = new MyDate(scanner.next());

        }
    }
}
