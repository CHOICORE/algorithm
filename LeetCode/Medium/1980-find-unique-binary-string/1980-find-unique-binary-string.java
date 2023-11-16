class Solution {
    int n;
    Set<String> numsSet = new HashSet<>();

    private String generate(String curr) {
        if (curr.length() == n) {
            if (!numsSet.contains(curr)) {
                return curr;
            }

            return "";
        }

        String addZero = generate(curr + "0");
        if (!addZero.isEmpty()) {
            return addZero;
        }

        return generate(curr + "1");
    }

    public String findDifferentBinaryString(String[] nums) {
        n = nums.length;
        Collections.addAll(numsSet, nums);

        return generate("");
    }
}
