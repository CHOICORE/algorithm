class Solution {
    public int[] sortByBits(int[] arr) {
        Integer[] nums = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(nums, (i, j) -> {
            int iBit = Integer.bitCount(i);
            int jBit = Integer.bitCount(j);
            if (iBit == jBit) {
                return i - j;
            }
            return iBit - jBit;
        });
        return Arrays.stream(nums).mapToInt(Integer::intValue).toArray();
    }
}
