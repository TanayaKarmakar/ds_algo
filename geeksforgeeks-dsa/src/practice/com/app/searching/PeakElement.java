package practice.com.app.searching;

public class PeakElement {
    private static boolean isPeakElement(int[] nums, int mid) {
        if(mid == 0)
            return nums[mid] > nums[mid + 1];
        else if(mid == nums.length - 1)
            return nums[mid] > nums[mid - 1];
        else
            return nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1];
    }

    private static int peakElement(int[] nums) {
        if(nums.length == 1)
            return nums[0];
        int n = nums.length - 1;
        int start = 0;
        int end = n;

        while(start <= end) {
            int mid = start + (end - start)/2;
            if(isPeakElement(nums, mid))
                return mid;
            else if(nums[mid] < nums[mid - 1])
                end = mid - 1;
            else
                start = mid + 1;

        }
        return -1;

    }

    public static void main(String[] args) {
        int[] nums = {5,10,20,15,7};

        int ans = peakElement(nums);

        System.out.println(ans);

        nums = new int[] {10,20,15,5,25,90,70};

        ans = peakElement(nums);

        System.out.println(ans);
    }
}
