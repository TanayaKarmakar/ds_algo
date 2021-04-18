package practice.com.app.searching;

public class SquareRoot {
    private static int sqRoot(int x) {
        int start = 1;
        int end = x;
        int ans = 0;

        while(start <= end) {
            int mid = start + (end - start)/2;
            if(mid * mid == x)
                return mid;
            else if(mid * mid > x)
                end = mid - 1;
            else {
                ans = mid;
                start = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int x = 24;
        int ans = sqRoot(x);

        System.out.println(ans);
    }
}
