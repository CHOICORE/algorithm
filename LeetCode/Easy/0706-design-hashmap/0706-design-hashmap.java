class MyHashMap {
    ArrayList<Integer> keys;
    ArrayList<Integer> values;

    public MyHashMap() {
        keys = new ArrayList<>();
        values = new ArrayList<>();

    }

    public void put(int key, int value) {
        if (keys.contains(key)) {
            int i = keys.indexOf(key);
            values.set(i, value);
        } else {
            keys.add(key);
            values.add(value);
        }
    }

    public int get(int key) {
        if (!keys.contains(key)) {
            return -1;
        } else {
            int i = keys.indexOf(key);
            return values.get(i);
        }

    }

    public void remove(int key) {
        if (keys.contains(key)) {
            int i = keys.indexOf(key);
            keys.remove(i);
            values.remove(i);
        }

    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */