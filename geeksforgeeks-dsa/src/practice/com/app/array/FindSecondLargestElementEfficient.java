package practice.com.app.array;

public class FindSecondLargestElementEfficient {
    private static int findSecondLargest(int[] nums) {
        int largest = 0;
        int res = -1;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > nums[largest]) {
                res = largest;
                largest = i;
            } else if(nums[i] != nums[largest]) {
                if(res == -1 || nums[i] > nums[res]) {
                    res = i;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {10,5,8,20};

        int indx = findSecondLargest(nums);
        System.out.println(nums[indx]);

        nums = new int[]{20,10,20,8,12};
        indx = findSecondLargest(nums);
        System.out.println(nums[indx]);

        nums = new int[]{10,10,10};
        indx = findSecondLargest(nums);
        System.out.println(indx);
    }
}
