class SnapshotArray {

    List<int[]> listOfArray = new ArrayList<>();
    int[] inArray;
    int length = 0;
    int size = 1;
    boolean needsNewSnapshot = false;

    public SnapshotArray(int length) {
        inArray = new int[length];
        this.length = length;
    }

    public void set(int index, int val) {
        inArray[index] = val;
        // System.out.println("set "+Arrays.toString(inArray));
        size = Math.max(size, index + 1);
        needsNewSnapshot = true;
    }

    public int snap() {
        int[] snap = null;
        if (needsNewSnapshot) {
            snap = new int[size];
            System.arraycopy(inArray, 0, snap, 0, size);
        } else {
            snap = listOfArray.size() > 0 ? listOfArray.get(listOfArray.size() - 1) : new int[0];
        }
        listOfArray.add(snap);
        needsNewSnapshot = false;
        return listOfArray.size() - 1;
    }

    public int get(int index, int snap_id) {
        int[] snapshot = listOfArray.get(snap_id);
        // for(int[] in : listOfArray){
        //     System.out.println("snap: "+Arrays.toString(in));
        // }
        // System.out.println(Arrays.toString(snapshot));
        // System.out.println(Arrays.toString(inArray));

        if (index < snapshot.length) {
            return snapshot[index];
        }
        return 0;
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */