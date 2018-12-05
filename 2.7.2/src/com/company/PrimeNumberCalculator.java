package com.company;

public class PrimeNumberCalculator {
    private volatile int count = 0;

    public int getPrimeCountMultithread(int start, int end) throws InterruptedException {
        int mid = (int)((end-start)*0.5 + start);

        PrimeNumberCalculator p1 = new PrimeNumberCalculator();
        PrimeNumberCalculator p2 = new PrimeNumberCalculator();

        Thread part1 = new Thread(() -> p1.getPrimeCount(start, mid));
        Thread part2 = new Thread(() -> p2.getPrimeCount(mid+1, end));
        part1.start();
        part2.start();
        part1.join();
        part2.join();
        return p1.count + p2.count;
    }

    public int getPrimeCount(int start, int end)
    {
        for(int i=start; i <= end; ++i)
        {
            if(isPrime(i))
            {
                ++count;
            }
        }
        return count;
    }

    private boolean isPrime(int m)
    {
        if(m == 1)
            return false;

        if(m == 2 || m == 3)
            return true;

        if(m > 3)
        {
            if(m%2 == 0)
                return false;

            for(int i = 3; i<=Math.sqrt(m); ++i)
            {
                if(m%i == 0)
                {
                    return false;
                }
            }
        }
        return true;
    }
}