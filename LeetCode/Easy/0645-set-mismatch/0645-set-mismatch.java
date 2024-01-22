class Solution {
	public int[] findErrorNums(int[] nums) {
		int dup = -1, missing = -1;

		for (int i = 1; i <= nums.length; i++) {
			int count = 0;
			for (int num : nums) {
				if (num == i) {
					count++;
				}
			}
			if (count == 2) {
				dup = i;
			} else if (count == 0) {
				missing = i;
			}
		}

		return new int[]{dup, missing};
	}
}
