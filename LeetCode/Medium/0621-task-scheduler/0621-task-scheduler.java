class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char task : tasks) {
            freqMap.put(task, freqMap.getOrDefault(task, 0) + 1);
        }
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        maxHeap.addAll(freqMap.values());
        
        int cycles = 0;
        while (!maxHeap.isEmpty()) {
            List<Integer> cooldownList = new ArrayList<>();
            for (int i = 0; i < n + 1; i++) {
                if (!maxHeap.isEmpty()) {
                    int freq = maxHeap.poll();
                    if (freq > 1) {
                        cooldownList.add(freq - 1);
                    }
                }
                cycles++;
                if (maxHeap.isEmpty() && cooldownList.isEmpty()) {
                    break;
                }
            }
            maxHeap.addAll(cooldownList);
        }
        
        return cycles;
    }
}
