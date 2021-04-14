package practice.com.app.searching;

public class FirstOccurenceOfElementInSortedArray {
    private static int firstOcc(int[] nums, int x) {
        int n = nums.length - 1;
        int start = 0;
        int end = n;

        while(start <= end) {
            int mid = start + (end - start)/2;
            if(nums[mid] == x && (mid == 0 || nums[mid - 1] != x))
                return mid;
            else if(nums[mid] >= x)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1,1, 2, 3,3,4,5,5,7,7,7,9};
        int x = 7;
        int ans = firstOcc(nums, x);
        System.out.println(ans);

        x = 1;
        ans = firstOcc(nums, x);
        System.out.println(ans);
    }
}
