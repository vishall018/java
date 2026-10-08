class FoodOrder
{
    boolean accepted = false;
    boolean prepared = false;
    boolean packed = false;

    double foodCost = 2500;
    boolean express = true;

    synchronized void accept()
    {
        System.out.println("Thread 1: Order Accepted");
        accepted = true;
        notifyAll();
    }

    synchronized void prepare()
    {
        try
        {
            while(!accepted)
                wait();

            System.out.println("Thread 2: Food Prepared");
            prepared = true;
            notifyAll();
        }
        catch(InterruptedException e)
        {
            System.out.println(e);
        }
    }

    synchronized void pack()
    {
        try
        {
            while(!prepared)
                wait();

            System.out.println("Thread 3: Food Packed");
            packed = true;
            notifyAll();
        }
        catch(InterruptedException e)
        {
            System.out.println(e);
        }
    }

    synchronized void deliver()
    {
        try
        {
            while(!packed)
                wait();

            System.out.println("Thread 4: Order Delivered");
            notifyAll();
        }
        catch(InterruptedException e)
        {
            System.out.println(e);
        }
    }

    void bill()
    {
        double discount = 0;

        if(foodCost > 2000)
            discount = foodCost * 0.10;

        double delivery = 50;

        if(express)
            delivery += 100;

        double total = foodCost - discount + delivery;

        System.out.println("\n----- FINAL BILL -----");
        System.out.println("Food Cost       : Rs." + foodCost);
        System.out.println("Discount        : Rs." + discount);
        System.out.println("Delivery Charge : Rs." + delivery);
        System.out.println("Total Amount    : Rs." + total);
    }
}

class AcceptThread extends Thread
{
    FoodOrder order;

    AcceptThread(FoodOrder order)
    {
        this.order = order;
    }

    public void run()
    {
        order.accept();
    }
}

class PrepareThread extends Thread
{
    FoodOrder order;

    PrepareThread(FoodOrder order)
    {
        this.order = order;
    }

    public void run()
    {
        order.prepare();
    }
}

class PackThread extends Thread
{
    FoodOrder order;

    PackThread(FoodOrder order)
    {
        this.order = order;
    }

    public void run()
    {
        order.pack();
    }
}

class DeliverThread extends Thread
{
    FoodOrder order;

    DeliverThread(FoodOrder order)
    {
        this.order = order;
    }

    public void run()
    {
        order.deliver();
    }
}

class Main
{
    public static void main(String[] args)
    {
        FoodOrder order = new FoodOrder();

        AcceptThread t1 = new AcceptThread(order);
        PrepareThread t2 = new PrepareThread(order);
        PackThread t3 = new PackThread(order);
        DeliverThread t4 = new DeliverThread(order);

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        try
        {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        }
        catch(InterruptedException e)
        {
            System.out.println(e);
        }

        order.bill();
    }
}