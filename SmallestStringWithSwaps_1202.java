class Solution {
    private int find(int[] parent, int i) {
        while (parent[i] != i) {
            parent[i] = parent[parent[i]];
            i = parent[i];
        }
        return i;
    }
    private void union(int[] parent, int A, int B) {
        int parentA = find(parent, A);
        int parentB = find(parent, B);
        parent[parentB] = parentA;
    }
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        // union find
        int n = s.length();
        int[]parent = new int[n];
        for(int i = 0; i < n; i++) parent[i] = i;
        for(List<Integer> pair:pairs) {
            union(parent, pair.get(0), pair.get(1));
        }
        
        char[] result = s.toCharArray();
        // Build groups of indexes that can be swapped each other
        HashMap<Integer, List<Integer>> groups = new HashMap();
        for(int i = 0; i < n; i++) {
            int root = find(parent, i);
            if(!groups.containsKey(root)) groups.put(root, new ArrayList());
            groups.get(root).add(i);
        }
        // Sort chars in the same group, put them into result array
        for(Integer key:groups.keySet()) {
            // Get and sort the chars in the samp group
            char[] tmp = new char[groups.get(key).size()];
            for(int i = 0; i < tmp.length; i++) {
                tmp[i] = s.charAt(groups.get(key).get(i));
            }
            Arrays.sort(tmp);
            
            for(int i = 0; i < tmp.length; i++) {
                result[groups.get(key).get(i)] = tmp[i];
            }
        }
        return new String(result);
        
    }
}
/*class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        List<HashSet<Integer>> group = new ArrayList<>();
        boolean[] flag = new boolean[pairs.size()];
        for(int i=0; i<pairs.size(); i++){
        	int a = pairs.get(i).get(0);
        	int b = pairs.get(i).get(1);
        	flag[i] = true;
        	boolean _in = false;
        	for(int j=0; j<group.size(); j++){
        		HashSet<Integer> target = group.get(j);
        		if(target.contains(a) || target.contains(b)){
        			target.add(a);
        			target.add(b);
        			_in	= true;
        			break;
        		}
        	}
        	if(!_in){
        		HashSet<Integer> current = new HashSet<>();
        		current.add(a);
        		current.add(b);
        		group.add(current);
        		Stack<Integer> st = new Stack<>();
        		st.push(a);
        		st.push(b);
        		while(!st.empty()){
        			int val = st.pop();
        			for(int j=0; j<pairs.size(); j++){
        				if(flag[j] != true){
        					int a1 = pairs.get(j).get(0);
        					int b1 = pairs.get(j).get(1);
        					if(a1 == val || b1 == val){
        						current.add(a1);
        						current.add(b1);
        						flag[j] = true;
        						if(a1 != val) {
        							st.push(a1);
        						}
        						else {
        							st.push(b1);
        						}
        					}
        				}
        			}
        		}
        		group.add(current);
        	}
        }

        char[] array = s.toCharArray();
        for(int i=0; i<group.size(); i++){
        	HashSet<Integer> current = group.get(i);
        	List<Integer> item = new ArrayList();
        	item.addAll(current);
        	Collections.sort(item);
        	char[] c = new char[item.size()];
        	for(int j=0; j<item.size(); j++){
        		c[j] = array[item.get(j)];
        	}
        	Arrays.sort(c);
        	for(int j=0; j<item.size(); j++){
        		array[item.get(j)] = c[j];
        	}
        }
        return String.valueOf(array);
    }
}*/