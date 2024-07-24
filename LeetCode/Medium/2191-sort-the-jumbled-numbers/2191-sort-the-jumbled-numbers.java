class Solution {
    static int[] countSort(int[] arr, int place, int[] mapping) {
        int n = arr.length;
        if (n <= 1) return arr;
        int[] result = new int[n];
        int[] freq = new int[10];
        for (int x : arr) {
            if (x / place != 0 || x == 0) {
                int val = (x / place) % 10;
                freq[mapping[val]]++;
            } else {
                freq[0]++;
            }
        }

        for (int i = 1; i < 10; i++) {
            freq[i] += freq[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] / place != 0 || arr[i] == 0) {
                int val = (arr[i] / place) % 10;

                result[freq[mapping[val]] - 1] = arr[i];

                freq[mapping[val]]--;
            } else {
                result[freq[0] - 1] = arr[i];
                freq[0]--;
            }
        }

        return result;
    }

    public int[] sortJumbled(int[] mapping, int[] nums) {
        int max = -1;

        for (int x : nums) {
            if (x > max) max = x;
        }

        int[] answer = nums;
        for (int place = 1; max / place > 0; place *= 10) {
            answer = countSort(answer, place, mapping);
        }
        return answer;
    }
}