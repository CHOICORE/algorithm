class Solution {
    public String simplifyPath(String path) {
        String[] components = path.split("/");
        Deque<String> stack = new LinkedList<>();
        for (String component : components) {
            if (component.equals(".") || component.isEmpty()) {
                continue;
            } else if (component.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(component);
            }
        }
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append("/").append(stack.pollLast());
        }
        return result.length() > 0 ? result.toString() : "/";
    }
}
