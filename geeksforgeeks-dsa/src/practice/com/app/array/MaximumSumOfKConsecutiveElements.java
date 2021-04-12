package practice.com.app.array;

public class MaximumSumOfKConsecutiveElements {
    private static int maxSum(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int currentSum = 0;
        int maxSum = 0;

        for(right = 0; right < k; right++) {
            currentSum += nums[right];
        }

        maxSum = currentSum;
        while(right < nums.length) {
            currentSum += nums[right];
            currentSum -= nums[left];
            maxSum = Integer.max(maxSum, currentSum);
            left++;
            right++;
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {1,8,30,-5,20,7};
        int k = 3;

        int maxSum = maxSum(nums, k);
        System.out.println(maxSum);
    }
}
