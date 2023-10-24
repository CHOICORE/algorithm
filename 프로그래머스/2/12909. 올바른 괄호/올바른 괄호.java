import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            // 여는 괄호면 스택에 추가
            if (c == '(') {
                stack.push(c);
                // 닫는 괄호면
            } else {
                // 스택이 비어있으면 올바르지 않은 괄호
                if (stack.isEmpty()) {
                    return false;
                }
                // 짝지어진 여는 괄호 제거
                stack.pop(); 
            }
        }

        // 모든 문자열을 처리한 후 스택이 비어있으면 올바른 괄호, 아니면 올바르지 않은 괄호
        return stack.isEmpty();
    }
}