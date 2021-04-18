package practice.com.app.searching;

public class Count1sInBinaryArray {
    private static int count1s(int[] nums) {
        int n = nums.length;
        int start = 0;
        int end = n - 1;

        int indx = -1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] == 1) {
                if(mid == 0 || nums[mid - 1] != 1) {
                    indx = mid;
                    break;
                } else {
                    end = mid - 1;
                }
            } else {
                start = mid + 1;
            }
        }

        if(indx == -1)
            return 0;
        return n - indx;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,0,1,1,1,1};

        int ans = count1s(nums);
        System.out.println(ans);

        nums = new int[] {1,1,1,1,1,1};
        ans = count1s(nums);
        System.out.println(ans);

        nums = new int[] {0,0,0,0};
        ans = count1s(nums);
        System.out.println(ans);
    }
}
