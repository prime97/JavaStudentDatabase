public class Modules implements Comparable<Modules> {
    private int ModuleMark;
    private String ModuleCode;

    public Modules(int moduleMark, String moduleCode) {
        ModuleMark = moduleMark;
        ModuleCode = moduleCode;
    }

    public int getModuleMark() {
        return ModuleMark;
    }

    public String getModuleCode() {
        return ModuleCode;
    }

    public void DisplayModule(){
        System.out.println("Module code: " + getModuleCode());
        System.out.println("Module mark: " + getModuleMark());
    }

    @Override
    public int compareTo(Modules mod){
        return getModuleMark() - mod.getModuleMark();
    }

    @Override
    public String toString() {
        String s =("Module code: " + getModuleCode() + "    Module mark: " + getModuleMark() + '\n');
        return s;
    }
}