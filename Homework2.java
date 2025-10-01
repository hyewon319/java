import java.util.Scanner;

class Student {
    private long studentId;
    private String name;
    private String major;
    private long phoneNumber;

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}

public class Homework2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Student[] students = new Student[3];

        for (int i = 0; i < students.length; i++) {
            System.out.print("학생의 학번, 이름, 전공, 전화번호를 입력하세요: ");

            long id = scanner.nextLong();
            String name = scanner.next();
            String major = scanner.next();
            long phone = scanner.nextLong();

            students[i] = new Student();
            students[i].setStudentId(id);
            students[i].setName(name);
            students[i].setMajor(major);
            students[i].setPhoneNumber(phone);
        }

        System.out.println("\n입력된 학생들의 정보는 다음과 같습니다.");

        String[] ordinals = {"첫번째", "두번째", "세번째"};

        for (int i = 0; i < students.length; i++) {
            String phoneStr = "0" + Long.toString(students[i].getPhoneNumber());
            String formattedPhone = phoneStr.substring(0, 3) + "-" +
                    phoneStr.substring(3, 7) + "-" +
                    phoneStr.substring(7);

            System.out.println(ordinals[i] + " 학생: " + students[i].getStudentId() + " " + students[i].getName() + " "
                    + students[i].getMajor() + " " + formattedPhone);
        }

        scanner.close();
    }
}