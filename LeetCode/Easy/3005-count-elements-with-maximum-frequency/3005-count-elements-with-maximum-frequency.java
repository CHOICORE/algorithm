class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] frequencies = new int[100];
        for (int num : nums) {
            frequencies[num - 1]++;
        }

        Arrays.sort(frequencies);
        int maxFreqIndex = frequencies.length - 1;
        int totalFrequencies = frequencies[maxFreqIndex];

        while (maxFreqIndex > 0 && frequencies[maxFreqIndex] == frequencies[maxFreqIndex - 1]) {
            totalFrequencies += frequencies[maxFreqIndex];
            maxFreqIndex--;
        }
        return totalFrequencies;
    }
}