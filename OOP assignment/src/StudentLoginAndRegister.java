import java.io.*;
import java.util.*;
public class StudentLoginAndRegister 
{
    static void register() throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        String[] credentials = new String[8];
        System.out.println("\n\nRegistration menu");
        //System.out.println("Enter Name, BitsID, emailID, Phone No., password,Hostel");
        System.out.print("\nEnter Name = ");
        credentials[0]= sc.nextLine();
        System.out.print("Enter BitsID = ");
        credentials[1]= sc.nextLine();
        System.out.print("Enter EmailID = ");
        credentials[2]= sc.nextLine();
        System.out.print("Enter Phone No. = ");
        credentials[3]= sc.nextLine();
        System.out.print("Enter Password = ");
        credentials[4]= sc.nextLine();
        boolean hname = false;





        while(!hname)
        {
            System.out.println("\nType your hostel name exactly  from the following = ");
        Scanner sc1 = new Scanner(new File("C:\\Users\\Devansh\\IdeaProjects\\OOP assignment\\src\\HostelName.csv"));
        while (sc1.hasNextLine()) {
            String details = sc1.nextLine();
            System.out.print(details + ", " );
        }
         sc1.close();

        sc1 = new Scanner(new File("C:\\Users\\Devansh\\IdeaProjects\\OOP assignment\\src\\HostelName.csv"));


        System.out.print("\nEnter Hostel Name = ");
        credentials[5]= sc.nextLine();


        while (sc1.hasNextLine()){
            if(credentials[5].equalsIgnoreCase(sc1.nextLine())) {
            hname = true;
            break;
        }}
        if(!hname)
            System.out.println("Wrong Hostel name entered try again");

        }





        if(Customer.checkPresent(credentials[1]))
        {
            System.out.println("You are already registered user, Please login your details via login page");
            login();
        }
        else {
            Student newCustomer = new Student(credentials[0], credentials[1], credentials[2], credentials[3], credentials[4], credentials[5]);
            Customer.registerStudent(credentials[1], newCustomer);
            System.out.println("\nRegistration Successful");
            System.out.println("Choose from the following wash plans");
            Plans.showPlans();
            System.out.print("Type your plan number = ");
            int x = sc.nextInt();
            WashPlan obj = Plans.washplans.get(x - 1);
            newCustomer.addToTotalCost(Plans.washplans.get(x - 1).getPrice());
            newCustomer.setWashplan(obj);
            System.out.println("New Account created, please login again to continue");

        }


    }


    static void login() throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        String[] credentials = new String[2];
        System.out.print("\nLogin Menu\nEnter BitsID = ");
        credentials[0] = sc.nextLine();
        System.out.print("Enter Password = ");
        credentials[1] = sc.nextLine();

        if(Customer.checkPresent(credentials[0]))
        {
            if(Customer.customers.get(credentials[0]).getPassword().equals(credentials[1]))
            {
                System.out.println("Login Successful");

                Student logintemp = Customer.getStudentFromBitsId(credentials[0]);
                Customer.customers.get(credentials[0]).loginstudent();

                StudentActivities.menu_method(logintemp);
                Customer.update_data(credentials[0],logintemp);

                Customer.customers.get(credentials[0]).logoutstudent();


            }
            else
            {
                System.out.println("Invalid Password");
            }
        }
        else
        {
            System.out.println("You are not registered Or wrong credentials do you want to register, type Y/y to continue?");
            char c = sc.next().charAt(0);
             if(c=='Y'||c=='y')
                 register();
        }
    }


    static void LoginOrRegister()
    {int z=1;


        Scanner sc = new Scanner(System.in);
        while(z!=0)
        { System.out.print("\nChoose 1: Register");
            System.out.print("\nChoose 2: Log In\nPress any other key to exit \nEnter your choice = ");
        try
        {int n = sc.nextInt();
        switch(n)
        {
            case 1:
                register();
                break;
            case 2:
                login();
                break;
            default: z=0;
            break;
        }}

        catch(Exception e)
        {
            System.out.println("Exiting exception block");
            sc.nextLine();
            z=0;
        }
        }

    }
    
}
