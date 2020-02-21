class Solution {
    public int maximumSwap(int num) {
        String value = String.valueOf(num);
        int length = value.length();
        Node[] nodes = new Node[length];
        int[] n = new int[length];
        for(int i=0; i<length; i++){
        	nodes[i] = new Node(value.charAt(i)-'0', i);
        	n[i] = nodes[i].value;
        }
        Arrays.sort(nodes, (a, b) -> b.value - a.value);
        for(int i=0; i<length; i++){
        	if(n[i] < nodes[i].value){
        		int j=i+1;
        		for(; j<length; j++){
        			if(nodes[j].value != nodes[i].value){
        				break;
        			}
        		}
        		int tmp = n[i];
        		n[i] = nodes[i].value;
        		n[nodes[j-1].pos] = tmp;
        		break;
        	}
        }
        StringBuilder builder = new StringBuilder();
        for(int i=0; i<length; i++){
        	builder.append(n[i]);
        }
        return Integer.parseInt(builder.toString());
    }
}

class Node {
	public Node(int value, int pos){
		this.value = value;
		this.pos = pos;
	}
	public int value;
	public int pos;
}