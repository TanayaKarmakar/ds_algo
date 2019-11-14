package com.app.array.classroom;

public class GFG {
	static int findSplit(int []arr, int n) 
    { 
        int i; 
       
        // variable to store prefix sum 
        int preSum = 0; 
       
        // variables to store indices which  
        // have prefix sum divisible by S/3. 
        int ind1 = -1, ind2 = -1; 
       
        // variable to store sum of 
        // entire array. 
        int S; 
       
        // Find entire sum of the array. 
        S = arr[0]; 
        for (i = 1; i < n; i++)  
            S += arr[i]; 
       
        // Check if array can be split in 
        // three equal sum sets or not. 
        if(S % 3 != 0) 
            return 0; 
           
        // Variables to store sum S/3  
        // and 2*(S/3). 
        int S1 = S / 3; 
        int S2 = 2 * S1; 
       
        for (i = 0; i < n; i++) 
        { 
            preSum += arr[i]; 
               
            // If prefix sum is divisible by S/3 
            // and this is the first index where 
            // sum is divisible then store  
            // current index. 
            if (preSum % S1 == 0 && ind1 == -1) 
                ind1 = i; 
               
            // If prefix sum is divisible by 2*(S/3) 
            // then store current index as second 
            // index. 
            else if(preSum % S2 == 0) 
            { 
                ind2 = i; 
                   
                // Come out of the loop as both the 
                // required indices are found. 
                break; 
            } 
        } 
       
        // If both the indices are found  
        // then print them. 
        if (ind1 != -1 && ind2 != -1) 
        { 
            System.out.print("(" + ind1 + ", "
                             + ind2 + ")"); 
            return 1; 
        } 
       
        // If indices are not found return 0. 
        return 0; 
    } 
     

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 6, 1, 5, 2, 1, 1, 5 };
		System.out.println("Can divide in 3 " + findSplit(arr, arr.length));

		arr = new int[] { 11, 9, 17, 1, 2, 3, 1, 3, 3, 6, 4 };
		System.out.println("Can divide in 3 " + findSplit(arr, arr.length));

		arr = new int[] { 4, 3, 2, 1, 5, 6 };
		System.out.println("Can divide in 3 " + findSplit(arr, arr.length));
	}

}
