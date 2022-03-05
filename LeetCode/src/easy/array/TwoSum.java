package easy.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * You can return the answer in any order.
 *
 * Example 1:
 *
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 *
 * Constraints:
 *
 *     2 <= nums.length <= 104
 *     -109 <= nums[i] <= 109
 *     -109 <= target <= 109
 *     Only one valid answer exists.
 *
 * Follow-up: Can you come up with an algorithm that is less than O(n^2) time complexity?
 */

public class TwoSum {

    /**
     * Brute Force
     * Time Complexity O(n^2)
     */
    public static int[] twoSumBruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length-1; i++) {
            int search = target - nums[i];
            for (int j = i+1; j < nums.length; j++) {
                if (nums[j] == search) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    /**
     * HashTable concept use HashMap
     * Time Complexity O(n)
     */
    public static int[] twoSumUsingHaspMap(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return new int[] {map.get(nums[i]), i};
            }
            map.put(target - nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        System.out.println("Brute Force result: " + twoSumBruteForce(nums, target));
        System.out.println("HashMap logic result: " + twoSumUsingHaspMap(nums, target));
    }
}

