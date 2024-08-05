class Solution {
    public String kthDistinct(String[] arr, int k) {
        List<String> uniqueValInArray = new LinkedList<>();
        int totalDistinct = 0;
        Set<String> nonDistinctSet = new HashSet<>();
        Set<String> distinctSet = new HashSet<>();
        for (String s : arr) {
            if (!nonDistinctSet.contains(s)) {
                if (!distinctSet.contains(s)) {
                    distinctSet.add(s);
                    totalDistinct++;
                } else {
                    nonDistinctSet.add(s);
                    distinctSet.remove(s);
                    totalDistinct--;
                }
            }
        }
        if (totalDistinct < k) {
            return "";
        }
        for (String s : arr) {
            if (distinctSet.contains(s)) {
                k--;
                if (k == 0) {
                    return s;
                }
            }
        }
        return "";
    }
}