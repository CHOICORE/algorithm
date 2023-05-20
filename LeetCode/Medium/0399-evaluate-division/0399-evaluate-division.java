class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> map = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            String num = equations.get(i).get(0);
            String denom = equations.get(i).get(1);
            double val = values[i];
            if (!map.containsKey(num)) {
                map.put(num, new HashMap<String, Double>());
            }
            map.get(num).put(denom, val);

            if (!map.containsKey(denom)) {
                map.put(denom, new HashMap<String, Double>());
            }
            map.get(denom).put(num, 1 / val);
        }

        double[] ans = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            String num = queries.get(i).get(0);
            String denom = queries.get(i).get(1);

            if (!map.containsKey(num) || !map.containsKey(denom)) {
                ans[i] = -1.0;
            } else if (num.equals(denom)) {
                ans[i] = 1.0;
            } else {
                ans[i] = dfs(num, denom, map);
            }
        }

        return ans;
    }

    public double dfs(String a, String b, Map<String, Map<String, Double>> map) {
        double ans = 1;
        Queue<Pair> q = new LinkedList<>();
        Set<String> seen = new HashSet<>();

        q.offer(new Pair(a, 1));
        seen.add(a);

        while (!q.isEmpty()) {
            Pair remove = q.poll();
            String removedNode = remove.node;
            double ratio = remove.ratio;
            if (b.equals(removedNode)) {
                return ratio;
            }

            Map<String, Double> neighbors = map.get(removedNode);
            for (String node : neighbors.keySet()) {
                if (!seen.contains(node)) {
                    seen.add(node);
                    q.offer(new Pair(node, ratio * neighbors.get(node)));
                }
            }
        }
        return -1;
    }

    class Pair {
        String node;
        double ratio;

        Pair(String node, double ratio) {
            this.node = node;
            this.ratio = ratio;
        }
    }
}