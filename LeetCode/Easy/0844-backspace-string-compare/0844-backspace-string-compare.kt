class Solution {
    fun backspaceCompare(S: String, T: String): Boolean {
        return build(S) == build(T)
    }

    fun build(S: String): String {
        val ans: Stack<Char> = Stack()
        for (c in S.toCharArray()) {
            if (c != '#') ans.push(c) else if (!ans.empty()) ans.pop()
        }
        return java.lang.String.valueOf(ans)
    }
}