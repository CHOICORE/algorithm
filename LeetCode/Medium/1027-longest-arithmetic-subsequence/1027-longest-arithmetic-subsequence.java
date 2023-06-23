class Solution {
    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        int maxSeqLen = 2;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int diff = nums[j] - nums[i];
                int baseNum = nums[j];
                int seqLen = 2;
                for (int k = j + 1; k < n; k++) {
                    if (nums[k] - baseNum == diff) {
                        baseNum = nums[k];
                        seqLen++;
                    }
                }
                maxSeqLen = Math.max(maxSeqLen, seqLen);
            }
        }

        return maxSeqLen;
    }
}