import java.io.*;
import java.text.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.TextStyle;
import java.util.*;
public class StudentActivities 
{
    static void D_method(Student obj)throws ParseException,FileNotFoundException
    {
        Scanner sc = new Scanner(System.in);
        String[] s = new String[3];
        System.out.print("\nEnter Weight = ");
        s[0]=sc.nextLine();
        try{System.out.print("Enter date in dd/mm/yyyy format = ");
        s[1]=sc.nextLine();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date date = sdf.parse(s[1]);
        LocalDate dat = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        s[2] = (dat.getDayOfWeek().getDisplayName(TextStyle.FULL,Locale.ENGLISH));

        if(checkDay(obj.getBitsID(),s[2]))
        {
            if(obj.getstudnow()<obj.getWashPlan().getNumberOfWashes())
            {
            if(Float.parseFloat(s[0]) < obj.getWashPlan().getWeight())
            {
                System.out.println("Drop Off Successful without extra charge");
                WashOrder newOrder= new WashOrder(date,Float.parseFloat(s[0]));
                float cost= obj.getWashPlan().getPrice()/obj.getWashPlan().getNumberOfWashes();
                newOrder.setCharge(cost);
                obj.addWashOrder(newOrder);
            }
            else
            {
                Float extraCharge = (Float.parseFloat(s[0]) - obj.getWashPlan().getWeight()) * 100;
                
                System.out.println("Drop Off Successful with extra charge of " + extraCharge + " @100 per extra kg");
                obj.addToTotalCost(extraCharge);
                WashOrder newOrder= new WashOrder(date,Float.parseFloat(s[0]));
                float cost= obj.getWashPlan().getPrice()/obj.getWashPlan().getNumberOfWashes()+extraCharge;
                newOrder.setCharge(cost);
                obj.addWashOrder(newOrder);
            }}

          else
            {
                WashOrder newOrder= new WashOrder(date,Float.parseFloat(s[0]));
                float extraCharge=((Float.parseFloat(s[0]))*100);
                System.out.println("You have now exceeded you plan.Now you will be charged @100 per Kg for per wash, The cost for current wash is = "+extraCharge);
                newOrder.setCharge(extraCharge);
                obj.addToTotalCost(extraCharge);
                obj.addWashOrder(newOrder);}

        }
        else
        {
            System.out.println("You are not allowed to drop your laundry today ");
        }}

        catch (ParseException e)
        {
            System.out.println("WRONG DATE FORMAT ENTERED, try again");
        }


    }

    static boolean checkDay(String bitsID, String Day)throws FileNotFoundException
    {

        Student obj1 = Customer.getStudentFromBitsId(bitsID);

        Scanner sc = new Scanner(new File("C:\\Users\\Devansh\\IdeaProjects\\OOP assignment\\src\\HostelData.csv"));
        boolean flag = false;
        while(sc.hasNextLine())
        {
            String[] data =  sc.nextLine().split(",");
            if(data[0].equals(obj1.getHostel()) && Day.equals(data[1]))
            {
                flag = true;
                break;
            }
        }
        return flag;

    }


    static void C_method(Student obj)
    {
        ArrayList<WashOrder> washOrders =obj.getWahesList();  //wrong spelling? NOPE
        
        int a=washOrders.size(); // a stores the size of Arraylist washorders

        if(a>0)
            System.out.println("The status of the last order by the user given on date ["+washOrders.get(a-1).getDateCreated()+ "] is :" +WashOrder.printStatus(washOrders.get(a-1).getStatus()));
                         //To get the first element of a ArrayList, we can use the list. get() method by passing 0 as an argument. 0 is refers to first element index, now for printing details of last order we will send index as a-1.
        else
        System.out.println("No orders given yet");
    }



    static void B_method(Student obj){
        int i=0;
       float cost= obj.getWashPlan().getPrice()/obj.getWashPlan().getNumberOfWashes();


       ArrayList<WashOrder> washOrders =obj.getWahesList();
       for(WashOrder e:washOrders)
       {
           System.out.print("\nWash number: "+ ++i + "\nDate: " +e.getDateCreated() +"\nWeight given: "+e.getWeight()+"\nStatus of Wash: "+e.printStatus(e.getStatus()));

           if(obj.getWashPlan().getNumberOfWashes()<i)
           {
               System.out.println("\nThe extra charges in wash are(Plan exceeded):" +e.getCharge() + "\n");
           }
           else
           {
               System.out.println("\nTotal cost of the wash :"+e.getCharge()+ "\nThe extra charges in wash are:" +(e.getCharge()-cost) + "\n");}
       }
        
    }





    static void R_method(Student obj) throws ParseException
    {
        Scanner sc = new Scanner(System.in);
        System.out.print(" \nEnter date for which status is required in the format dd/mm/yyyy = ");
        String[] s = sc.nextLine().split(",");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date date = sdf.parse(s[0]);
        ArrayList<WashOrder> washOrders =obj.getWahesList();
        boolean flag=false;
        for(WashOrder e:washOrders)
        {
            if(( e.getDateCreated()).compareTo(date)==0)
            { flag=true;
                if(e.getStatus()==(4))
                {

                 System.out.println("The order given on date "+s[0]+" is out for delivery");
                 e.setStatus(5);
                }

                if(e.getStatus()==(5))
                {
                    System.out.println("The order is already delivered");
                }

                else
                {
                    System.out.print("The order given on date "+s[0]+"is still not out for delivery it's current status is "+WashOrder.printStatus(e.getStatus()));
                }
            }

        }
        if (flag==false)
        {
            System.out.println("No order was given on the date"+s[0]+" kindly try again with the right date input");
        }
    
    }






    static void Pen_method(Student obj)
    { ArrayList<WashOrder> washOrders =obj.getWahesList();
        for(WashOrder e:washOrders)
        {if(e.getStatus()!=5)
        {
            System.out.println(e.toString());}
        }
    }






    //DONE BY GUI
static void menu_method(Student obj)
{Scanner sc = new Scanner(System.in);
    int z=1;
    while(z!=0) {
        System.out.print("\nSelect the activities you want to perform \n1.Submit new laundry\n2.Status of last laundry\n" +
                "3.Show details of all previous laundry dropped\n4.Show Previous pending orders\n5.Receive the laundry delivered on given date  \n6.Logout and Exit\nEnter your choice = ");
        try {
            int n = sc.nextInt();
        switch(n)
        {case 1:D_method(obj);
            break;
            case 2:C_method(obj);
                break;
            case 3:B_method(obj);
                break;
            case 4:Pen_method(obj);
                break;
            case 5:R_method(obj);
                break;
            case 6:z=0;
                break;
            default:
                System.out.println("Wrong option chosen try again");
                break;
        }
        }

        catch (Exception e) {
            System.out.println("wrong data entered try again,Exception block");
            sc.next();}
    }
}
}


