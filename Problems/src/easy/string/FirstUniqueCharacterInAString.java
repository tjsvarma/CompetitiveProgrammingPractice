package easy.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
 *
 * Example 1:
 *
 * Input: s = "leetcode"
 * Output: 0
 *
 * Constraints:
 *
 *     1 <= s.length <= 105
 *     s consists of only lowercase English letters.
 */

public class FirstUniqueCharacterInAString {

    /**
     * Brute force
     * Time Complexity O(n^2)
     */
    public int firstUniqueChar(String s) {
        for (int i = 0; i < s.length(); i++) {
            char unique = s.charAt(i);
            for (int j = 0; j < s.length(); j++) {
                if (i == j) {
                    if (s.length() == 1){
                        return 0;
                    } else if (j == s.length()-1) {
                        return j;
                    } else {
                        continue;
                    }
                }
                if (s.charAt(j) == unique) {
                    break;
                }
                if (j == s.length()-1) {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * Medium optimized
     */
    public int firstUniqueCharUsingHashSet(String s) {
        int flag;
        Set<Character> set = new HashSet<>();
        for(int i =0;i<s.length();i++)
        {
            flag =0;
            char ch = s.charAt(i);
            if(!set.contains(ch))
            {  //if it was not previously established as duplicate
                for(int j =i+1;j<s.length();j++)
                {
                    if(ch == s.charAt(j))
                    {
                        //if duplicate found exit
                        flag =-1;
                        set.add(ch); //no need to process this element again
                        break;
                    }

                }
            }
            else
            {
                flag = -1; //already known duplicate
            }

            if(flag==0)
            {
                return i;
            }

        }

        return -1;
    }

    /**
     * Extreme optimized
     * Time Complexity O(n)
     */
    public int firstUniqueCharUsingHashMap(String s) {
        if (s == null || s.length() == 0) return -1; //Edge case
        HashMap<Character, Integer> count = new HashMap<>();
        for (char c : s.toCharArray()) count.put(c, count.getOrDefault(c, 0) + 1); //Count the occurance of every chars
        for (int i = 0; i < s.length(); i++) {
            if (count.containsKey(s.charAt(i)) && count.get(s.charAt(i)) == 1) return i;
        }
        return -1;
    }
}
