package practice.com.app.array;

public class StockBuyAndSellSimple {
    private static int maxProfit(int[] nums) {
        int totalProfit = 0;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] > nums[i - 1]) {
                totalProfit += (nums[i] - nums[i - 1]);
            }
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
