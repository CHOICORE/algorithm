class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> freqMap = new HashMap<>();
        for (String word : words) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }
        
        PriorityQueue<String> minHeap = new PriorityQueue<>(new Comparator<String>() {
            public int compare(String word1, String word2) {
                int freq1 = freqMap.get(word1);
                int freq2 = freqMap.get(word2);
                if (freq1 != freq2) {
                    return freq1 - freq2;
                } else {
                    return word2.compareTo(word1);
                }
            }
        });
        
        for (String word : freqMap.keySet()) {
            minHeap.offer(word);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        
        List<String> result = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            result.add(0, minHeap.poll());
        }
        return result;
    }
}
