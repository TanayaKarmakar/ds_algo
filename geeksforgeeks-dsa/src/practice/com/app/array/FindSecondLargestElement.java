package practice.com.app.array;

public class FindSecondLargestElement {
    private static int secondLargest(int[] nums) {
        int max = nums[0];
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > max) {
                max = nums[i];
            }
        }

        int sMaxIndx = -1;
        int sMax = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > sMax && nums[i] < max) {
                sMax = nums[i];
                sMaxIndx = i;
            }
        }
        return sMaxIndx;
    }

    public static void main(String[] args) {
        int[] nums = {10,5,8,20};

        int indx = secondLargest(nums);
        System.out.println(nums[indx]);

        nums = new int[]{20,10,20,8,12};
        indx = secondLargest(nums);
        System.out.println(nums[indx]);

        nums = new int[]{10,10,10};
        indx = secondLargest(nums);
        System.out.println(indx);
    }
}
