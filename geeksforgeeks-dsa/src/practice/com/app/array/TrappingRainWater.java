package practice.com.app.array;

public class TrappingRainWater {
    private static int trap(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;

        int totalWater = 0;
        int lMax = Integer.MIN_VALUE;
        int rMax = Integer.MIN_VALUE;
        while(left < right) {
            if(nums[left] < nums[right]) {
                if(lMax < nums[left]) {
                    lMax = nums[left];
                } else {
                    totalWater += (lMax - nums[left]);
                }
                left++;
            } else {
                if(rMax < nums[right]) {
                    rMax = nums[right];
                } else {
                    totalWater += (rMax - nums[right]);
                }
                right--;
            }
        }
        return totalWater;
    }

    public static void main(String[] args) {
        int[] nums = {3,0,1,2,5};

        int ans = trap(nums);

        System.out.println(ans);
    }
}
