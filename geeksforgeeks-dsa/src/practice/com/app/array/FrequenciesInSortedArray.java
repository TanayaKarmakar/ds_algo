package practice.com.app.array;

public class FrequenciesInSortedArray {
    private static void freq(int[] nums) {
        int count = 1;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == nums[i - 1])
                count++;
            else {
                System.out.println(count);
                count = 1;
            }
        }

        //if(!isPrinted)
            System.out.println(count);
    }

    public static void main(String[] args) {
        int[] nums = {10,10,10,25,30,30};

        freq(nums);

        nums = new int[]{10,20,30};

        System.out.println("**********************");

        freq(nums);

        nums = new int[]{10,10,10,10};

        System.out.println("**********************");

        freq(nums);

        nums = new int[]{10,10,10,30,30,40};

        System.out.println("**********************");

        freq(nums);

        nums = new int[]{40,50,50,50};

        System.out.println("**********************");

        freq(nums);
    }
}
