class Solution {
	public int furthestBuilding(int[] heights, int bricks, int ladders) {

		int len = heights.length;
		int maxBricksNeeded = 0;
		for (int i = 1; i < len; i++)
			if (heights[i] > heights[i - 1])
				maxBricksNeeded += heights[i] - heights[i - 1];
		if (bricks >= maxBricksNeeded) return len - 1;

		PriorityQueue<Integer> bricksUsed = new PriorityQueue<>((i1, i2) -> i2 - i1);
		int max = 0;
		for (int i = max; i < len; i++) {
			max = i;
			if (i < len - 1 && heights[i + 1] > heights[i]) {
				int needed = heights[i + 1] - heights[i];
				if (bricks < needed) {
					if (ladders > 0) {
						if (!bricksUsed.isEmpty()) {
							int height = bricksUsed.peek();
							if (height > needed) {
								bricksUsed.poll();
								bricks += height - needed;
								bricksUsed.offer(needed);
							}
						}
						ladders--;
					} else break;
				} else {
					bricks -= needed;
					bricksUsed.offer(needed);
				}
			}
		}
		return max;
	}
}
