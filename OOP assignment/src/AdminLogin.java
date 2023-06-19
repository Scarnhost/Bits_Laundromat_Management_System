import java.io.*;
import java.util.*;

public class AdminLogin 
{
    static boolean checkLogin = false; 
    static void login() throws FileNotFoundException
    {
        Scanner sc1 = new Scanner(new File("C:\\Users\\Devansh\\IdeaProjects\\OOP assignment\\src\\AdminCredentials.csv"));
        Scanner sc2 = new Scanner(System.in);
        System.out.println("Enter Username and Password separated by \",\" ");
        String details = sc2.nextLine();
        if(sc1.nextLine().equals(details))
        {
            System.out.println("Login Successful");
            checkLogin = true;
        }
        else
        {
            System.out.println("Invalid Username or Password, do you want to try again Yes or No?");
            char c = sc2.next().charAt(0);
            if(c=='Y')
            login();

        }

    }

public static boolean getcheckLogin()
{
    return checkLogin;
}

public static void updateStatus() {
}
    
}
