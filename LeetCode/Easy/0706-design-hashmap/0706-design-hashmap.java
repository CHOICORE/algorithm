class MyHashMap {
    Node[] nodes;

    public MyHashMap() {
        nodes = new Node[10_006];
    }

    public void put(int key, int value) {

        int index = key % nodes.length;
        if (nodes[index] != null) {
            Node prev = null;
            Node cur = nodes[index];
            while (cur != null && cur.key != key) {
                prev = cur;
                cur = cur.next;
            }

            if (cur != null) {
                cur.value = value;
            } else {
                prev.next = new Node(key, value);
            }
        } else {
            nodes[index] = new Node(key, value);
        }
    }

    public int get(int key) {
        int index = key % nodes.length;
        if (nodes[index] != null) {
            Node cur = nodes[index];
            while (cur != null) {
                if (cur.key == key) {
                    return cur.value;
                }
                cur = cur.next;
            }
        }
        return -1;
    }

    public void remove(int key) {
        int index = key % nodes.length;
        if (nodes[index] != null) {
            Node prev = null;
            Node cur = nodes[index];
            while (cur != null && cur.key != key) {
                prev = cur;
                cur = cur.next;
            }

            if (cur != null) {
                if (prev != null) {
                    prev.next = cur.next;
                } else {
                    nodes[index] = cur.next;
                }
            }
        }
    }

    static class Node {
        int key, value;
        Node next;

        Node(int _key, int _value) {
            key = _key;
            value = _value;
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