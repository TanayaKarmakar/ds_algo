package practice.com.app.searching;

public class BinarySearchRecursive {
    private static int binSearch(int[] nums, int x, int start, int end) {
        if(start > end)
            return -1;
        int mid = start + (end - start)/2;
        if(nums[mid] == x)
            return mid;
        else if(nums[mid] > x)
            return binSearch(nums, x, start, mid - 1);
        else
            return binSearch(nums, x, mid + 1, end);
    }

    private static int binSearch(int[] nums, int x) {
        int n = nums.length - 1;
        return binSearch(nums, x, 0, n);
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
