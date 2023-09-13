class Solution {
	public int candy(int[] a) {
		int n = a.length;

		int[] candy = new int[n];

		Arrays.fill(candy, 1);

		for (int i = 1; i < n; i++) if (a[i] > a[i - 1]) candy[i] = candy[i - 1] + 1;

		for (int i = n - 1; i > 0; i--) if (a[i - 1] > a[i] && candy[i - 1] <= candy[i]) candy[i - 1] = candy[i] + 1;

		int res = 0;
        
		for (int i : candy) res += i;
        
		return res;
	}
}