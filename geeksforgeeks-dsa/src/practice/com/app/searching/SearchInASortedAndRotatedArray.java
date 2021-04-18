package practice.com.app.searching;

public class SearchInASortedAndRotatedArray {
    private static int search(int[] nums, int x) {
        int start = 0;
        int end = nums.length - 1;

        while(start <= end) {
            int mid = start + (end - start)/2;
            if(nums[mid] == x)
                return mid;
            else if(nums[start] < nums[mid]) {
                if(x > nums[start] && x <= nums[mid])
                    end = mid - 1;
                else
                    start = mid + 1;
            } else {
                if(x > nums[mid] && x <= nums[end])
                    start = mid + 1;
                else
                    end = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {10,20,40,60,5,8};
        int x = 5;
        int ans = search(nums, x);
        System.out.println(ans);
    }
}
