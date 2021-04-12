package practice.com.app.array;

public class SubarrayWithGivenSum {
    private static boolean subarrayWithGivenSum(int[] nums, int sum) {
        int left = 0;
        int right = 0;
        int n = nums.length;
        int currentSum = 0;

        while(right < n) {

            currentSum += nums[right];

            while(left <= right && currentSum > sum) {
                currentSum -= nums[left];
                left++;
            }

            if(currentSum == sum)
                return true;
            right++;
        }
        if(currentSum == sum)
            return true;
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,4,20,3,10,5};
        int sum = 33;

        boolean ans = subarrayWithGivenSum(nums, sum);
        System.out.println(ans);

        nums = new int[] {2,4};
        sum = 3;
        ans = subarrayWithGivenSum(nums, sum);
        System.out.println(ans);

    }
}
