import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;

class UserDatabase {
    private HashMap<String, String> db;

    public UserDatabase() {
        this.db = new HashMap<>();
    }

    public void loadData(String fileName) throws FileNotFoundException {
        Scanner fileSc = new Scanner(new FileInputStream(fileName));
        while (fileSc.hasNext()) {
            String id = fileSc.next();
            String pw = fileSc.next();
            this.db.put(id, pw);
        }
        fileSc.close();
    }

    public boolean isIdExist(String id) {
        return this.db.containsKey(id);
    }

    public boolean authenticate(String id, String password) {
        String storedPw = this.db.get(id);
        return storedPw != null && storedPw.equals(password);
    }
}

public class Homework9 {
    public static void main(String[] args) {
        UserDatabase userDb = new UserDatabase();

        try {
            userDb.loadData("db.txt");
        } catch (FileNotFoundException e) {
            System.out.println("db.txt 파일이 없습니다.");
            return;
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("id와 password를 입력해주세요.");

            System.out.print("id : ");
            String inputId = sc.nextLine().trim();

            if (!userDb.isIdExist(inputId)) {
                System.out.println("입력하신 id는 존재하지 않습니다. 다시 입력해주세요.\n");
                continue;
            }

            System.out.print("password : ");
            String inputPw = sc.nextLine().trim();

            if (!userDb.authenticate(inputId, inputPw)) {
                System.out.println("비밀번호가 일치하지 않습니다. 다시 입력해주세요.\n");
                continue;
            }

            System.out.println("id와 비밀번호가 일치합니다.");
            break;
        }

        sc.close();
    }
}