class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int length = s.length();
        int[] costs = new int[length];
        for(int i=0; i<length; i++){
        	costs[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }
        int cost = 0;
        int len = 0;
        int begin = 0, end = 1;
        while(end <= length){
        	cost += costs[end-1];
        	if(cost > maxCost){
        		if(end-begin>len){
        			len = end-begin-1;
        		}
        		while(cost > maxCost){
        			cost -= costs[begin];
        			begin++;
        		}
        	}
        	end++;
        }
        if(end - begin > len && cost <= maxCost){
        	len = end-begin-1;
        }
        return len;
    }
}