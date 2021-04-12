package practice.com.app.array;

public class MaximumLengthEvenOddSubarray {
    private static int maxLen(int[] nums) {
        int currentLen = 1;
        int maxLen = 1;
        int prev = nums[0];

        for(int i = 1; i < nums.length; i++) {
            if(prev % 2 == 0) {
                if(nums[i] % 2 != 0)
                    currentLen++;
                else
                    currentLen = 1;
            } else {
                if(nums[i] % 2 == 0)
                    currentLen++;
                else
                    currentLen = 1;
            }
            prev = nums[i];
            maxLen = Integer.max(maxLen, currentLen);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int[] nums = {10,12,14,7,8};

        int ans = maxLen(nums);

        System.out.println(ans);

        nums = new int[] {7, 10, 13, 14};

        ans = maxLen(nums);

        System.out.println(ans);
    }
}
