package practice.com.app.array;

public class CheckIfTheArrayIsSorted {
    private static boolean checkIfSorted(int[] nums) {
        int n = nums.length;
        for(int i = 1; i < n; i++) {
            if(nums[i] < nums[i - 1])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {100, 20, 100};
        System.out.println(checkIfSorted(nums));

        nums = new int[]{5, 10, 15, 20};
        System.out.println(checkIfSorted(nums));
    }
}
