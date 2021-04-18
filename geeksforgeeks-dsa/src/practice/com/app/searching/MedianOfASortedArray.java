package practice.com.app.searching;

public class MedianOfASortedArray {
    private static double medianOfSortedArray(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length)
            return medianOfSortedArray(nums2, nums1);

        int n1 = nums1.length;
        int n2 = nums2.length;

        int begin = 0;
        int end = n1 - 1;

        while(begin <= end) {
            int i1 = begin + (end - begin)/2;
            int i2 = (n1 + n2 + 1)/2 - i1;

            int max1 = (i1 == 0) ? Integer.MIN_VALUE: i1 - 1;
            int max2 = (i2 == 0) ? Integer.MIN_VALUE: i2 - 1;
            int min1 = (i1 == n1) ? Integer.MAX_VALUE: i1;
            int min2 = (i2 == n2) ? Integer.MAX_VALUE: i2;

            if(nums1[max1] < nums2[min1] && nums1[max2] < nums2[min2]) {
                if((n1 + n2) % 2 == 0)
                    return (Integer.max(nums1[max1], nums2[max2])
                            + Integer.min(nums1[min1], nums2[min2]))/2.0;
                else if(nums1[max1] > nums2[min2])
                    end = i1 - 1;
                else
                    begin = i1 + 1;
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums1 = {10,20,30,40,50};
        int[] nums2 = {5,15,25,30,35,55,65,75,85};

        double ans = medianOfSortedArray(nums1, nums2);

        System.out.println(ans);
    }
}
