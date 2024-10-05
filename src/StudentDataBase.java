import java.util.*;
import java.lang.*;

public class StudentDataBase {

    private static CustomLinkedList<Student>students;
    private static Scanner input;

    public StudentDataBase() {
        students = new CustomLinkedList<>();
        input = new Scanner(System.in);
        int ModuleMark;
        String ModuleCode;

        do{
            try {
                System.out.println("Main Menu");
                System.out.println("(1) Add student");
                System.out.println("(2) Add modules");
                System.out.println("(3) Student's details with module details (unsorted modules)");
                System.out.println("(4) Student's details with module details (sorted by marks)");
                System.out.println("(5) Display all students");
                System.out.println("(6) Delete a naughty student");
                System.out.println("(7) Exit");
                int choice;
                try {
                    choice = GetintInput("Choose an option: ");
                } catch (Exception e) {
                    System.out.println(e);
                    choice = GetintInput("Choose an option: ");
                }
                switch (choice) {
                    case 1: //Add student
                        String studentName = GetStringInput("Enter Student Name: ");
                        int studyYear = GetintInput("Enter the year of study: ");
                        String email = studentName;
                        if (!email.contains("@")) {
                            email = email + "@testing.com";
                        }
                        ModuleCode = GetStringInput("Enter the 1st Module code: ");
                        ModuleMark = GetintInput("Enter the Module mark: ");
                        Student studentDet = new Student(studyYear, studentName, email);
                        students.addLast(studentDet);
                        Modules mods = new Modules(ModuleMark, ModuleCode);
                        studentDet.addModules(mods);
                        break;
                    case 2: //Add modules
                        int studentID = GetintInput("Enter Student ID: ");
                        if(isStudentInDataBase(studentID)){
                            ModuleCode = GetStringInput("\nEnter the Module code: ");
                            ModuleMark = GetintInput("Enter the Module mark: ");
                            Student studs = getStudentById(studentID);
                            Modules newmods = new Modules(ModuleMark, ModuleCode);
                            studs.ModuleCap(ModuleCode, newmods);
                        }else{
                            System.out.println("Student ID is wrong!");
                        }
                        break;
                    case 3: //Student's details with module details (unsorted modules)

                        studentID = GetintInput("\nIndividual student's details (search with ID): ");

                        if (isStudentInDataBase(studentID)) {
                            getStudentById(studentID).DisplayStudentUnsorted();
                            System.out.println();
                        } else {
                            System.out.println("Student ID is wrong!");
                        }
                        break;
                    case 4: //Student's details with module details (sorted by marks)

                        studentID = GetintInput("\nIndividual student's details (search with ID): ");
                        if (isStudentInDataBase(studentID)) {
                            getStudentById(studentID).DisplayStudentSorted();
                        } else {
                            System.out.println("Student ID is wrong!");
                        }
                        break;
                    case 5: //Display all students
                        for(int i = 0; i<students.getSize(); i++){
                            System.out.println();
                            Student s = students.get(i);
                            s.DisplayStudentSorted();
                        }
                        break;

                    case 6: //Delete a naughty student
                        studentID = GetintInput("\nDelete a naughty student (Student ID): ");
                        if(!isStudentInDataBase(studentID)){
                            System.out.println("The student doesn't exist!");
                            break;
                        }
                        Student theSt = students.get(getIndexBYStudentID(studentID));
                        students.delete(theSt);
                        break;
                    case 7: //exit
                        System.out.println("\nBYEEEEEEEEEEEEEE");
                        System.exit(0);
                        break;
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }while(true);

    }
    //this method matches the student ID with the index of that student
    //it's used when the user searches for a student to modify the details of the students.
    //modification of the elements needs an index and this program searches index with student ID from the user input.
    static Student getStudentById(int id){
        for(int i = 0; i<students.getSize(); i++){
            Student s = students.get(i);
            if(s.getStudentID()==id){
                return s;
            }
        }
        return null;
    }

    //This method validates whether there's a student in the database with the student ID or not
    //This method gets all the students
    static boolean isStudentInDataBase(int id){
        for(int i = 0; i<students.getSize(); i++){
            Student s = students.get(i);
            if(s.getStudentID()==id){
                return true;
            }
        }
        return false;
    }

    //this is a similar method as "getStudentById" but instead of the "Student" datatype, it uses "int"
    //this method also gets the index of a student, searched by ID
    //the purpose of the creation of this method was to delete a specific student's detail from the database
    static int getIndexBYStudentID(int id){
        for(int i = 0; i<students.getSize(); i++){
            Student s = students.get(i);
            if(s.getStudentID()==id){
                return i;
            }
        }
        return -1;
    }

    //This is a string validation method that takes every input by user as a string so that the program doesn't break.
    static String GetStringInput(String msg){
        System.out.print(msg);
        return input.nextLine();

    }

    //this method validates whether the user is entering anything other than int type data in the input field.
    //if the user uses any other data type, this method will prevent the program to break/crash and warn the user.
    static int GetintInput(String msg){
        Integer rtrn = null;
        while(rtrn == null){
            System.out.print(msg);
            String userin = input.nextLine();
            try {
                rtrn = Integer.parseInt(userin);
            }catch (Exception ignored){
                System.out.println("Please enter integer value.");
            }
        }

        return rtrn;
    }

    //creates a class object to run the program
    public static void main(String[]args) {
        StudentDataBase database = new StudentDataBase();
    }
}