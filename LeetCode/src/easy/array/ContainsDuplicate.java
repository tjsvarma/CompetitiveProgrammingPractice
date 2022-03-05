package easy.array;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,1]
 * Output: true
 *
 * Constraints:
 *
 *     1 <= nums.length <= 105
 *     -109 <= nums[i] <= 109
 *
 * Time Complexity O(n)
 */

public class ContainsDuplicate {

    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> hashSet = new HashSet<>();
        for (int i : nums) {
            if (!(hashSet.add(i))) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        System.out.println(containsDuplicate(nums));
    }
}
