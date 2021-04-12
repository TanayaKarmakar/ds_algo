package practice.com.app.array;

public class PrintFirstMNBonacciNumber {
    private static void print(int[] nums, int n, int m) {
        int len = nums.length;
        int left = 0;
        int right = 0;
        int sum = 0;
        for(right = 0; right < n; right++) {
            sum += nums[right];
        }

        int i = 0;

        while(right < len && i < m) {
            System.out.println(sum);
            sum += nums[right];
            sum -= nums[left];
            left++;
            right++;
            i++;
        }

        if(i < m)
            System.out.println(sum);
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,2,4,7,13};
        int n = 3;
        int m = 8;

        print(nums, n, m);
    }
}
