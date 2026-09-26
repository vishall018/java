import java.util.*;
class Vehicle
{
    int rd;
    float rpd;
    String vn, cn;

    Vehicle(String vn, int rd, float rpd, String cn)
    {
        this.vn = vn;
        this.rd = rd;
        this.rpd = rpd;
        this.cn = cn;
    }

    void display_details()
    {
        System.out.println("=========== VEHICLE RENTAL DETAILS ===========");
        System.out.println("Vehicle Number :" + vn);
        System.out.println("Customer Name :" + cn);
        System.out.println("Rental Days :" + rd);
        System.out.println("Rent Per Day :" + rpd);
    }
}

class VehicleBill extends Vehicle
{
    float insurance, luxury;
    float rentalAmount, totalAmount;

    VehicleBill(String vn, String cn, int rd, float rpd,
                float insurance, float luxury)
    {
        super(vn, rd, rpd, cn);
        this.insurance = insurance;
        this.luxury = luxury;
    }

    void calculate()
    {
        rentalAmount = rd * rpd;
        totalAmount = rentalAmount + insurance + luxury;
    }

    void display()
    {
        calculate();

        display_details();

        System.out.println("Insurance charge:" + insurance);
        System.out.println("Rental amount :" + rentalAmount);
        System.out.println("Luxury Charge :" + luxury);
        System.out.println("Total Rental Amount:" + totalAmount);
    }
}

public class VehicleBill1
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of Car details you need to Enter:");
        int n = sc.nextInt();

        VehicleBill v[] = new VehicleBill[n];

        for(int i = 0; i < n; i++)
        {
            sc.nextLine();

            System.out.print("Enter Customer Name:");
            String cn = sc.nextLine();

            System.out.print("Enter Rental days:");
            int rd = sc.nextInt();

            System.out.print("Enter Rent per day:");
            float rpd = sc.nextFloat();

            System.out.print("Enter Insurance Charge:");
            float insurance = sc.nextFloat();

            System.out.print("Enter Luxury charge:");
            float luxury = sc.nextFloat();

            sc.nextLine();

            System.out.print("Enter Vehicle number:");
            String vn = sc.nextLine();

            v[i] = new VehicleBill(vn, cn, rd, rpd, insurance, luxury);
        }

        float grandTotal = 0;
        int high = 0;

        System.out.println();

        for(int i = 0; i < n; i++)
        {
            v[i].display();

            grandTotal = grandTotal + v[i].totalAmount;

            if(v[i].totalAmount > v[high].totalAmount)
                high = i;

            System.out.println();
        }

        System.out.println("----------------------------------------------");
        System.out.println("Vehicle Starting with TN");

        for(int i = 0; i < n; i++)
        {
            if(v[i].vn.startsWith("TN"))
                System.out.println(v[i].vn);
        }

        System.out.println("Customer name in upper case");

        for(int i = 0; i < n; i++)
        {
            System.out.println(v[i].cn.toUpperCase());
        }

        System.out.println("Grant total:" + grandTotal);
        System.out.println("Highest Rent Vehicle:" + v[high].vn);
        System.out.println("Highest Rent:" + v[high].totalAmount);
    }
}
