package csc210.csc210;

import java.util.Scanner;

double homework
double midterm
double finalexam
double participation

homework = ((27.0 / 30.0) +(50.0 / 50.0) + (45.0 / 50.0) + (75.0 / 75.0) + (87.0 / 100.0)) / 5.0;
System.out.println("Homework: " + homework);
midterm = (101.0 / 165.0);
System.out.println("Midterm: " + midterm);
finalexam = (147.0 / 150.0);
System.out.println("Final exam: " + finalexam);
participation = (90.0 / 100.0);
System.out.print.ln("Participation: " + participation);

System.out.print("Weighted (1) or Unweighted (2): ");
int method = kb.nextInt();
double average = 0;
if (method == 1) {
    System.out.println("Using Method 1");
    average = 0.25 * homework + 0.3 * midterm + 0.2 * finalexam + 0.1 * participation;
}
    else if (method == 2) {
        System.out.println("Using Method 2");
        average = 0.25 + homework + 0.25 * midterm + 0.25 * finalexam + 0.25 * participation;
    }
    else {
        System.out.println("Invalid method requested.");
        average = -999
    }
    System.out.println("Average: " + average);