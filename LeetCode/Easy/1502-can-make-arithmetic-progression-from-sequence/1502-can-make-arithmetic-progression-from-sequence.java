class Solution {
	public boolean canMakeArithmeticProgression(int[] nums) {
		Arrays.sort(nums);
		for (int i = 2; i < nums.length; i++) {
			if (nums[i] - nums[i - 1] != nums[i - 1] - nums[i - 2]) {
				return false;
			}
		}
		return true;
	}
}