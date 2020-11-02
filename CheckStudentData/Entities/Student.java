package Entities;

public class Student implements Comparable<Student> {

    private String name;
    private String className;
    private double math;
    private double physical;
    private double chemistry;
    private double avg;
    private String type;

    public Student() {
    }

    public Student(String name, String className, double math, double physical, double chemistry, double avg) {
        this.name = name;
        this.className = className;
        this.math = math;
        this.physical = physical;
        this.chemistry = chemistry;
        this.avg = avg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public double getMath() {
        return math;
    }

    public void setMath(double math) {
        this.math = math;
    }

    public double getPhysical() {
        return physical;
    }

    public void setPhysical(double physical) {
        this.physical = physical;
    }

    public double getChemistry() {
        return chemistry;
    }

    public void setChemistry(double chemisty) {
        this.chemistry = chemisty;
    }

    public double getAvg() {
        return avg;
    }

    public void setAvg(double avg) {
        this.avg = avg;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    public String getType(double avg) {
        String type;
        if (avg > 7.5) {
            type = "A";
        } else if (6 <= avg && avg <= 7.5) {
            type = "B";
        } else if (4 <= avg && avg < 6) {
            type = "C";
        } else {
            type = "D";
        }
        return type;
    }

    @Override
    public int compareTo(Student t) {
        return this.name.compareToIgnoreCase(t.name);
    }

}
