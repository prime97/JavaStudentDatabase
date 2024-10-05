import java.util.*;
public class Student {
    private int StudentID, StudyYear, MAX;
    private String StudentName, Email;
    private LinkedList<Modules>moduleslist;
    private static int num =1000;
    public Student(int studyYear, String studentName, String email) {
        num++;
        StudentID = num;
        StudyYear = studyYear;
        StudentName = studentName;
        Email = email;
        moduleslist =new LinkedList<>();
        MAX = 5;
    }

    public int getStudentID() {
        return StudentID;
    }

    public int getStudyYear() {
        return StudyYear;
    }

    public String getStudentName() {
        return StudentName;
    }

    public String getEmail() {
        return Email;
    }

    //adds a new module object to the list of modules
    public void addModules(Modules mods) {
        for(Modules mod : moduleslist){
            if(mod.getModuleCode().equals(mods.getModuleCode())){
                System.out.println("module already there!");
                return;
            }
        }
        moduleslist.add(mods);
    }

    //clones the original module list and sorts the cloned list by module mark using collection sort functionality
    public LinkedList<Modules> sortedModules(){
        LinkedList list = (LinkedList) moduleslist.clone();
        Collections.sort(list);
        return list;
    }

    //This method caps the modules entry.
    //if the moduleslist already has 5 modules, it will remove
    public boolean ModuleCap(String ModCode, Modules mods){
        if(moduleslist.size()>=MAX && !moduleslist.contains(ModCode)){
            addModules(mods);
            moduleslist.remove(0);
            return false;
        }else {
            addModules(mods);
            return true;
        }
    }

    //displays the student with unsorted modules list
    public void DisplayStudentUnsorted(){
        System.out.println("Student's ID: "+ getStudentID());
        System.out.println("Student's Name: " + getStudentName());
        System.out.println("Study year: " + getStudyYear());
        System.out.println("Student's email: " + getEmail());
        System.out.println();

        for(Modules mods : moduleslist){
            mods.DisplayModule();
        }
    }

    //displays the student with sorted modules list
    public void DisplayStudentSorted(){
        System.out.println("Student's ID: "+ getStudentID());
        System.out.println("Student's Name: " + getStudentName());
        System.out.println("Study year: " + getStudyYear());
        System.out.println("Student's email: " + getEmail());
        System.out.println();
        LinkedList <Modules> sortedMods = sortedModules();
        for(Modules mods : sortedMods){
            mods.DisplayModule();
        }
    }
}
