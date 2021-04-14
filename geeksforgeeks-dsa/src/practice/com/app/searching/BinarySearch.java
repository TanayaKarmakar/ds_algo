package practice.com.app.searching;

public class BinarySearch {
    private static int binSearch(int[] nums, int x, int start, int end) {
        while(start <= end) {
            int mid = start + (end - start)/2;
            if(nums[mid] == x)
                return mid;
            else if(nums[mid] > x)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return -1;
    }

    private static int binSearch(int[] nums, int x) {
        int n = nums.length;
        return binSearch(nums, x, 0, n - 1);
    }

    public static void main(String[] args) {
        int[] nums = {10,20,30,40,50,60};
        int x = 40;
        int ans = binSearch(nums, x);

        System.out.println(ans);

        nums = new int[]{5,15,25};
        x = 20;
        ans = binSearch(nums, x);

        System.out.println(ans);

        nums = new int[]{10,10,10};
        x = 20;
        ans = binSearch(nums, x);

        System.out.println(ans);
    }
}
