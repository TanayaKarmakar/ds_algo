package practice.com.app.array;

public class MaximumCircularSubSubarray {
    private static int maxSumSubarray(int[] nums) {
        int currentSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            maxSum = Integer.max(maxSum, currentSum);

            if(currentSum < 0)
                currentSum = 0;
        }

        return maxSum;
    }

    private static int maxSum(int[] nums) {
        int n = nums.length;

        int maxSum = maxSumSubarray(nums);

        int totalSum = 0;
        for(int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
            nums[i] = -nums[i];
        }

        int circularSum = totalSum + maxSumSubarray(nums);
        return Integer.max(maxSum, circularSum);
    }

    public static void main(String[] args) {
        int[] nums = {8,-4,3,-5,4};

        int ans = maxSum(nums);

        System.out.println(ans);
    }
}
