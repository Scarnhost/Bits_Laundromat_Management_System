import java.util.*;
public class WashOrder 
{
    private int status;
    private Date dateCreated;
    private float weight;
    private float charge;
    WashOrder(Date date,float weight)
    {
        status=1;
        this.dateCreated=date;
        this.weight=weight;
    }
    public void changeStatus(int s)
    {
        this.status=s;
    }
    public Date getDateCreated()
    {
        return dateCreated;
    }
    public float getWeight()
    {
        return weight;
    }
    public void setCharge(float charge)
    {
        this.charge=charge;
    }
    public float getCharge()
    {
        return charge;
    }
    public int getStatus()
    {return this.status;}
    public void setStatus(int i)

    {
        this.status=i;
    }
    public String toString()
    {
        return ("Status of order:"+ printStatus(status) +"\nOrder given on :"+dateCreated+"\n the weight of the Order was :"+weight);
    }
    public static String printStatus(int status)
    {
        switch(status)
        {
            case 1: return "Order initiated";
           
            case 2: return "Washing done";

            case 3:return "Ironing done";
   
            case 4:return "Out for Delivery";
   
            case 5:return "Delivered";
  
            default : return "invalid status set";
           
        }
    }
    
}
    

