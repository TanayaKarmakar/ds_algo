package practice.com.app.sorting;

public class UnionOfSortedArrays {
    private static void union(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        int i = 0;
        int j = 0;


        int prev = -1;
        while(i < n1 && j < n2) {
            if(i != 0 && nums1[i] == nums1[i - 1]) {
                i++;
                continue;
            }
            if(j != 0 && nums2[j] == nums2[j - 1]) {
                j++;
                continue;
            }
            if(nums1[i] < nums2[j]) {
                System.out.print(nums1[i] + " ");
                i++;
            } else if (nums1[i] > nums2[j]) {
                System.out.print(nums2[j] + " ");
                j++;
            } else {
                System.out.print(nums1[i] + " ");
                i++;
                j++;
            }
        }   

        while(i < n1) {
            if(i > 0 && nums1[i] != nums1[i - 1]) {
                System.out.print(nums1[i] + " ");
                i++;
            }
        }

        while(j < n1) {
            if(j > 0 && nums1[j] != nums1[j - 1]) {
                System.out.print(nums1[j] + " ");
                j++;
            }
        }

        System.out.println();
    }

    public static void main(String[] args) {
        int[] nums1 = {3,5,8};
        int[] nums2 = {2,8,9,10,15};

        union(nums1, nums2);
    }
}
