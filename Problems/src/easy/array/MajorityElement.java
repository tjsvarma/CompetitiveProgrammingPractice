package easy.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array nums of size n, return the majority element.
 *
 * The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [3,2,3]
 * Output: 3
 *
 * Example 2:
 *
 * Input: nums = [2,2,1,1,1,2,2]
 * Output: 2
 *
 *
 *
 * Constraints:
 *
 *     n == nums.length
 *     1 <= n <= 5 * 104
 *     -109 <= nums[i] <= 109
 *
 *
 * Follow-up: Could you solve the problem in linear time and in O(1) space?
 */
public class MajorityElement {

  /**
   * Time Complexity: O(n) Space Complexity: O(n)
   */
  public int majorityElementUsingHashMap(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (map.containsKey(nums[i])) {
        map.put(nums[i], map.get(nums[i])+1);
      }
      else {
        map.put(nums[i], 1);
      }
    }

    for (int i = 0; i < nums.length; i++) {
      if (map.get(nums[i]) > nums.length/2) {
        return nums[i];
      }
    }
    return 0;
  }

  /**
   * Time Complexity: O(nlogn) Space Complexity: O(1)
   */
  public int majorityElementUsingSortingTechnique(int[] nums) {
    Arrays.sort(nums);
    return nums[nums.length/2];
  }

  /**
   * Time Complexity: O(n) Space Complexity: O(1)
   */
  public int majorityElementMoorevoting(int[] nums) {
    int count=0, ret = 0;
    for (int num: nums) {
      if (count==0)
        ret = num;
      if (num!=ret)
        count--;
      else
        count++;
    }
    return ret;
  }
}
