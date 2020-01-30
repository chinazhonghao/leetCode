class Solution {
    public int[] gardenNoAdj(int N, int[][] paths) {
        Map<Integer, Link> m = new TreeMap<>();
        for(int i=1; i<=N; i++){
        	m.put(Integer.valueOf(i), new Link());
        }
        int row = paths.length;
        for(int i=0; i<row; i++){
        	int a = paths[i][0];
        	int b = paths[i][1];
        	Link la = m.get(Integer.valueOf(a));
        	Link lb = m.get(Integer.valueOf(b));
        	la.arrays.add(b);
        	lb.arrays.add(a);
        }

        int[] result = new int[N];
        result[0] = 1;
        for(int i=1; i<N; i++){
        	result[i] = 0;
        }

        int[] flag = new int[5];
        for(int i=1; i<N; i++){
        	for(int j=0; j<5; j++){
        		flag[j] = 0;
        	}
        	Link l = m.get(Integer.valueOf(i+1));
        	for(int j=0; j<l.arrays.size(); j++){
        		flag[result[l.arrays.get(j)-1]] = 1;
        	}
        	for(int j=1; j<5; j++){
        		if(flag[j] == 0){
        			result[i] = j;
        		}
        	}
        }
        return result;
    }

    public static class Link {
    	public Link(){
    		this.arrays = new ArrayList<>();
    	}

    	public List<Integer> arrays;
    }
}