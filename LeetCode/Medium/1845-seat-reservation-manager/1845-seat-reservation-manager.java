class SeatManager {

    boolean[] res;
    int min = 1;
    int unreserved=0;
    public SeatManager(int n) {
        res=new boolean[n+1];

    }
    
    public int reserve() {
        if (unreserved == 0){
            res[min] = true;
            return min++;
        }

        for (int i = 1; i<res.length;i++){
            if (!res[i]){
                res[i] = true;
                unreserved--;
                return i;
            }
        }
        return -1;
    }
    
    public void unreserve(int seatNumber) {
        unreserved++;
        res[seatNumber]=false;
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */