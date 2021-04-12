package practice.com.app.array;

public class MaximumDifference {
    private static int maxDiff(int[] nums) {
        int n = nums.length;
        int res = nums[1] - nums[0];
        int minVal = nums[0];

        for(int j = 1; j < n; j++) {
            res = Integer.max(res, nums[j] - minVal);
            minVal = Integer.min(minVal, nums[j]);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,10,6,4,8,1};

        int ans = maxDiff(nums);

        System.out.println(ans);
    }
}
