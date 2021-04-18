package practice.com.app.searching;

public class TripletSum {
    private static boolean hasSum(int[] nums, int sum) {
        int n = nums.length;
        for(int i = 0; i < n - 1; i++) {
            if(hasTwoSum(nums, i + 1, sum - nums[i]))
                return true;
        }
        return false;
    }

    private static boolean hasTwoSum(int[] nums, int start, int sum) {
        int end = nums.length - 1;
        while(start < end) {
            int currentSum = nums[start] + nums[end];
            if(currentSum == sum)
                return true;
            else if(currentSum > sum)
                end--;
            else
                start++;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,4,8,9,20,40};
        int sum = 32;

        boolean ans = hasSum(nums, sum);

        System.out.println(ans);

    }
}
