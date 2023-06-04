class Solution {
    public int lengthOfLastWord(String s) {
        int a = 0;
        s = s.trim();
        int b = s.length()-1;
        while(b>=0 && s.charAt(b)!=' '){
            a++;
            b--;
        }
        return a;
    }
}