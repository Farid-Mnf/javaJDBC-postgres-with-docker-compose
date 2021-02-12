import java.io.File;
import java.sql.*;
import java.util.Scanner;

public class Main {

    private static String name;
    private static String email;

    public static void main(String[] args) {
        try {
            File file = new File("input_data.txt");
            Scanner scan = new Scanner(file);



            while(scan.hasNext()){
                String data[] = scan.nextLine().trim().split(" ");
                name = data[0];
                email = data[1];
                break;  // get only one line
            }

            scan.close();

            if(name == null || email == null) {
                return;
            }

            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager
                    .getConnection("jdbc:postgresql://postgres:5432/postgres",
                            "postgres", "pass");
            Statement stat = c.createStatement();
            stat.execute("insert into student(name,email) values('" + name + "','" + email + "')");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database successfully");
    }

}
