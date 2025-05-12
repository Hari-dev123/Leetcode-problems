class MyQueue {
    Stack<Integer> s1;
    Stack<Integer> s2;
    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }
    
    public void push(int x) {
        s1.add(x);
    }
    
    public int pop() {
        peek();
        return s2.pop();
    }
    
    public int peek() {
        int data = -1;
         if(!s2.isEmpty()){
             data =  s2.peek();
         }else{
            while(!s1.isEmpty()){
                 s2.add(s1.pop());
            }
            data =  s2.peek();
        }
        return data;
    }
    
    public boolean empty() {
         return s1.isEmpty() && s2.isEmpty();
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