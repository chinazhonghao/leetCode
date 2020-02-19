class MyCalendar {

	private List<Node> l;

    public MyCalendar() {
        l = new LinkedList<>();
    }
    
    public boolean book(int start, int end) {
    	Node node = new Node(start, end);
    	int index = _findIndex(0, l.size()-1, node);
    	if(index > -1){
    		l.add(index, node);
    		return true;
    	}
    	else {
    		return false;
    	}
    }

    private int _findIndex(int start, int end, Node node){
    	if(start > end){
    		return start;
    	}
    	int mid = (start + end) >> 1;
    	Node m = l.get(mid);
    	if(m.start >= node.end){
    		return _findIndex(start, mid-1, node);
    	}
    	else if(m.end <= node.start){
    		return _findIndex(mid+1, end, node);
    	}
    	else {
    		return -1;
    	}
    }
}

class Node {
	public Node(int start, int end){
		this.start = start;
		this.end = end;
	}
	public int start;
	public int end;
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */