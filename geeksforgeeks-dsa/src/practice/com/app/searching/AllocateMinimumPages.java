package practice.com.app.searching;

public class AllocateMinimumPages {
    private static boolean isFeasible(int[] nums, int mid, int k) {
        int req = 1;
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            if(sum + nums[i] > mid) {
                sum = nums[i];
                req++;
            } else {
                sum += nums[i];
            }
        }

        return (req <= k);
    }

    private static int minPages(int[] nums, int k) {
        int sum = 0;
        int max = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Integer.max(max, nums[i]);
        }

        int low = max;
        int high = sum;

        int ans = 0;

        while(low <= high) {
            int mid = low + (high - low)/2;

            if(isFeasible(nums, mid, k)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {10,20,10,30};
        int k = 2;

        System.out.println(minPages(nums, k));
    }
}
