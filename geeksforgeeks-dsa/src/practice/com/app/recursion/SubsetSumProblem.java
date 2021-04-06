package practice.com.app.recursion;

public class SubsetSumProblem {
    private static int subsetSum(int[] nums, int sum, int indx) {
        if(indx < 0 || sum < 0)
            return 0;
        if(indx == 0) {
            if(sum == 0)
                return 1;
            else
                return 0;
        }
        int option1 = subsetSum(nums, sum, indx - 1);
        int option2 = subsetSum(nums, sum - nums[indx], indx - 1);
        return option1 + option2;
    }

    private static int subsetSum(int[] nums, int sum) {
        return subsetSum(nums, sum, nums.length -1);
    }

    public static void main(String[] args) {
        int[] nums = {10,5,2,3,6};
        int sum = 8;

        System.out.println(subsetSum(nums, sum));
    }
}
