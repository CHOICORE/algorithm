class Solution {
    public int minMovesToSeat(int[] seats, int[] students) {
        int max = Math.max(findMax(seats), findMax(students));

        int[] differences = new int[max];
        
        for (int position : seats) {
            differences[position - 1]++;
        }

        for (int position : students) {
            differences[position - 1]--;
        }

        int moves = 0;
        int unmatched = 0;
        for (int difference : differences) {
            moves += Math.abs(unmatched);
            unmatched += difference;
        }

        return moves;
    }

    private int findMax(int[] array) {
        int max = 0;
        
        for (int num : array) {
            if (num > max) {
                max = num;
            }
        }
        
        return max;
    }
}