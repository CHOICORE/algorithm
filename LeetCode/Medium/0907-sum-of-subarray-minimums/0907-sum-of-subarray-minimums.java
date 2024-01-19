class Solution {
	int mod = (int) 1e9 + 7;

	public int sumSubarrayMins(int[] arr) {
		int n = arr.length + 1;
		int[] left = new int[n];
		int[] ext = new int[n];
		int[] sums = new int[n];
		System.arraycopy(arr, 0, ext, 1, n - 1);
		int answer = 0;
		for (int i = 1; i < n; i++) {
			int cur = ext[i];
			int l = i - 1;
			while (ext[l] >= cur)
				l = left[l];

			left[i] = l;
			sums[i] = sums[l] + cur * (i - l);
			answer = (answer + sums[i]) % mod;
		}
		return answer;
	}
}