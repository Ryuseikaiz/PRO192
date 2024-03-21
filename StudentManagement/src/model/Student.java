package model;

public class Student implements Comparable<Student> {

    String code;
    String name;
    int birthYear;
    String className;
    double averageGrade;

    public Student() {
        code = "";
        name = "";
        birthYear = 0;
        className = "";
        averageGrade = 0.0;
    }

    public Student(String code, String name, int birthYear, String className, double averageGrade) {
        this.code = code.toUpperCase();
        this.name = name.trim().toUpperCase();
        this.birthYear = birthYear;
        this.className = className;
        this.averageGrade = (averageGrade >= 0 && averageGrade <= 10) ? averageGrade : 0.0;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code.toUpperCase();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() > 0) {
            this.name = name.trim().toUpperCase();
        }
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(double averageGrade) {
        this.averageGrade = (averageGrade >= 0 && averageGrade <= 10) ? averageGrade : 0.0;
    }

    @Override
    public String toString() {
        return code + ", " + name + ", " + birthYear + ", " + className + ", " + averageGrade;
    }

    @Override
    public int compareTo(Student t) {
        return Double.compare(t.getAverageGrade(), this.getAverageGrade());
    }
}
