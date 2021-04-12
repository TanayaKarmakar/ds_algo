package practice.com.app.array;

public class MaximumSmSubarray {
    private static int maxSum(int[] nums) {
        int n = nums.length;
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;

        for(int i = 0; i < n; i++) {
            currentSum += nums[i];

            maxSum = Integer.max(maxSum, currentSum);

            if(currentSum < 0)
                currentSum = 0;
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,-8,7,-1,2,3};

        int ans = maxSum(nums);

        System.out.println(ans);

        nums = new int[]{-6,-1,-8};

        ans = maxSum(nums);

        System.out.println(ans);

        nums = new int[]{-5,1,-2,3,-1,2,-2};

        ans = maxSum(nums);

        System.out.println(ans);
    }
}
