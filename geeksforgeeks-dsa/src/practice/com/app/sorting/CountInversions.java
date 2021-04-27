package practice.com.app.sorting;

public class CountInversions {
    private static int merge(int[] nums, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        int[] left = new int[n1];
        int[] right = new int[n2];


        for(int i = 0; i < left.length; i++) {
            left[i] = nums[l + i];
        }

        for(int i = 0; i < right.length; i++) {
            right[i] = nums[m + 1 + i];
        }

        int res = 0;
        int k = l;
        int i = 0;
        int j = 0;

        while(i < n1 && j < n2) {
            if(left[i] <= right[j]) {
                nums[k++] = left[i++];
            } else {
                nums[k++] = right[j++];
                res += (n1 - i);
            }
        }

        return res;
    }

    private static int mergeSort(int[] nums, int l, int r) {
        int res = 0;
        if(l < r) {
            int mid = l + (r - l)/2;
            res += mergeSort(nums, l, mid);
            res += mergeSort(nums, mid + 1, r);
            res += merge(nums, l, mid, r);
        }
        return res;
    }

    private static int countInversions(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    public static void main(String[] args) {
        int[] nums = {};
    }
}
