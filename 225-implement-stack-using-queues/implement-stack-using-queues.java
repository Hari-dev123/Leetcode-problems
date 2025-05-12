class MyStack {

    Queue<Integer> l1;

    public MyStack() {
        l1 = new LinkedList<>();
    }
    
    public void push(int x) {
        l1.add(x);
        int n = l1.size();
        for(int i = 0;i<n-1;i++){
            l1.add(l1.poll());
        }
    }
    
    public int pop() {
        return l1.poll();
    }
    
    public int top() {
        return l1.peek();
    }
    
    public boolean empty() {
        return l1.isEmpty();
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