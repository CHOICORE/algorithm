class Solution {
    private long convert(long num) {
        String s = Long.toString(num);
        int n = s.length();
        int l = (n - 1) / 2, r = n / 2;
        char[] sArray = s.toCharArray();
        while (l >= 0) {
            sArray[r++] = sArray[l--];
        }
        return Long.parseLong(new String(sArray));
    }

    private long nextPalindrome(long num) {
        long left = 0, right = num;
        long ans = Long.MIN_VALUE;
        while (left <= right) {
            long mid = (right - left) / 2 + left;
            long palin = convert(mid);
            if (palin < num) {
                ans = palin;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    private long previousPalindrome(long num) {
        long left = num, right = (long) 1e18;
        long ans = Long.MIN_VALUE;
        while (left <= right) {
            long mid = (right - left) / 2 + left;
            long palin = convert(mid);
            if (palin > num) {
                ans = palin;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    public String nearestPalindromic(String n) {
        long num = Long.parseLong(n);
        long a = nextPalindrome(num);
        long b = previousPalindrome(num);
        if (Math.abs(a - num) <= Math.abs(b - num)) {
            return Long.toString(a);
        }
        return Long.toString(b);
    }
}