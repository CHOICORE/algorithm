class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        boolean[] arr = new boolean[26];
        for (char c : allowed.toCharArray()) {
            arr[c - 97] = true;
        }

        int count = 0;
        for (String word : words) {
            boolean flag = true;
            for (char c : word.toCharArray()) {
                if (!arr[c - 97]) {
                    flag = false;
                    break;
                }
            }
            if (flag) count++;
        }
        return count;
    }
}
