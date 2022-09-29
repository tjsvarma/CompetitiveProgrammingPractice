package easy.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 *
 * Constraints:
 *
 *     1 <= s.length, t.length <= 5 * 104
 *     s and t consist of lowercase English letters.
 *
 * Time Complexity O(n)
 */

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() == t.length()) {
            Map<Character, Integer> map = new HashMap<>();
            for (char c : s.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);
            for (char c : t.toCharArray()) {
                if (map.containsKey(c) && map.get(c) > 0) {
                    map.put(c, map.get(c)-1);
                } else {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
