class SmallestInfiniteSet {
    private SortedSet<Integer> addedIntegers;
    private Integer currentInteger;
    
    public SmallestInfiniteSet() {
        addedIntegers = new TreeSet<>();
        currentInteger = 1;
    }
    
    public int popSmallest() {
        int answer;
        if (!addedIntegers.isEmpty()) {
            answer = addedIntegers.first();
            addedIntegers.remove(answer);
        } 
        else {
            answer = currentInteger;
            currentInteger += 1;
        }
        return answer;
    }
    
    public void addBack(int num) {
        if (currentInteger <= num || addedIntegers.contains(num)) {
            return;
        }
        addedIntegers.add(num);
    }
}