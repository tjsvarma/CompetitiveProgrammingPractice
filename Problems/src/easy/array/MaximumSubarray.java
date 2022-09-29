package easy.array;

/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 *
 * A subarray is a contiguous part of an array.
 *
 * Example 1:
 *
 *  Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 *  Output: 6
 *  Explanation: [4,-1,2,1] has the largest sum = 6.
 *
 * Constraints:
 *
 *     1 <= nums.length <= 105
 *     -104 <= nums[i] <= 104
 *
 * Time Complexity is O(n)
 *
 * Follow up: If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 */

public class MaximumSubarray {

    public static int maxSubArray(int[] nums) {
        int largestSum = -10000;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            largestSum = (sum > largestSum) ? sum : largestSum;
            sum = (sum < 0) ? 0 : sum;
        }
        return largestSum;
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }
}
