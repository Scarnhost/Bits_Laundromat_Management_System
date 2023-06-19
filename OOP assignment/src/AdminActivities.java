import com.opencsv.*;
import java.io.*;
import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
public class AdminActivities 
{
    static void updateStatus()               //used to update status of order for a given student
    {
        if (AdminLogin.getcheckLogin()) {
            Scanner sc = new Scanner(System.in);
            String[] data = new String[3];
            System.out.print("\nEnter BitsID of student= ");
            data[0] = sc.nextLine();

            try{
                System.out.print("Enter the date of order to update its status = ");
                data[1] = sc.nextLine();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                Date date = sdf.parse(data[1]);
                System.out.print("Enter the new Status of laundry = ");
                data[2] = sc.nextLine();


                //String[] data = sc.nextLine().split(",");

                if (Customer.checkPresent(data[0])) {
                    Student obj = Customer.getStudentFromBitsId(data[0]);   // creates an object of student class which is already stored in
                    // customer class, the customer class stores data of all registered student.

                    WashOrder washOrder = obj.getWashOrderFromDate(date);
                    if (washOrder != null) {
                        if (washOrder.getStatus() <= 4) {
                            washOrder.changeStatus(Integer.parseInt(data[2]));
                            System.out.println("Status updated successfully to " + WashOrder.printStatus(Integer.parseInt(data[2])));//changes the status of the given washorder as entered by admin
                        } else {
                            System.out.println("This Order is already in " + washOrder.printStatus(washOrder.getStatus()) + "Process");
                        }

                    } else
                        System.out.println("Order was not given on this date");
                } else {
                    System.out.println("Wrong ID entered or Student does not exist");
                }

            }
            catch (ParseException e)
            {
                System.out.println("WRONG DATE FORMAT ENTERED, try again");
            }
        }//If bracket
            else
            System.out.print("Admin should login first");

    }

    static void T_method() //checks the status of laundry for particular student
    {
        Scanner sc = new Scanner(System.in);
        String[] data = new String[2];
        System.out.print("\nEnter ID number of Student = ");
        data[0] = sc.nextLine();
        try{ System.out.print("Enter date in dd/mm/yyyy = ");
        data[1] = sc.nextLine();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date date = sdf.parse(data[1]);

        if(Customer.checkPresent(data[0])) {
            Student obj = Customer.getStudentFromBitsId(data[0]);

            boolean flag = false;
            ArrayList<WashOrder> washOrders = obj.getWahesList();
            for (WashOrder e : washOrders) {flag = true;

                if ((e.getDateCreated()).compareTo(date) == 0) {

                    if (e.getStatus() == 4) {

                        System.out.println("The order given on date " + date + " is out for delivery");
                        e.setStatus(5);
                    } else {
                        System.out.print("The order given on date " + date + "is still not out for delivery it's current status is " + WashOrder.printStatus(e.getStatus()));
                    }
                }

            }
            if (flag == false) {
                System.out.println("No order was given on the date" + date + " kindly try again with the right date input");
            }
        }
        else
        {
            System.out.println("Wrong ID entered or student does not exist");
        }}
        catch (ParseException e)
        {
            System.out.println("WRONG DATE FORMAT ENTERED, try again");
        }

    }


static void SA_method()
{
    try {
        Scanner fl = new Scanner(new File("C:\\Users\\Devansh\\IdeaProjects\\OOP assignment\\src\\HostelDelivery.csv"));
        System.out.println("The current timings are : ");
        while (fl.hasNextLine()) {
            String[] details = fl.nextLine().split(",");
            System.out.println("Hostel name = " + details[0] + " ,Delivery day = " + details[1] + " ,Delivery time(24h) = " + details[2]);
        }
        fl.close();
    } catch (IOException e) {
    System.out.println("File not found");
}

    try
    {   File file = new File("C:\\Users\\Devansh\\IdeaProjects\\OOP assignment\\src\\HostelDelivery.csv");
        FileWriter outputfile = new FileWriter(file,true);
        CSVWriter writer = new CSVWriter(outputfile);
//FOR DELETING ALL DATA USE FileWriter outputfile = new FileWriter(file,false);, use true for going in append mode

        int n=1;
        Scanner sc = new Scanner(System.in);
        while(n==1)
        {
            System.out.println("\nEnter Hostel Name, Day and Time of delivery(HH:mm:ss.SSSZ) separated by ,");
    String[] data = sc.nextLine().split(",");
writer.writeNext(data);
            System.out.println("Want to enter more data, type 1 for entering more");
            n=sc.nextInt();
            sc.nextLine();
        }
        writer.close();

    }
    catch(IOException e){
        System.out.println("File Unable to open");
    }
}



    static void AC_method(int n)
    {Scanner sc = new Scanner(System.in);
        if(n==1)
        Customer.showCustomers(0);
       else
        { int c=1;
       while(c!=0){
           System.out.print("\nChoose which hostel details to print :- \n1.Shankar Bhawan \n " + "2.Gandhi Bhawan \n " +
               "3.Krishna Bhawan \n4.Vyas Bhawan " + "\n5.Ram Bhawan" +"\n6.Meera Bhawan"+"\n7.Vishwakarma Bhawan"+"\n8.Bhagirath Bhawan" +
                   "\n9.Budh Bhawan"+"\n10.CV"+"\n11.Exit\nEnter your choice = ");

           try {
               int x = sc.nextInt();
           if(x>=1 && x<=10)
           {Customer.showCustomers(x);}
           else
               if(x==11)
           c=0;
           else {
                   System.out.println("Wrong option chosen try again");
               }
           }

           catch(Exception e)
           {
               System.out.println("Wrong data entered, try again");
               sc.next();
           }

       }}
    }


    static void RA_method()
    {Customer.print_revenue();
    }

    static void admin_pend()
    {Customer.print_pending();
    }

    static void menu_method()
    {Scanner sc = new Scanner(System.in);
        int n=1;
        while(n!=0)
        {
        System.out.print("\nChoose what action to take :- \n1.Print details of all students \n" + "2.Print details student of specific hostel \n" +
            "3.Check status of laundry for a particular student \n4.Update status of Laundry for student " +
            "\n5.Schedule delivery time of Laundries of hostel \n6.See total revenue from all student grouped by Hostels\n7.See all pending Orders\n" +
            "8.Logout\n\nEnter your choice = ");

        try{
            int c;
            c=sc.nextInt();

        switch(c)
        {   case 1:AC_method(1);
                   break;

            case 2:AC_method(2);
                break;

                   case 3:T_method();
                break;

                case 4:updateStatus();
                break;

             case 5 : SA_method();
                break;

            case 6:RA_method();
                break;
            case 7:admin_pend();
                break;
            case 8:AdminLogin.checkLogin = false;
            n=0;
            break;

            default:
                System.out.println("Wrong choice entered");
        }}
            catch(Exception e)
            {
                System.out.println("Wrong value entered, Exception block");
            sc.next();}

    }}


}
