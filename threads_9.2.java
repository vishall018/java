class WorkerManager
{
    static int workers = 2;
    static int busy = 0;

    synchronized static void acquireWorker(String name)
    {
        try
        {
            while(busy == workers)
            {
                System.out.println(name + " is waiting for a worker...");
                WorkerManager.class.wait();
            }

            busy++;
            System.out.println(name + " got a worker. Active workers = " + busy);
        }
        catch(InterruptedException e)
        {
            System.out.println(e);
        }
    }

    synchronized static void releaseWorker(String name)
    {
        busy--;
        System.out.println(name + " released worker. Active workers = " + busy);

        WorkerManager.class.notifyAll();
    }
}

class BouquetThread extends Thread
{
    String flower;
    int count = 0;

    BouquetThread(String flower)
    {
        this.flower = flower;
    }

    public void run()
    {
        for(int i = 1; i <= 5; i++)
        {
            WorkerManager.acquireWorker(flower);

            try
            {
                System.out.println(flower + " bouquet " + i + " is being prepared...");
                Thread.sleep(500);
                count++;

                System.out.println(flower + " bouquet " + i + " completed");
            }
            catch(InterruptedException e)
            {
                System.out.println(e);
            }

            WorkerManager.releaseWorker(flower);
        }
    }
}

class FlowerShop
{
    public static void main(String[] args)
    {
        BouquetThread t1 = new BouquetThread("Rose");
        BouquetThread t2 = new BouquetThread("Lily");
        BouquetThread t3 = new BouquetThread("Jasmine");
        BouquetThread t4 = new BouquetThread("Mixed Flower");

        t1.setPriority(8);
        t2.setPriority(6);
        t3.setPriority(4);
        t4.setPriority(2);

        System.out.println("Before starting:");
        System.out.println(t1.getName() + " : " + t1.getState());
        System.out.println(t2.getName() + " : " + t2.getState());

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        System.out.println("\nActive Status:");
        System.out.println("Rose: " + t1.isAlive());
        System.out.println("Lily: " + t2.isAlive());
        System.out.println("Jasmine: " + t3.isAlive());
        System.out.println("Mixed Flower: " + t4.isAlive());

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

        System.out.println("\nAll threads completed.");

        System.out.println("Rose bouquets prepared: " + t1.count);
        System.out.println("Lily bouquets prepared: " + t2.count);
        System.out.println("Jasmine bouquets prepared: " + t3.count);
        System.out.println("Mixed Flower bouquets prepared: " + t4.count);
    }
}