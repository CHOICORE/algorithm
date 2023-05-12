class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> arr = new ArrayList<>();
        func(candidates, arr, target, 0, new ArrayList<Integer>());
        return arr;
    }

    public void func(int[] candi, List<List<Integer>> arr, int target, int idx, List<Integer> temp) {
        if (idx == candi.length) {
            if (target == 0) arr.add(new ArrayList<>(temp));
            return;
        }
        if (candi[idx] <= target) {
            temp.add(candi[idx]);
            func(candi, arr, target - candi[idx], idx, temp);
            temp.remove(temp.size() - 1);
        }
        func(candi, arr, target, idx + 1, temp);
    }
}