package practice.com.app.searching;

public class CountOccurrencesInSorted {
    private static int firstOcc(int[] nums, int x) {
        int n = nums.length - 1;
        int start = 0;
        int end = n;

        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] == x && (mid == 0 || nums[mid - 1] != x))
                return mid;
            else if(nums[mid] >= x)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return -1;
    }

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

    private static int countOccurrences(int[] nums, int x) {
        if(nums.length == 0)
            return 0;
        int lIndx = firstOcc(nums, x);
        if(lIndx == -1)
            return 0;
        int rIndx = lastOcc(nums, x);
        return (rIndx - lIndx) + 1;
    }

    public static void main(String[] args) {
        int[] nums = {10,20,20,20,30,30};
        int x = 20;

        int ans = countOccurrences(nums, x);
        System.out.println(ans);
    }
}
