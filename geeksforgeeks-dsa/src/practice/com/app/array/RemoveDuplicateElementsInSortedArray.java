package practice.com.app.array;

public class RemoveDuplicateElementsInSortedArray {
    private static int getArray(int[] nums) {
        int res = 1;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[res - 1]) {
                nums[res] = nums[i];
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {10, 10, 10};

        int len = getArray(nums);

        for(int i = 0; i < len; i++)
            System.out.print(nums[i] + " ");

        System.out.println();

        nums = new int[]{10,20,20,30,30,30,30};

        len = getArray(nums);

        for(int i = 0; i < len; i++)
            System.out.print(nums[i] + " ");

        System.out.println();
    }
}
