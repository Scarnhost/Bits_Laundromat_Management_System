import java.io.*;
import java.util.*;
public class Config 
{
    static void storeWashPlans()throws FileNotFoundException
    {
        Scanner sc = new Scanner(new File("C:\\Users\\Devansh\\IdeaProjects\\OOP assignment\\src\\WashPlans.csv"));
        while(sc.hasNextLine())
        {
            String[] details= sc.nextLine().split(",");
            WashPlan newplan = new WashPlan(Integer.parseInt(details[0]),Integer.parseInt( details[1]),Integer.parseInt(details[2]));
            Plans.addWashPlan(newplan);
        }
        sc.close();
    }
    static void config()throws FileNotFoundException
    {
    
        storeWashPlans();
    }
    
}
