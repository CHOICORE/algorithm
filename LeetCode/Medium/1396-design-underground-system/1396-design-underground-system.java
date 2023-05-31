class UndergroundSystem {
    Map<Integer, Map.Entry<String, Integer>> usersOnboard;
    Map<Map.Entry<String, String>, Map.Entry<Double, Integer>> averageTime;

    public UndergroundSystem() {
        this.usersOnboard = new HashMap<>();
        this.averageTime = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        if (usersOnboard.containsKey(id)) {
            return;
        }

        usersOnboard.put(id, Map.entry(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        if (!usersOnboard.containsKey(id)) {
            return;
        }

        Map.Entry<String, Integer> previousStop = usersOnboard.remove(id);
        Map.Entry<String, String> stationPair = Map.entry(previousStop.getKey(), stationName);
        double time = t - previousStop.getValue();

        if (averageTime.containsKey(stationPair)) {
            Map.Entry<Double, Integer> curAvg = averageTime.get(stationPair);
            Map.Entry<Double, Integer> newAvg = Map.entry(curAvg.getKey() + time, curAvg.getValue() + 1);
            averageTime.put(stationPair, newAvg);
        }
        else {
            averageTime.put(stationPair, Map.entry(time, 1));
        }
    }
    
    public double getAverageTime(String startStation, String endStation) {
        Map.Entry<String, String> stationPair = Map.entry(startStation, endStation);
        Map.Entry<Double, Integer> curAvg = averageTime.get(stationPair);
        return curAvg.getKey() / curAvg. getValue();
    }
}
/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */