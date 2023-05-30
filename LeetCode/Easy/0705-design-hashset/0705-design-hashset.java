class MyHashSet {

    boolean buckets[][];
    int bucket = 10000;
    int bucketItem = 10000;

    public MyHashSet() {
        buckets = new boolean[bucket][];
    }

    public int getBucket(int key) {
        return key / bucket;
    }

    public int getBucketItem(int key) {
        return key % bucketItem;
    }

    public void add(int key) {

        int bucketKey = getBucket(key);
        int bucketItemkey = getBucketItem(key);

        if (buckets[bucketKey] == null)
            buckets[bucketKey] = new boolean[bucketItem];

        buckets[bucketKey][bucketItemkey] = true;

    }

    public void remove(int key) {

        int bucketKey = getBucket(key);
        int bucketItemkey = getBucketItem(key);

        if (buckets[bucketKey] != null)
            buckets[bucketKey][bucketItemkey] = false;
    }

    public boolean contains(int key) {
        int bucketKey = getBucket(key);
        int bucketItemkey = getBucketItem(key);

        if (buckets[bucketKey] != null)
            return buckets[bucketKey][bucketItemkey];
        return false;
    }
}
/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */