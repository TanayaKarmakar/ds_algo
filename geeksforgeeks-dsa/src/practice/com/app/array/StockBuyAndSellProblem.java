package practice.com.app.array;

public class StockBuyAndSellProblem {
    private static int maxProfit(int[] nums) {
        int totalProfit = 0;
        int n = nums.length;

        int start = 0;
        int end = 0;

        for(int i = 0; i < n;) {
            start = i;
            while(start + 1 < n && nums[start] > nums[start + 1]) {
                start++;
            }

            if(start < n)
                end = start + 1;
            while(end + 1 < n && nums[end] < nums[end + 1]) {
                end++;
            }

            if(start < n && end < n)
                totalProfit += nums[end] - nums[start];
            i = end + 1;
        }

        return totalProfit;
    }

    public static void main(String[] args) {
        int[] nums = {1,5,3,8,12};

        int ans = maxProfit(nums);

        System.out.println(ans);

        nums = new int[]{30,20,10};

        ans = maxProfit(nums);

        System.out.println(ans);

    }
}
