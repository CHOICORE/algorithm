import java.util.AbstractList;

class Solution {
    private List<Integer> answer;

    public List<Integer> findDuplicates(int[] nums) {
        return new AbstractList<>() {
            public Integer get(int index) {
                init();
                return answer.get(index);
            }

            public int size() {
                init();
                return answer.size();
            }

            private void init() {
                if (answer != null) return;
                answer = new ArrayList<>();
                int t;
                for (int i = 0; i < nums.length; i++) {
                    t = Math.abs(nums[i]);
                    if (nums[t - 1] < 0) {
                        answer.add(t);
                    } else {
                        nums[t - 1] *= -1;
                    }
                }
            }
        };
    }
}