class SeatManager {
    private PriorityQueue<Integer> availableSeats;

    public SeatManager(int n) {
        availableSeats = new PriorityQueue<>();
        for (int seatNumber = 1; seatNumber <= n; ++seatNumber) {
            availableSeats.offer(seatNumber);
        }
    }

    public int reserve() {
        int seatNumber = availableSeats.poll();
        return seatNumber;
    }

    public void unreserve(int seatNumber) {
        availableSeats.offer(seatNumber);
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */