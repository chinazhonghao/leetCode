	class SnapshotArray {

	    public SnapshotArray(int length) {
	        this.array = new int[length];
	        this.counts = 0;
	        this.map = new HashMap<>();
	    }
	    
	    public void set(int index, int val) {
	        this.array[index] = val;
	    }
	    
	    public int snap() {
	    	HashMap<Integer, Integer> s = new HashMap<>();
	    	for(int i=0; i<this.array.length; i++){
	    		if(this.array[i] != 0){
	    			s.put(i, this.array[i]);
	    		}
	    	}
	    	this.map.put(this.counts, s);
	        return this.counts++;
	    }
	    
	    public int get(int index, int snap_id) {
	    	HashMap<Integer, Integer> target = this.map.get(snap_id);
	    	if(target.containsKey(index)){
	    		return target.get(index);
	    	}
	    	return 0;
	    }

	    private HashMap<Integer, HashMap<Integer, Integer>> map;
	    private int[] array;
	    private int counts;
	}

	/**
	 * Your SnapshotArray object will be instantiated and called as such:
	 * SnapshotArray obj = new SnapshotArray(length);
	 * obj.set(index,val);
	 * int param_2 = obj.snap();
	 * int param_3 = obj.get(index,snap_id);
	 */