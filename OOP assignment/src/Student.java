import java.util.*;

public class Student 
{
    private String name;
    private String bitsID;
    private String emailID;
    private String phoneNo;
    private String password;
    private boolean logincheck;


    private float totalAmountSpent;
    private int numberOfWashes;
    private WashPlan WashPlan;
    private String hostel;
    private ArrayList<WashOrder> washOrders;
    Student(String name,String bitsID,String emailID,String phoneNo, String password,String hostel)
    {
        this.name=name;
        this.bitsID=bitsID;
        this.emailID=emailID;
        this.phoneNo=phoneNo;
        this.password = password;
        this.totalAmountSpent=0;
        this.numberOfWashes=0;
        this.WashPlan=null;
        this.hostel=hostel;
        this.washOrders = new ArrayList<>();
        this.logincheck=false;
        

    }

    public int getstudnow(){return this.numberOfWashes;}
    public void setWashplan(WashPlan plan)
    {
        this.WashPlan=plan;
    }
    public WashPlan getWashPlan()
    {
        return this.WashPlan;
    }
    public void loginstudent(){logincheck=true;}

    public boolean isLogincheck() {
        return logincheck;
    }

    public void logoutstudent(){logincheck=false;}
    public float gettotalAmountSpent() {return this.totalAmountSpent;}

    public String getName()
    {
        return this.name;
    }
    public String getBitsID()
    {
        return this.bitsID;
    }
    public String getEmailID()
    {
        return this.emailID;
    }
    public String getPhoneNo()
    {
        return this.phoneNo;
    }
    public String getPassword()
    {
        return this.password;
    }
    public String getHostel()
    {
        return this.hostel;
    }
    public void printDetails()
    {int i=0;
        
        System.out.println(" Name : " + name);
        System.out.println(" " +" BitsID : " + bitsID);
        System.out.println(" " +" Hostel : " + hostel);
        System.out.println(" " +" Wash Plan : " + WashPlan);
        System.out.println(" " +" Number Of Washes Given : " + numberOfWashes);
        System.out.println(" " +" Total Money  : " + totalAmountSpent);
        System.out.println("List of orders given");
        for(WashOrder e : washOrders)
       {
        System.out.print("Order number :"+ ++i +" ");
            System.out.println(e.getDateCreated());}
        
    }
    public void addWashOrder(WashOrder obj)
    {
        numberOfWashes++;
        washOrders.add(obj);
    }
    public WashOrder getWashOrderFromDate(Date date)
    {
        boolean flag=false;
        for(WashOrder e : washOrders)
        {
            if(date.compareTo(e.getDateCreated())==0)
            {
                flag=true;
                return e;
            }
            
        }
        if (!flag)
           { 
            System.out.println("No order given by"+ getBitsID()+"customer on "+date);
           
            }
        return null;

    }
    public ArrayList<WashOrder> getWahesList(){
        return washOrders;
    }

    public void addToTotalCost(float cost)
    {
        totalAmountSpent += cost;
    }

}