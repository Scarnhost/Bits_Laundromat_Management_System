
import java.io.*;
import java.util.*;

public class Driver
{
    public static void main(String[] args)throws FileNotFoundException
    {
        //System.out.println("Present Project Directory : "+ System.getProperty("user.dir"));
        Scanner sc = new Scanner(System.in);
        int n = 1;
        Config.config();            //reads all plans from WashPlans.csv file and stores in washplans arraylist
        // Customer collage = new Customer();
        //collage.redcsv();

        while(n!=0)
        {
            System.out.print("\nPress 'S' for student login" + "\nPress 'L1' for Admin login" + "\nPress any other Key to exit\nEnter your choice = ");
            String s = sc.next();
            //S for student login
            //L1 admin login
            //L2 logout admin

            switch(s)
            {
                case "S":
                    StudentLoginAndRegister.LoginOrRegister();
                    break;


                case "L1" :
                    AdminLogin.login();//first will check weather admin is true or not
                    if(AdminLogin.getcheckLogin())
                    {
                        AdminActivities.menu_method();}
                    else
                        System.out.println("Admin should login first");


                    break;
/*
                case "AC" : 
                    Customer.showCustomers();
                    break;
                /*case "L2":
                    if(AdminLogin.checkLogin)
                    {
                        AdminLogin.checkLogin = false;
                        System.out.println("Logging Out ...");
                    }
                    else
                    {
                        System.out.println("Admin is not Logged in ");
                    }
                    break;*/
                /*case "D":
                    StudentActivities.D_method();
                    Customer.showCustomers();
                    break;
                case "C":
                    StudentActivities.C_method();
                    break;
                case "B" :
                StudentActivities.B_method();
                    break;
                case "R" :
                StudentActivities.R_method();
                    break;
                case "U":
                AdminLogin.updateStatus();
                    break;*/
                /*case "T":
                {

                if(AdminLogin.getcheckLogin())
                {
                AdminActivities.T_method();}
                else
                System.out.println("Admin should login first");
                }
                 break;*/
                default: System.out.println("Exiting the program, Thank you for using our services");
                n=0;
                break;

            }


            /*
            System.out.println("Enter 0  to terminate the program.Else choose 1");
            n = sc.nextInt();
            sc.nextLine();*/
        }
    }   
}