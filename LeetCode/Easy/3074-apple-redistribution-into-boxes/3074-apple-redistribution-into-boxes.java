class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int sum = 0;
        for (int a : apple) {
            sum += a;
        }

        Integer[] capacities = new Integer[capacity.length];
        for (int i = 0; i < capacity.length; i++) {
            capacities[i] = capacity[i];
        }

        Arrays.sort(capacities, Collections.reverseOrder());

        int r = 0;
        while (sum > 0) {
            sum -= capacities[r];
            r += 1;
        }

        return r;
    }
}