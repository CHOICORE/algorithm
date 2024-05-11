class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        Worker[] a = new Worker[n];
        for (int i = 0; i < n; ++i) {
            a[i] = new Worker(quality[i], wage[i]);
        }
        Arrays.sort(a);
        int s = 0;
        double res = 1e15;
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (Worker worker : a) {
            q.add(-worker.q());
            s += worker.q();
            if (q.size() > k) s += q.poll();
            if (q.size() == k) res = Math.min(res, (double) s * worker.w() / worker.q());
        }
        return res;
    }
    
    record Worker(int q, int w) implements Comparable<Worker> {

    @Override
    public int compareTo(Worker other) {
        return Integer.compare(w * other.q, q * other.w);
    }
}
}