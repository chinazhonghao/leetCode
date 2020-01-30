class Solution {
    public int findJudge(int N, int[][] trust) {
    	Map<Integer, People> m = new TreeMap<>();
        for(int i=1; i<=N; i++){
        	m.put(Integer.valueOf(i), new People());
        }

        int row = trust.length;
        for(int i=0; i<row; i++){
        	int a = trust[i][0];
        	int b = trust[i][1];
        	People truster = m.get(Integer.valueOf(a));
        	truster.trust++;
        	People beTrusted = m.get(Integer.valueOf(b));
        	beTrusted.beTrusted++;
        }

        int judge= 0;
        int label = -1;
        for(int i=1; i<=N; i++){
        	People current = m.get(Integer.valueOf(i));
        	if(current.trust==0 && current.beTrusted==N-1){
        		judge++;
        		label = i;
        	}
        }
        if(judge == 1){
        	return label;
        }
        return -1;
    }

    public static class People{
    	public People(){
    		this.trust = 0;
    		this.beTrusted = 0;
    	}

    	public int trust;
    	public int beTrusted;
    }
}