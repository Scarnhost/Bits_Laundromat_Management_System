import java.util.*;
public class Plans 
{
    public static ArrayList<WashPlan>  washplans = new ArrayList<>();
    static void addWashPlan(WashPlan obj)
    {
        washplans.add(obj);
    }
    static void showPlans()
    {
        int count = 1;
        for(WashPlan e : washplans)
        {
            System.out.println("Plan " + count++ + " : " + e );
        }
    }
}
