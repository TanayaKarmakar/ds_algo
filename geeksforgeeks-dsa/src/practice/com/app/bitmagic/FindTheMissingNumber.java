package practice.com.app.bitmagic;

public class FindTheMissingNumber {
    private static int findNumber(int n, int []nums) {
        int sum = 0;
        for(int i = 1; i <= n; i++) {
            sum = sum ^ i;
        }

        int res = sum;
        for(int num: nums) {
            res = res ^ num;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,4,3};

        int ans = findNumber(4, nums);
        System.out.println(ans);
    }
}
