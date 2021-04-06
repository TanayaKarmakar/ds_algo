package practice.com.app.bitmagic;

public class FindTwoOddAppearingNumber {
    private static void printNum(int[] nums) {
        int xor = 0, res1 = 0, res2 = 0;
        for(int i = 0; i < nums.length; i++) {
            xor = xor ^ nums[i];
        }

        int sn = xor & ~(xor - 1);
        for(int i = 0; i < nums.length; i++) {
            if((nums[i] ^ sn) != 0) {
                res1 = res1 ^ nums[i];
            } else {
                res2 = res2 ^ nums[i];
            }
        }

        System.out.println("Result1 - " + res1 + "| Result2 - " + res2);
    }

    public static void main(String[] args) {
        int[] nums = {3,5,5,9};

        printNum(nums);
    }
}
