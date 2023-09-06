import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Course {
    String code;
    String title;
    String description;
    int capacity;
    String schedule;

    public Course(String code, String title, String description, int capacity, String schedule) {
        this.code = code;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
    }
}

class Student {
    String studentID;
    String name;
    List<Course> registeredCourses;

    public Student(String studentID, String name) {
        this.studentID = studentID;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }

    public void registerCourse(Course course) {
        if (course.capacity > 0) {
            registeredCourses.add(course);
            course.capacity--;
            System.out.println(name + " registered for " + course.title);
        } else {
            System.out.println("Sorry, " + course.title + " is already full.");
        }
    }

    public void dropCourse(Course course) {
        if (registeredCourses.contains(course)) {
            registeredCourses.remove(course);
            course.capacity++;
            System.out.println(name + " dropped " + course.title);
        } else {
            System.out.println(name + " is not registered for " + course.title);
        }
    }
}

public class CourseRegistrations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Course> courseDatabase = new HashMap<>();
        List<Student> students = new ArrayList<>();

        while (true) {
            System.out.println("1. Add Course\n2. Register Student\n3. Register Student for Course\n4. Drop Course\n5. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Enter course code:");
                    String courseCode = scanner.nextLine();
                    System.out.println("Enter course title:");
                    String courseTitle = scanner.nextLine();
                    System.out.println("Enter course description:");
                    String courseDescription = scanner.nextLine();
                    System.out.println("Enter course capacity:");
                    int courseCapacity = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.println("Enter course schedule:");
                    String courseSchedule = scanner.nextLine();

                    Course newCourse = new Course(courseCode, courseTitle, courseDescription, courseCapacity, courseSchedule);
                    courseDatabase.put(courseCode, newCourse);
                    break;

                case 2:
                    System.out.println("Enter student ID:");
                    String studentID = scanner.nextLine();
                    System.out.println("Enter student name:");
                    String studentName = scanner.nextLine();
                    Student newStudent = new Student(studentID, studentName);
                    students.add(newStudent);
                    break;

                case 3:
                    System.out.println("Enter student ID:");
                    String regStudentID = scanner.nextLine();
                    System.out.println("Enter course code:");
                    String regCourseCode = scanner.nextLine();

                    Student regStudent = findStudent(students, regStudentID);
                    Course regCourse = courseDatabase.get(regCourseCode);

                    if (regStudent != null && regCourse != null) {
                        regStudent.registerCourse(regCourse);
                    } else {
                        System.out.println("Student or course not found.");
                    }
                    break;

                case 4:
                    System.out.println("Enter student ID:");
                    String dropStudentID = scanner.nextLine();
                    System.out.println("Enter course code:");
                    String dropCourseCode = scanner.nextLine();

                    Student dropStudent = findStudent(students, dropStudentID);
                    Course dropCourse = courseDatabase.get(dropCourseCode);

                    if (dropStudent != null && dropCourse != null) {
                        dropStudent.dropCourse(dropCourse);
                    } else {
                        System.out.println("Student or course not found.");
                    }
                    break;

                case 5:
                    System.out.println("Exiting program.");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    scanner.close();
            }
        }
    }

    private static Student findStudent(List<Student> students, String studentID) {
        for (Student student : students) {
            if (student.studentID.equals(studentID)) {
                return student;
            }
        }
        return null;
    }
}

