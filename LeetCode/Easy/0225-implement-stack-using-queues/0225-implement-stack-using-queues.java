class MyStack {
    int lastItem;
    Queue<Integer> q1, q2;

    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void push(int x) {
        q1.add(x);
        lastItem = x;
    }

    public int pop() {
        int item = -1;
        while (!q1.isEmpty()) {
            item = q1.poll();
            if (!q1.isEmpty()) {
                lastItem = item;
                q2.add(item);
            } else {
                break;
            }
        }
        while (!q2.isEmpty()) {
            q1.add(q2.poll());
        }
        return item;
    }

    public int top() {
        return lastItem;

    }

    public boolean empty() {
        return q1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */