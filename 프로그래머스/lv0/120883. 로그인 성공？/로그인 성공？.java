class Solution {
    public String solution(String[] id_pw, String[][] db) {
        boolean isIdMatched = false;
        boolean isPwMatched = false;

        for (String[] userInfo : db) {
            if (userInfo[0].equals(id_pw[0])) {
                isIdMatched = true;
                if (userInfo[1].equals(id_pw[1])) {
                    isPwMatched = true;
                    break; 
                }
            }
        }

        if (!isIdMatched) {
            return "fail";
        }
        else if (!isPwMatched) {
            return "wrong pw";
        }
        else {
            return "login";
        }
    }
}
