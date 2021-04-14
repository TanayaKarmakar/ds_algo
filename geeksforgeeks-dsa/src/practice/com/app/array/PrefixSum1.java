package practice.com.app.array;

public class PrefixSum1 {
    static int[] prefix;

    private static void preprocess(int[] nums) {
        prefix = new int[nums.length];
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            prefix[i] = sum;
        }
    }

    private static int getSum(int left, int right) {
        if(left == 0)
            return prefix[right];
        return prefix[right] - prefix[left - 1];
    }

    public static void main(String[] args) {
        int[] nums = {2,8,3,9,6,5,4};

        preprocess(nums);

        System.out.println(getSum(0, 2));
        System.out.println(getSum(3, 5));
    }
}
