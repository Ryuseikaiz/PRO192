package control;

import view.Menu;
import model.StudentList;

public class StudentManager {

    private static String[] getEnglish() {
        return new String[]{"Load data from file", "Search student", "Update name and grade", "Remove student", "Check if student belongs to a class", "Sort students", "Print", "Find the best student", "Exit"};
    }

    private static String[] getVietnamese() {
        return new String[]{"Nhập dữ liệu từ file", "Tìm kiếm sinh viên", "Cập nhật tên và điểm", "Xóa sinh viên", "Kiểm tra sinh viên có ở lớp đó không", "Sắp xếp sinh viên", "In ra", "Tìm sinh viên giỏi nhất", "Thoát"};
    }

    public static void main(String[] args) {
        System.out.println("Choose language to start/Chọn ngôn ngữ để bắt đầu:");
        String[] languageOptions = {"English", "Tiếng Việt", "日本語 (COMING SOON)"};
        int languageChoice = Menu.getChoice(languageOptions);

        String[] options;
        StudentList list = new StudentList();

        switch (languageChoice) {
            case 1:
                options = getEnglish();
                break;
            case 2:
                options = getVietnamese();
                break;
            default:
                return;
        }

        int choice = 0;
        do {
            if (languageChoice == 1) {
                System.out.println("== STUDENT MANAGEMENT ==");
            } else {
                System.out.println("== QUẢN LÝ SINH VIÊN ==");
            }
            choice = Menu.getChoice(options);
            switch (choice) {
                case 1:
                    if (languageChoice == 1) {
                        list.addFromFileEN("DE180651.txt");
                    } else {
                        list.addFromFile("DE180651.txt");
                    }
                    break;
                case 2:
                    if (languageChoice == 1) {
                        list.searchStudentEN();
                    } else {
                        list.searchStudent();
                    }
                    break;
                case 3:
                    if (languageChoice == 1) {
                        list.updateEN();
                    } else {
                        list.update();
                    }
                    break;
                case 4:
                    if (languageChoice == 1) {
                        list.removeEN();
                    } else {
                        list.remove();
                    }
                    break;
                case 5:
                    if (languageChoice == 1) {
                        list.belongsEN();
                    } else {
                        list.belongs();
                    }
                    break;
                case 6:
                    if (languageChoice == 1) {
                        list.sortEN();
                    } else {
                        list.sort();
                    }
                    break;
                case 7:
                    if (languageChoice == 1) {
                        list.printEN();
                    } else {
                        list.print();
                    }
                    break;
                case 8:
                    if (languageChoice == 1) {
                        list.printBestEN();
                    } else {
                        list.printBest();
                    }
                    break;
                default:
                    if (languageChoice == 1) {
                        System.out.println("Goodbye, enjoy your day!~");
                    } else {
                        System.out.println("Tạm biệt, ngày mới tốt lành!~");
                    }
                    break;
            }
        } while (choice > 0 && choice < options.length);
    }
}
