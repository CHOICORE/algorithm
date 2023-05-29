class ParkingSystem {

    int[] limit;

    int[] count;

    public ParkingSystem(int big, int medium, int small) {

        this.limit = new int[]{big, medium, small};

        this.count = new int[]{0, 0, 0};
    }

    public boolean addCar(int carType) {

        if (this.count[carType - 1] < this.limit[carType - 1]) {
            this.count[carType - 1]++;
            return true;
        }

        return false;
    }
}
/**
* Your ParkingSystem object will be instantiated and called as such:
* ParkingSystem obj = new ParkingSystem(big, medium, small);
* boolean param_1 = obj.addCar(carType);
*/