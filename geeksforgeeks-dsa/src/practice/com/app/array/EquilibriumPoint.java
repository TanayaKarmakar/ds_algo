package practice.com.app.array;

public class EquilibriumPoint {
    private static int equilibriumPoint(int[] nums) {
        int totalSum = 0;
        for(int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
        }

        int left = 0;
        int right = totalSum;

        if(left == right)
            return 0;
        right -= nums[0];

        for(int i = 1; i < nums.length; i++) {
            if(left == right)
                return (i - 1);
            left += nums[i - 1];
            right -= nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {3,4,8,-9,20,6};

        int indx = equilibriumPoint(nums);
        System.out.println(indx);

        nums = new int[] {4, 2, -2};
        indx = equilibriumPoint(nums);
        System.out.println(indx);

    }
}
