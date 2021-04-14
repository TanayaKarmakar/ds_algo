package practice.com.app.searching;

public class LastOccurenceOfElementsInSortedArray {
    private static int lastOcc(int[] nums, int x) {
        int n = nums.length - 1;
        int start = 0;
        int end = n;

        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] == x && (mid == n - 1 || nums[mid + 1] != x))
                return mid;
            else if(nums[mid] <= x)
                start = mid + 1;
            else
                end = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {5,10,10,10,10,20,20};

        int x = 10;
        int ans = lastOcc(nums, x);

        System.out.println(ans);
    }
}
