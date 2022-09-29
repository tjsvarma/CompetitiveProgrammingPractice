package easy.stackOrQueue;

import java.util.Stack;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 *     Open brackets must be closed by the same type of brackets.
 *     Open brackets must be closed in the correct order.
 *
 * Example 1:
 *
 * Input: s = "()"
 * Output: true
 *
 * Constraints:
 *
 *     1 <= s.length <= 104
 *     s consists of parentheses only '()[]{}'.
 *
 * Time Complexity O(n)
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                switch (c) {
                    case ')' :
                        if (!stack.empty() && stack.peek() == '(') {
                            stack.pop();
                        } else {
                            return false;
                        }
                        break;
                    case '}' :
                        if (!stack.empty() && stack.peek() == '{') {
                            stack.pop();
                        } else {
                            return false;
                        }
                        break;
                    case ']' :
                        if (!stack.empty() && stack.peek() == '[') {
                            stack.pop();
                        } else {
                            return false;
                        }
                        break;
                }
            }
        }
        if (stack.empty()) {
            return true;
        }
        return false;
    }
}
