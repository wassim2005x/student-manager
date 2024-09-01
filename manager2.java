import java.util.Scanner;

public class manager2 {

    public static int size = 1;
    
    public static void add(String[] name, double[] grade, Scanner scanner){

        scanner.nextLine();         
        System.out.println("enter the new student's name :");
        name[size] = scanner.nextLine();
        System.out.println("enter the grade  of "+name[size]+ " :");
        grade[size] = scanner.nextDouble();
        size++;
        scanner.nextLine();
    }

    public static void fill(String[] name, double[] grade, Scanner scanner) {
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
            if (x != 'y' &&x != 'n') {
                System.out.println("error ,  please enter 'n' for no and 'y' for yes");
                scanner.nextLine();
                x = scanner.nextLine().charAt(0);
            }

            if (x == 'n') {
                break;
            }
            size ++;
            i++;
        }

      
    }

    public static void show(String[] name, double[] grade) {
        
        
        for(int i=0; i < size; i++){
            System.out.println(name[i] + ": " + grade[i]);
        }    
        
    }

    public static void order(String[] name, double[] grade) {
        String temp_name;
        double temp_grade;
        for (int i=0 ; i<size ; i++) {
            for(int j=0 ; j<size-i ; j++){
                if (grade[j]<grade[j+1]) {
                    temp_grade = grade[j];
                    grade[j] = grade[j+1];
                    grade[j+1] = temp_grade;

                    temp_name = name[j];
                    name[j] = name[j+1];
                    name[j+1] = temp_name;
                    
                }
            }
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
        
        boolean find = false;
        for(int i=0 ; i<size ; i++){
            if (name[i].equals(student)) {
                System.out.println(name[i] + " : " + grade[i]);
                find = true;
                break;
            }
            
        }
        if (!find) {
            System.out.println("Error, we didn't find the student. Please enter a valid name.");
        }
    }

    public static void average(String[] name, double[] grade) {
        
        double av = 0;
        int count = 0;
        for (int i=0 ; i<size ; i++){
            av += grade[i];
            
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
            System.out.println("1- fill the list of students .\n 2- Add new student. \n 3- Show all the students. \n4- Show all the students in order. \n5- Search for a student. \n6- Calculate the average grades of students. \n7- Who is the top 1. \n8- Exit.");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    fill(name, grade, scanner);
                    break;
                case 2:
                    add(name, grade, scanner);
                    break;
                case 3:
                    show(name, grade);
                    break;
                case 4:
                    show_order(name, grade);
                    break;
                case 5:
                    search(name, grade, scanner);
                    break;
                case 6:
                    average(name, grade);
                    break;
                case 7:
                    top1(name, grade);
                    break;
                case 8:
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

    

