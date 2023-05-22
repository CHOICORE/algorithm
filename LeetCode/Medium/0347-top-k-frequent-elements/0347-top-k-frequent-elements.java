class Solution {
        class Pair {
            private Integer freq;
            private Integer value;

            public Pair(Integer freq, Integer value) {
                this.freq = freq;
                this.value = value;
            }

            @Override
            public String toString() {
                return "Pair{" +
                        "freq=" + freq +
                        ", value=" + value +
                        '}';
            }
        }

        public int[] topKFrequent(int[] nums, int k) {
            final int[] res = new int[k];
            if (nums == null) {
                return nums;
            }
            if (nums.length == 1 && k == 1) {
                return nums;
            }

            Map<Integer, Integer> map = new HashMap<>();
            Queue<Pair> heap = new PriorityQueue<>((o1, o2) -> o1.freq.compareTo(o2.freq));
            for (int i : nums) {
                if (map.containsKey(i)) {
                    map.put(i, map.get(i) + 1);
                } else {
                    map.put(i, 1);
                }
            }
            map.forEach((key, value) -> {
                heap.offer(new Pair(value, key));
                if (heap.size() > k) {
                    heap.poll();
                }
            });

            int i = 0;
            while (!heap.isEmpty()) {
                res[i] = heap.poll().value;
                i++;
            }
            return res;
        }
    }