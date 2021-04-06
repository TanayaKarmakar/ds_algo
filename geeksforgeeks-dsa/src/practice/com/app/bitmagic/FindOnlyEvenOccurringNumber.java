package practice.com.app.bitmagic;

public class FindOnlyEvenOccurringNumber {
    private static int findNum(int[] nums) {
        int res = 0;
        for(int num: nums) {
            res = res ^ num;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {3,6,2,5,6,7,7,8,8,9,10,9,10,2,5};

        int res = findNum(nums);

        System.out.println(res);
    }
}
