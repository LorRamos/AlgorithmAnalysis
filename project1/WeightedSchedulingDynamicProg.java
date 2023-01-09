import java.util.Arrays;

public class WeightedSchedulingDynamicProg
{
    static class Job
    {
        int start, finish, profit;

        public Job(int start, int finish, int profit)
        {
            this.start = start;
            this.finish = finish;
            this.profit = profit;
        }
    }

    public static int findMaxProfit(Job[] jobs)
    {
        Arrays.sort(jobs, (a, b) -> a.finish - b.finish);

        int n = jobs.length;
        int[] dp = new int[n];
        dp[0] = jobs[0].profit;

        for (int i = 1; i < n; i++)
        {
            int profit = jobs[i].profit;
            int j = findNonConflict(jobs, i);
            if (j != -1)
            {
                profit += dp[j];
            }

            dp[i] = Math.max(profit, dp[i - 1]);
        }

        return dp[n - 1];
    }

    private static int findNonConflict(Job[] jobs, int i)
    {
        for (int j = i - 1; j >= 0; j--)
        {
            if (jobs[j].finish <= jobs[i].start)
            {
                return j;
            }
        }

        return -1;
    }

    public static void main(String[] args)
    {
        Job[] jobs = {new Job(2, 15, 18), new Job(2, 4, 47), new Job(8, 22, 104)};

        System.out.println("Max profit: " + findMaxProfit(jobs));
    }
}
