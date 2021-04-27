package practice.com.app.searching;

public class FindRepeatingElement {
    private static int findRepeatingElement(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        do {
           slow = nums[slow];
           fast = nums[nums[fast]];
        } while(slow != fast);

        slow = nums[0];

        while(slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,0,2,3,4};

        int ans = findRepeatingElement(nums);

        System.out.println(nums[ans]);
    }
}
