class MyHashMap {
    Node[] nodes;
    int size = 1_000;

    public MyHashMap() {
        this.nodes = new Node[size];
    }

    public int hash(int key) {
        return key % size;
    }

    public void put(int key, int value) {
        Node newNode = new Node(key, value);
        int index = hash(key);
        Node current = nodes[index];

        if (current == null) {
            nodes[index] = newNode;
            return;
        }

        if (current.key == key) {
            current.value = value;
            return;
        }

        while (current.next != null) {

            if (current.next.key == key) {
                current.next.value = value;
                return;
            }

            current = current.next;

        }
        current.next = newNode;

    }

    public int get(int key) {
        int index = hash(key);
        Node current = nodes[index];

        if (current == null) return -1;

        while (current != null) {
            if (current.key == key) return current.value;
            current = current.next;
        }
        return -1;
    }

    public void remove(int key) {
        int index = hash(key);
        Node current = nodes[index];
        Node previous = null;

        if (current == null) {
            return;
        }

        while (current != null) {
            if (current.key == key) {
                if (previous == null) {
                    nodes[index] = current.next;
                } else previous.next = current.next;
            }
            previous = current;
            current = current.next;

        }
    }

    static class Node {
        int key, value;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
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