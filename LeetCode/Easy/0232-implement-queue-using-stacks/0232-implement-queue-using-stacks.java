class MyQueue {
    int[] arr;
    int front = 0;
    int rear = 0;
    int size = 200;

    public MyQueue() {
        arr = new int[size];
    }

    public void push(int x) {
        if (rear == 200) {
            return;
        }
        arr[rear] = x;
        rear++;
    }

    public int pop() {
        int x;
        if (!empty()) {
            x = arr[front];
            front++;
            return x;
        }
        return 0;
    }

    public int peek() {
        if (empty()) ;
        return arr[front];
    }

    public boolean empty() {
        if (front == rear) {
            front = 0;
            rear = 0;
            return true;
        }
        return false;
    }
}
/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */