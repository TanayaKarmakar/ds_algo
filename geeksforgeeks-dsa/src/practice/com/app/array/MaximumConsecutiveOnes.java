package practice.com.app.array;

public class MaximumConsecutiveOnes {
    private static int maxValue(int[] nums) {
        int maxCount = 0;
        int currentCount = 0;

        int i = 0;
        while(i < nums.length) {
            if(nums[i] == 1) {
                while(i < nums.length && nums[i] != 0) {
                    i++;
                    currentCount++;
                }
            } else {
                currentCount = 0;
                i++;
            }
            maxCount = Integer.max(maxCount, currentCount);
        }

        return maxCount;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,1,0,1,0};

        int maxCount = maxValue(nums);

        System.out.println(maxCount);

        nums = new int[]{1,1,1,1};

        maxCount = maxValue(nums);

        System.out.println(maxCount);

        nums = new int[] {1,0,1,1,1,1,0,1,1};

        maxCount = maxValue(nums);

        System.out.println(maxCount);


    }
}
