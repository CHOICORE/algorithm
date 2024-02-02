class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        
        List<Integer> answer = new ArrayList<>();
        
        for (int digit = 1; digit < 9; ++digit) {
            
            int next = digit, n = next;
            
            while (n <= high && next < 10) {
                
                if (n >= low) {
                    answer.add(n);
                }
                n = n * 10 + ++next;
            }
        }
        Collections.sort(answer);
        return answer;
    }
}