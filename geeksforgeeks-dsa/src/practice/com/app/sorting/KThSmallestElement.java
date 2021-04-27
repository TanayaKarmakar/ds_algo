package practice.com.app.sorting;

public class KThSmallestElement {
    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private static int partition(int[] nums, int l, int r) {
        int i = l - 1;
        int pivot = nums[r];

        for(int j = l; j <= (r - 1); j++) {
            if(nums[j] < pivot) {
                i++;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, r);
        return (i + 1);
    }

    private static int kThSmallest(int[] nums, int k) {
        int l = 0;
        int r = nums.length - 1;

        while(l <= r) {
            int p = partition(nums, l, r);
            if(p == k - 1)
                return nums[p];
            else if(p > k - 1)
                r = p - 1;
            else
                l = p + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {10,4,5,8,11,6,26};
        int k = 5;

        int ans = kThSmallest(nums, k);

        System.out.println(ans);
    }
}
