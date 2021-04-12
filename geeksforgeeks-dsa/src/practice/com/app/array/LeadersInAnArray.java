package practice.com.app.array;

public class LeadersInAnArray {
    private static void leaders(int[] nums) {
        int n = nums.length;
        int max = nums[n - 1];
        System.out.print(max + " ");

        for(int i = n - 2; i >= 0; i--) {
            if(nums[i] > max) {
                max = nums[i];
                System.out.print(max + " ");
            }
        }

        System.out.println();
    }

    public static void main(String[] args) {
        int[] nums = {7,10,4,10,6,5,2};

        leaders(nums);
    }
}
