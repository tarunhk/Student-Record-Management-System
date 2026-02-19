import java.util.*;

class Student {
    int id;
    String name;
    double marks;

    Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    void display() {
        System.out.println(id + " | " + name + " | " + marks);
    }
}

public class StudentSystem {
    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n1.Add 2.View 3.Update 4.Delete 5.Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1: addStudent(); break;
                case 2: viewStudents(); break;
                case 3: updateStudent(); break;
                case 4: deleteStudent(); break;
            }
        } while (choice != 5);
    }

    static void addStudent() {
        System.out.print("ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Marks: ");
        double marks = sc.nextDouble();

        students.add(new Student(id, name, marks));
        System.out.println("Student added");
    }

    static void viewStudents() {
        for (Student s : students) {
            s.display();
        }
    }

    static void updateStudent() {
        System.out.print("Enter ID to update: ");
        int id = sc.nextInt();

        for (Student s : students) {
            if (s.id == id) {
                sc.nextLine();
                System.out.print("New name: ");
                s.name = sc.nextLine();
                System.out.print("New marks: ");
                s.marks = sc.nextDouble();
                System.out.println("Updated");
                return;
            }
        }
        System.out.println("Student not found");
    }

    static void deleteStudent() {
        System.out.print("Enter ID to delete: ");
        int id = sc.nextInt();

        students.removeIf(s -> s.id == id);
        System.out.println("Deleted");
    }
}
