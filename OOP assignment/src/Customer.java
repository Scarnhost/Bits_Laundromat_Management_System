import java.util.*;
public class Customer {
    static HashMap<String, Student> customers = new HashMap<String, Student>();

    static void registerStudent(String BitsID, Student newCustomer) {
        customers.put(BitsID, newCustomer);
    }

    static void showCustomers(int n) {
        int count = 1;
        if (n == 0)
            for (Map.Entry<String, Student> e : customers.entrySet()) {
                System.out.print(count++);
                e.getValue().printDetails();
            }
        else {
            String hostel = new String("hello");
            switch (n) {
                case 1:
                    hostel = "Shankar";
                    break;

                case 2:
                    hostel = "Gandhi";
                    break;

                case 3:
                    hostel = "Krishna";
                    break;

                case 4:
                    hostel = "Vyas";
                    break;

                case 5:
                    hostel = "Ram";
                    break;

                case 6:
                    hostel = "Meera";
                    break;
                case 7:
                    hostel ="Vishwakarma";
                    break;

                case 8:
                    hostel = "Bhagirath";
                    break;

                case 9:
                    hostel = "Budh";
                    break;

                case 10:
                    hostel = "CV";
                    break;
                default:
                    System.out.println("Error in value of n");
                    break;
            }


            for (Map.Entry<String, Student> e : customers.entrySet()) {
                if (hostel.equalsIgnoreCase(e.getValue().getHostel())) {
                    System.out.print(count++);
                    e.getValue().printDetails();
                }
            }


        }
    }


    static boolean checkPresent(String bitsID) {
        if (customers.containsKey(bitsID))
            return true;
        else
            return false;
    }

    static Student getStudentFromBitsId(String bitsID) {
        return customers.get(bitsID);
    }


    static void print_revenue() {
        String hostel = new String("hello");
        float total = 0;

        for (int n = 1; n <= 10; n++) {
            float hot_rev = 0;
            switch (n) {
                case 1:
                    hostel = new String("Shankar");
                    break;

                case 2:
                    hostel = new String("Gandhi");
                    break;

                case 3:
                    hostel = new String("Krishna");
                    break;

                case 4:
                    hostel = new String("Vyas");
                    break;

                case 5:
                    hostel = new String("Ram");
                    break;

                case 6:
                    hostel = new String("Meera");
                    break;
                case 7:
                    hostel = new String("Vishwakarma");
                    break;

                case 8:
                    hostel = new String("Bhagirath");
                    break;

                case 9:
                    hostel = new String("Budh");
                    break;

                case 10:
                    hostel = new String("CV");
                    break;
                default:
                    System.out.println("Error in value of n");
            }

            System.out.println("Revenue from " + hostel + "Bhawan =");
            for (Map.Entry<String, Student> e : customers.entrySet()) {
                if (hostel.equalsIgnoreCase(e.getValue().getHostel())) {
                    hot_rev = e.getValue().gettotalAmountSpent();
                }
            }

            System.out.println(hot_rev);
            total += hot_rev;
        }

        System.out.println("Total overall revenue is" + total);
    }

    static void update_data(String BitsID, Student obj) {
        customers.put(BitsID, obj);
    }


    static void print_pending()
    {int n=1;
        String hostel = new String("hello");
        while(n<=10){switch(n)
            {   case 1:hostel = new String("Shankar");
                break;

                case 2:hostel = new String("Gandhi");
                    break;

                case 3:hostel = new String("Krishna");
                    break;

                case 4:hostel = new String("Vyas");
                    break;

                case 5 :hostel = new String("Ram");
                    break;

                case 6:hostel = new String("Meera");
                    break;
                case 7:hostel = new String("Vishwakarma");
                    break;

                case 8:hostel = new String("Bhagirath");
                    break;

                case 9:hostel = new String("Budh");
                    break;

                case 10:hostel = new String("CV");
                    break;
                default:
                    System.out.println("Error in value of n");
                    break;
            }


            for(Map.Entry<String,Student> e : customers.entrySet())
            {if(hostel.equalsIgnoreCase(e.getValue().getHostel()))
            {
                ArrayList<WashOrder> wash = e.getValue().getWahesList();
                for(WashOrder f:wash)
                {if(f.getStatus()!=5)
                {
                    System.out.println(f.toString());}
                }}
            }
            n++;
        }}

}

