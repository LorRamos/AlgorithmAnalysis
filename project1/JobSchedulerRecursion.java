import java.util.*;
class JobSchedulerRecursion
{
static class Job
{
	int start, finish, profit;
	Job(int start, int finish, int profit)
	{
		this.start = start;
		this.finish = finish;
		this.profit = profit;
	}
}

static int latestNonConflict(Job arr[], int i)
{
	for (int j = i - 1; j >= 0; j--)
	{
		if (arr[j].finish <= arr[i - 1].start)
			return j;
	}
	return -1;
}

static int findMaxProfitRecursive(Job arr[], int n)
{
	if (n == 1) return arr[n-1].profit;
	int includeProfit = arr[n-1].profit;
	int i = latestNonConflict(arr, n);
	if (i != -1)
		includeProfit += findMaxProfitRecursive(arr, i+1);
	int exclProf = findMaxProfitRecursive(arr, n-1);
	return Math.max(includeProfit, exclProf);
}

static int findMaxProfit(Job arr[], int n)
	{
		Arrays.sort(arr,new Comparator<Job>(){
		public int compare(Job j1,Job j2)
			{
			return j1.finish-j2.finish;
			}
		});
	
		return findMaxProfitRecursive(arr, n);
	}


public static void main(String args[])
	{
		Job arr[] = new Job[3];
			arr[0] = new Job(2, 15, 18);
			arr[1] = new Job(2, 4, 47);
			arr[2] = new Job(8, 22, 104);
			System.out.println("Max profit: " + findMaxProfit(arr, arr.length));
	}
}
