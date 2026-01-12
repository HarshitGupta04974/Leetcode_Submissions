class MyQueue {
    Deque<Integer> st;
    Deque<Integer> s;
    public MyQueue() {
        st=new LinkedList<>();
        s=new LinkedList<>();
    }
    
    public void push(int x) {
        st.push(x);
    }
    
    public int pop() {
        if(!(s.isEmpty())){
            return s.pop();
        }
        else{
        while(!st.isEmpty()){
            s.push(st.pop());
        }
        return s.pop();
        }
    }
    
    public int peek() {
       if(!(s.isEmpty())){
           return s.peek();
        }
        else{
        while(!st.isEmpty()){
            s.push(st.pop());
        }
        return s.peek();
        }
    }
    
    public boolean empty() {
        return s.isEmpty() && st.isEmpty();
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