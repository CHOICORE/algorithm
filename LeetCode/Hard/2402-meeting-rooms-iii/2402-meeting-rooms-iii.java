class Solution {
    public int mostBooked(int n, int[][] mt) {
        int[] counts = new int[n];
        long[] temp = new long[n];
        
        Arrays.sort(mt, Comparator.comparingInt(a -> a[0]));
        
        for (int[] m : mt) {
            int st = m[0], ed = m[1];
            boolean f = false;
            long min = Long.MAX_VALUE;
            int idx = -1;
            for (int i = 0; i < n; i++) {
                if (temp[i] < min) {
                    min = temp[i];
                    idx = i;
                }
                if (temp[i] <= st) {
                    temp[i] = ed;
                    f = true;
                    counts[i]++;
                    break;
                }
            }
            if (!f) {
                temp[idx] += (ed - st);
                counts[idx]++;
            }
        }
        
        int max = 0, answer = 0;
        for (int i = 0; i < n; i++) {
            if (counts[i] > max) {
                max = counts[i];
                answer = i;
            }
        }
        
        return answer;
    }
}