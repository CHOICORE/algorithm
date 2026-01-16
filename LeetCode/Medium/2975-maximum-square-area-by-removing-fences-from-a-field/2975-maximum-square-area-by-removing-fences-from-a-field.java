class Solution {
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        Set<Integer> hEdges = getEdges(hFences, m);
        Set<Integer> vEdges = getEdges(vFences, n);
        long r = 0;
        for (int e : hEdges) {
            if (vEdges.contains(e)) {
                r = Math.max(r, e);
            }
        }

        if (r == 0) {
            return -1;
        } else {
            return (int) ((r * r) % 1000000007);
        }
    }

    private Set<Integer> getEdges(int[] fences, int border) {
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();

        for (int fence : fences) {
            list.add(fence);
        }

        list.add(1);
        list.add(border);
        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                set.add(list.get(j) - list.get(i));
            }
        }

        return set;
    }
}