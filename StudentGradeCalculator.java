import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Initialize variables
        int totalMarks = 0;
        int totalSubjects;
        double averagePercentage;
        
        // Prompt the user for the number of subjects
        System.out.print("Enter the total number of subjects: ");
        totalSubjects = scanner.nextInt();
        
        // Prompt the user for marks in each subject and calculate total marks
        for (int i = 1; i <= totalSubjects; i++) {
            System.out.print("Enter marks obtained in subject " + i + ": ");
            int marks = scanner.nextInt();
            totalMarks += marks;
        }
        
        // Calculate the average percentage
        averagePercentage = (double) totalMarks / totalSubjects;
        
        // Assign grades based on average percentage
        String grade;
        if (averagePercentage >= 90) {
            grade = "A+";
        } else if (averagePercentage >= 80) {
            grade = "A";
        } else if (averagePercentage >= 70) {
            grade = "B";
        } else if (averagePercentage >= 60) {
            grade = "C";
        } else if (averagePercentage >= 50) {
            grade = "D";
        } else {
            grade = "F";
        }
        
        // Display results
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + grade);
        
        // Close the scanner
        scanner.close();
    }
}
