package practice.com.app.sorting;

public class IntersectionOfTwoArrays {
    private static void intersection(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        int i = 0;
        int j = 0;
        int prev = -1;
        while(i < n1 && j < n2) {
            if(nums1[i] == nums2[j] && (prev == -1 || prev != nums1[i])) {
                System.out.print(nums1[i] + " ");
                prev = nums1[i];
                i++;
                j++;
            } else if(nums1[i] < nums2[j])
                i++;
            else
                j++;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] nums1 = {3,5,10,10,10,15,15,20};
        int[] nums2 = {5,10,10,15,30};

        intersection(nums1, nums2);

        nums1 = new int[]{1,1,3,3};
        nums2 = new int[]{1,1,1,1,3};

        intersection(nums1, nums2);
    }
}
