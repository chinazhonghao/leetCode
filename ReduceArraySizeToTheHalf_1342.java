class Solution {
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> m = new HashMap<>();
        for(int i=0; i<arr.length; i++){
        	if(m.containsKey(arr[i])){
        		m.replace(arr[i], m.get(arr[i])+1);
        	}
        	else {
        		m.put(arr[i], 1);
        	}
        }
        int[] nodes = new int[m.size()];
        int index = 0;
        for(Map.Entry<Integer, Integer> entry: m.entrySet()){
        	nodes[index++] = entry.getValue();
        }
        Arrays.sort(nodes);
        int result = 0;
        int sum = 0;
        for(int i=nodes.length-1; i>=0; i--){
        	if(sum * 2 >= arr.length){
        		break;
        	}
        	result++;
        	sum += nodes[i];
        }
        return result;
    }
}