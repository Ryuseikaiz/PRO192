package model;

import view.Inputter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class StudentList extends ArrayList<Student> {

    public StudentList() {
        super();
    }

    public Student search(String code) {
        code = code.trim().toUpperCase();
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getCode().equals(code)) {
                return this.get(i);
            }
        }
        return null;
    }

    public boolean isDuplicated(String code) {
        code = code.trim().toUpperCase();
        return this.search(code) != null;
    }

    public void addFromFile(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    String code = parts[0];
                    String name = parts[1];
                    int birthYear = Integer.parseInt(parts[2]);
                    String className = parts[3];
                    double averageGrade = Double.parseDouble(parts[4]);
                    if (!isDuplicated(code)) {
                        Student student = new Student(code, name, birthYear, className, averageGrade);
                        this.add(student);
                    } else {
                        System.out.println("Sinh viên có MSSV " + code + " đã tồn tại");
                    }
                }
            }
            System.out.println("Đọc danh sách sinh viên từ file DE180651.txt thành công");
        } catch (IOException | NumberFormatException e) {
            System.out.println("Lỗi đọc file " + e.getMessage());
        }
    }

    public void searchStudent() {
        if (this.isEmpty()) {
            System.out.println("Không có sinh viên trong danh sách, hãy thêm trước khi tìm kiếm!");
        } else {
            String sCode = Inputter.inputStr("Nhập MSSV để tìm kiếm: ");
            Student student = this.search(sCode);
            if (student == null) {
                System.out.println("Sinh viên có MSSV " + sCode + " không có trong danh sách!");
            } else {
                System.out.println("Sinh viên cần tìm: " + student);
            }
        }
    }

    public void update() {
        if (this.isEmpty()) {
            System.out.println("Không có sinh viên trong danh sách, hãy thêm trước khi cập nhật!");
        } else {
            String sCode = Inputter.inputStr("Nhập MSSV bạn muốn cập nhật: ");
            Student student = this.search(sCode);
            if (student == null) {
                System.out.println("Sinh viên có MSSV " + sCode + " không có trong danh sách!");
            } else {
                String newName = Inputter.inputNonBlankStr("Tên cũ: " + student.getName() + ", Tên mới: ");
                student.setName(newName);
                double newAverageGrade = Inputter.inputDouble("Điểm cũ: " + student.getAverageGrade() + ", Điểm mới: ", 0.0, 10.0);
                student.setAverageGrade(newAverageGrade);
                System.out.println("Sinh viên có MSSV " + sCode + " đã được cập nhật!");
            }
        }
    }

    public void remove() {
        if (this.isEmpty()) {
            System.out.println("Không có sinh viên trong danh sách, hãy thêm trước khi xóa!");
        } else {
            String sCode = Inputter.inputStr("Nhập MSSV của sinh viên bạn muốn xóa: ");
            Student student = this.search(sCode);
            if (student == null) {
                System.out.println("Sinh viên có MSSV " + sCode + " không tồn tại!");
            } else {
                this.remove(student);
                System.out.println("Sinh viên có MSSV " + sCode + " đã bị xóa khỏi danh sách!");
            }
        }
    }

    public void print() {
        if (this.isEmpty()) {
            System.out.println("Không có sinh viên nào trong danh sách!");
        } else {
            System.out.println("Danh sách sinh viên: ");
            for (Student student : this) {
                System.out.println(student);
            }
            System.out.println("Có tất cả " + this.size() + " sinh viên trong danh sách.");
        }
    }

    public void sort() {
        Collections.sort(this);
        System.out.println("Đã sắp xếp!");
    }

    public boolean doesBelongs(String code, String className) {
        Student student = this.search(code);
        return student != null && student.getClassName().equalsIgnoreCase(className);
    }

    public void belongs() {
        String code = Inputter.inputStr("Nhập MSSV bạn muốn kiểm tra: ");
        String className = Inputter.inputStr("Nhập tên lớp bạn muốn kiểm tra: ");
        if (doesBelongs(code, className)) {
            System.out.println("Sinh viên có MSSV " + code + " có ở trong lớp " + className + ".");
        } else {
            System.out.println("Sinh viên có MSSV " + code + " không ở trong lớp " + className + ".");
        }
    }

    public Student findBest() {
        if (this.isEmpty()) {
            return null;
        } else {
            Student bestStudent = this.get(0);
            for (Student student : this) {
                if (student.getAverageGrade() > bestStudent.getAverageGrade()) {
                    bestStudent = student;
                }
            }
            return bestStudent;
        }
    }

    public void printBest() {
        Student bestStudent = findBest();
        if (bestStudent != null) {
            System.out.println("Sinh viên có số điểm cao nhất: " + bestStudent);
        } else {
            System.out.println("Không có sinh viên nào trong danh sách!");
        }
    }

    public String getDetailsAsString() {
        StringBuilder allStudentsDetails = new StringBuilder();

        for (Student student : this) {
            allStudentsDetails.append(student.toString()).append("\n");
        }

        return allStudentsDetails.toString();
    }

    public void addFromFileEN(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    String code = parts[0];
                    String name = parts[1];
                    int birthYear = Integer.parseInt(parts[2]);
                    String className = parts[3];
                    double averageGrade = Double.parseDouble(parts[4]);
                    if (!isDuplicated(code)) {
                        Student student = new Student(code, name, birthYear, className, averageGrade);
                        this.add(student);
                    } else {
                        System.out.println("Student with Student Code " + code + " has already existed");
                    }
                }
            }
            System.out.println("Reading student list from file DE180651.txt succesfully");
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error reading file " + e.getMessage());
        }
    }

    public void searchStudentEN() {
        if (this.isEmpty()) {
            System.out.println("No students in the list!");
        } else {
            String sCode = Inputter.inputStr("Enter student code: ");
            Student student = this.search(sCode);
            if (student == null) {
                System.out.println("Student with student code " + sCode + " doesn't esixt!");
            } else {
                System.out.println("Student found: " + student);
            }
        }
    }

    public void updateEN() {
        if (this.isEmpty()) {
            System.out.println("No students in the list!");
        } else {
            String sCode = Inputter.inputStr("Enter student code: ");
            Student student = this.search(sCode);
            if (student == null) {
                System.out.println("Student with student code " + sCode + " doesn't esixt!");
            } else {
                String newName = Inputter.inputNonBlankStr("Old name: " + student.getName() + ", New name: ");
                student.setName(newName);
                double newAverageGrade = Inputter.inputDouble("Old grade: " + student.getAverageGrade() + ", New grade: ", 0.0, 10.0);
                student.setAverageGrade(newAverageGrade);
                System.out.println("Student with student code " + sCode + " has been updated!");
            }
        }
    }

    public void removeEN() {
        if (this.isEmpty()) {
            System.out.println("No students in the list!");
        } else {
            String sCode = Inputter.inputStr("Enter student code: ");
            Student student = this.search(sCode);
            if (student == null) {
                System.out.println("Student with student code " + sCode + " doesn't esixt!");
            } else {
                this.remove(student);
                System.out.println("Student with student code " + sCode + " has been removed!");
            }
        }
    }

    public void printEN() {
        if (this.isEmpty()) {
            System.out.println("No students in the list!");
        } else {
            System.out.println("Student List: ");
            for (Student student : this) {
                System.out.println(student);
            }
            System.out.println("There are " + this.size() + " students in the list.");
        }
    }

    public void sortEN() {
        Collections.sort(this);
        System.out.println("Sort by mark is done!!!!");
    }

    public void belongsEN() {
        String code = Inputter.inputStr("Enter student code: ");
        String className = Inputter.inputStr("Enter class name: ");
        if (doesBelongs(code, className)) {
            System.out.println("Student with student code" + code + " belongs to " + className + ".");
        } else {
            System.out.println("Student with student code " + code + " doesn't belong to " + className + ".");
        }
    }

    public void printBestEN() {
        Student bestStudent = findBest();
        if (bestStudent != null) {
            System.out.println("Student with the highest grade: " + bestStudent);
        } else {
            System.out.println("No students in the list!");
        }
    }
}
