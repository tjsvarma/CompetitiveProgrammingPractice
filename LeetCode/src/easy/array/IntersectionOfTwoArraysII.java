package easy.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given two integer arrays nums1 and nums2, return an array of their intersection.
 * Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.
 *
 * Example 1:
 *
 *  Input: nums1 = [1,2,2,1], nums2 = [2,2]
 *  Output: [2,2]
 *
 * Constraints:
 *
 *     1 <= nums1.length, nums2.length <= 1000
 *     0 <= nums1[i], nums2[i] <= 1000
 *
 * Follow up:
 *
 *     What if the given array is already sorted? How would you optimize your algorithm?
 *     What if nums1's size is small compared to nums2's size? Which algorithm is better?
 *     What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
 */

public class IntersectionOfTwoArraysII {

    /**
     * Brute Force
     * Time Complexity O(n^2)
     */
    public static int[] intersectUsingBruteForce(int[] nums1, int[] nums2) {
        List<Integer> arrayList = new ArrayList();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    arrayList.add(nums1[i]);
                    nums2[j] = -1;
                    break;
                }
            }
        }
        return arrayList.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * Using sorting technique "Arrays.sort"
     * Time Complexity O(n)
     */
    public static int[] intersectUsingSorting(int[] nums1, int[] nums2) {
        int i = nums1.length-1;
        int j = nums2.length-1;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list = new ArrayList<>();
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                i--;
            } else if (nums2[j] > nums1[i]) {
                j--;
            } else {
                list.add(nums1[i]);
                i--;
                j--;
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int nums1[] = {1,2,2,1};
        int nums2[] = {2,2};
        System.out.println(intersectUsingBruteForce(nums1, nums2));
        System.out.println(intersectUsingSorting(nums1, nums2));
    }
}
