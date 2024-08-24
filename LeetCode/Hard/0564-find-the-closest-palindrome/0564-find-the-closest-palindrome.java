class Solution {
    public String nearestPalindromic(String n) {
        if (Long.parseLong(n) == 1) {
            return "0";
        }
        char[] arr = n.toCharArray();
        int mid = arr.length / 2;

        return getClosestPalindrome(arr, mid - (1 - arr.length % 2), mid);
    }

    String getNextPalindromeForPalindromeNumber(String palinString, int beforeMid, int afterMid) {
        int carry = 1;
        char[] num = palinString.toCharArray();

        while (beforeMid >= 0) {
            int number = (num[beforeMid] - '0');
            number += carry;
            num[beforeMid] = (char) (number % 10 + '0');
            num[afterMid] = (char) (number % 10 + '0');
            ;
            carry = number / 10;
            beforeMid--;
            afterMid++;
        }
        if (carry == 1) {
            char[] numNew = new char[num.length + 1];
            Arrays.fill(numNew, '0');
            numNew[numNew.length - 1] = '1';
            numNew[0] = '1';
            return new String(numNew);
        } else {
            return new String(num);
        }
    }

    String getPrevPalindromeForPalindromeNumber(String palinString, int beforeMid, int afterMid) {
        int carry = 1;
        char[] num = palinString.toCharArray();

        while (beforeMid >= 0) {
            int number = (num[beforeMid] - '0');
            number = (number == 0 && carry == 1) ? 10 : number;
            number -= carry;
            num[beforeMid] = (char) (number + '0');
            num[afterMid] = (char) (number + '0');
            ;
            carry = (number == 9 && carry == 1) ? 1 : 0;
            beforeMid--;
            afterMid++;
        }
        if (num[0] == '0') {
            char[] numNew = new char[num.length - 1];
            Arrays.fill(numNew, '9');
            return new String(numNew);
        } else {
            return new String(num);
        }
    }

    String getClosestPalindrome(char[] num, int beforeMid, int afterMid) {
        Long originalNum = Long.parseLong(new String(num));

        while (beforeMid >= 0) {
            if (num[beforeMid] != num[afterMid]) {
                if (num[beforeMid] > num[afterMid]) {
                    num[afterMid] = num[beforeMid];
                } else {
                    num[afterMid] = num[beforeMid];
                }
            }
            beforeMid--;
            afterMid++;
        }
        String palinString = new String(num);
        Long palinNum = Long.parseLong(palinString);

        String prevPalinString;
        String nextPalinString;
        if (palinNum.equals(originalNum)) {
            prevPalinString = getPrevPalindromeForPalindromeNumber(palinString, (num.length / 2) - (1 - num.length % 2), num.length / 2);
            nextPalinString = getNextPalindromeForPalindromeNumber(palinString, (num.length / 2) - (1 - num.length % 2), num.length / 2);
        } else if (palinNum < originalNum) {
            prevPalinString = palinString;
            nextPalinString = getNextPalindromeForPalindromeNumber(palinString, (num.length / 2) - (1 - num.length % 2), num.length / 2);
        } else {
            prevPalinString = getPrevPalindromeForPalindromeNumber(palinString, (num.length / 2) - (1 - num.length % 2), num.length / 2);
            nextPalinString = palinString;
        }
        Long prevPalinNum = Long.parseLong(prevPalinString);
        Long nextPalinNum = Long.parseLong(nextPalinString);

        if ((originalNum - prevPalinNum) <= (nextPalinNum - originalNum)) {
            return prevPalinString;
        } else {
            return nextPalinString;
        }
    }
}