import java.util.Arrays;

public class WeightedJobSchedulingBinarySearch {
    static class Job implements Comparable<Job> {
        int start, finish, profit;

        public Job(int start, int finish, int profit) {
            this.start = start;
            this.finish = finish;
            this.profit = profit;
        }

        public int compareTo(Job other) {
            return this.finish - other.finish;
        }
    }

    public static int binarySearch(Job[] jobs, int index) {
        int low = 0, high = index - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (jobs[mid].finish <= jobs[index].start) {
                if (jobs[mid + 1].finish <= jobs[index].start) {
                    low = mid + 1;
                } else {
                    return mid;
                }
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    public static int findMaxProfit(Job[] jobs) {
        int n = jobs.length;

        Arrays.sort(jobs);

        int[] dp = new int[n];

        dp[0] = jobs[0].profit;

        for (int i = 1; i < n; i++) {
            int previous = binarySearch(jobs, i);
            int currentProfit = jobs[i].profit;
            if (previous != -1) {
                currentProfit += dp[previous];
            }
            dp[i] = Math.max(dp[i - 1], currentProfit);
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
    	Job[] jobs = {new Job(2, 15, 18), new Job(2, 4, 47), new Job(8, 22, 104)};

        int maxProfit = findMaxProfit(jobs);
        System.out.println("Max profit: " + maxProfit);
    }
}