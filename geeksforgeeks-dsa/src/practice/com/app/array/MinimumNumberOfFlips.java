package practice.com.app.array;

public class MinimumNumberOfFlips {
    private static void printGroups(int[] nums) {
        for(int i = 1; i < nums.length; i++) {
            if(nums[i - 1] != nums[i]) {
                if(nums[i] != nums[0]) {
                    System.out.print("From " + i + " to ");
                } else {
                    System.out.print((i - 1));
                    System.out.println();
                }
            }
        }
        if(nums[nums.length - 1] != nums[0]) {
            System.out.print((nums.length - 1));
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,0,0,1,1,0,1};

        printGroups(nums);
    }
}
