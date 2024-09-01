import java.util.Scanner;

public class manager1 {

    public static void add(String[] name, double[] grade, Scanner scanner) {
        char x = 'y';
        int i = 0;

        scanner.nextLine();

        while (x == 'y' && i < name.length - 1) {
            System.out.println("Enter the student's name:");
            name[i] = scanner.nextLine();

            System.out.println("Enter the student's grade:");
            grade[i] = scanner.nextDouble();
            scanner.nextLine(); 

            System.out.println("Do you want to add another student? (y/n)");
            x = scanner.nextLine().charAt(0);
            if (x != 'y' ||x != 'n') {
                System.out.println("error ,  please enter 'n' for no and 'y' for yes");
                scanner.nextLine();
                x = scanner.nextLine().charAt(0);
            }

            if (x == 'n') {
                break;
            }

            i++;
        }

        name[i+1] = "EnD";
    }

    public static void show(String[] name, double[] grade) {
        int i = 0;
        while (!name[i].equals("EnD")) {
            System.out.println(name[i] + ": " + grade[i]);
            i++;
        }
    }

    public static void order(String[] name, double[] grade) {
        int j = 0;
        int g;
        String temp_name;
        double temp_grade;

        while (!name[j].equals("EnD")) {
            g = j + 1;
            while (!name[g].equals("EnD")) {
                if (grade[g - 1] < grade[g]) {
                    temp_grade = grade[g - 1];
                    grade[g - 1] = grade[g];
                    grade[g] = temp_grade;

                    temp_name = name[g - 1];
                    name[g - 1] = name[g];
                    name[g] = temp_name;
                }
                g++;
            }
            j++;
        }
    }

    public static void show_order(String[] name, double[] grade) {
        order(name, grade);
        show(name, grade);
    }

    public static void search(String[] name, double[] grade, Scanner scanner) {
        scanner.nextLine();
        System.out.println("Enter the full name of the student:");
        String student = scanner.nextLine();
        int i = 0;
        boolean find = false;
        while (!name[i].equals("EnD")) {
            if (name[i].equals(student)) {
                System.out.println(name[i] + " : " + grade[i]);
                find = true;
                break;
            }
            i++;
        }
        if (!find) {
            System.out.println("Error, we didn't find the student. Please enter a valid name.");
        }
    }

    public static void average(String[] name, double[] grade) {
        int i = 0;
        double av = 0; 
        int count = 0;
        while (!name[i].equals("EnD")) {
            av += grade[i];
            i++;
            count++;
        }
        if (count > 0) {
            av = av / count;
            System.out.println("The average of the students' grades is: " + av);
        } else {
            System.out.println("No students available to calculate the average.");
        }
    }

    public static void top1(String[] name, double[] grade) {
        order(name, grade);
        if (!name[0].equals("EnD")) {
            System.out.println("The top 1 is: " + name[0] + " with grade: " + grade[0]);
        } else {
            System.out.println("No students available.");
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the student management system");
        Scanner scanner = new Scanner(System.in);
        String[] name = new String[100];
        double[] grade = new double[100];

        boolean loop = true;

        while (loop) {
            System.out.println("Please, select an option:");
            System.out.println("1- Add new student. \n2- Show all the students. \n3- Show all the students in order. \n4- Search for a student. \n5- Calculate the average grades of students. \n6- Who is the top 1. \n7- Exit.");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    add(name, grade, scanner);
                    break;
                case 2:
                    show(name, grade);
                    break;
                case 3:
                    show_order(name, grade);
                    break;
                case 4:
                    search(name, grade, scanner);
                    break;
                case 5:
                    average(name, grade);
                    break;
                case 6:
                    top1(name, grade);
                    break;
                case 7:
                    loop = false;
                    break;
                default:
                    System.out.println("Error, please enter a correct option.");
                    break;
            }
        }
        scanner.close();
    }
}
