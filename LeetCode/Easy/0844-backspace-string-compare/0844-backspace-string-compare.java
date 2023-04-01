class Solution {
    public boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1; // s 문자열의 마지막 인덱스 초기화
        int j = t.length() - 1; // t 문자열의 마지막 인덱스 초기화
        int skipS = 0; // s 문자열에서 #이 나타난 횟수를 초기화
        int skipT = 0; // t 문자열에서 #이 나타난 횟수를 초기화

        while (i >= 0 || j >= 0) { // 끝에 도달할 때까지 루프.
            while (i >= 0) { // s 문자열에서 # 처리
                if (s.charAt(i) == '#') {
                    skipS++;
                    i--;
                } else if (skipS > 0) {
                    skipS--;
                    i--;
                } else {
                    break;
                }
            }

            while (j >= 0) { // t 문자열에서 #를 처리
                if (t.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else {
                    break;
                }
            }

            if (i >= 0 && j >= 0 && s.charAt(i) != t.charAt(j)) { 
                return false;
            }

            if ((i >= 0) != (j >= 0)) {  
                return false;
            }

            i--;
            j--;
        }

        return true; 
    }
}
