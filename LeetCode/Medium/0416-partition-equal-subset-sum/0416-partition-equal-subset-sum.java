class Solution {
    public static boolean canPartition(int[] nums){
        if (nums == null || nums.length == 0){
            return true;
        }

        int sum = 0;
        for (int num : nums){
            sum += num;
        }
        if ((sum & 1) == 1){
            return false;
        }
        sum >>>= 1;
        java.math.BigInteger map = new java.math.BigInteger("1");
        map = map.shiftLeft(sum);
        for (int num : nums){
            map = map.or(map.shiftRight(num));
        }
        return map.testBit(0);
    }
}