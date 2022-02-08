package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings ransomNote and magazine, return true if ransomNote can be constructed from magazine and false otherwise.
 *
 * Each letter in magazine can only be used once in ransomNote.
 *
 * Example 1:
 *
 * Input: ransomNote = "a", magazine = "b"
 * Output: false
 *
 * Constraints:
 *
 *     1 <= ransomNote.length, magazine.length <= 105
 *     ransomNote and magazine consist of lowercase English letters.
 *
 * Time Complexity O(n)
 */

public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : magazine.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);
        for (char c : ransomNote.toCharArray()) {
            if (map.containsKey(c) && map.get(c) > 0) {
                map.put(c, map.get(c)-1);
            } else {
                return false;
            }
        }
        return true;
    }
}

/**
 * Alternate Approach
 */
class RansomNoteAlternateApproach {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] occurences = new int[26];

        for(char rChar : ransomNote.toCharArray()){
            int preIndex = occurences[rChar - 'a'];
            int index = magazine.indexOf(rChar, preIndex);

            if(index == -1)
                return false;

            occurences[rChar - 'a'] = index + 1;
        }

        return true;
    }
}
