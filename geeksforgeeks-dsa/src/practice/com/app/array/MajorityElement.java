package practice.com.app.array;

public class MajorityElement {
    private static int majorityElement(int[] nums) {
        int mIndx = 0;
        int count = 1;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == nums[mIndx]) {
                count++;
            } else {
                count--;
                if(count == 0) {
                    mIndx = i;
                    count = 1;
                }
            }
        }

        count = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == nums[mIndx])
                count++;
        }

        if(count > nums.length / 2)
            return mIndx;
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {8,3,4,8,8};

        int mIndx = majorityElement(nums);

        System.out.println(nums[mIndx]);

        nums = new int[] {3,7,4,7,7,5};

        mIndx = majorityElement(nums);

        System.out.println(mIndx == -1 ? -1:nums[mIndx]);
    }
}
