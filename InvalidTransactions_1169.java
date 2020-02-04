class Solution {
    public List<String> invalidTransactions(String[] transactions) {
        List<String> result = new ArrayList<>();
        List<Node> nodes = new ArrayList<>();
        for(int i=0; i<transactions.length; i++){
        	nodes.add(new Node(transactions[i]));
        }
        HashMap<String, List<Node>> m = new HashMap<>();
        for(int i=0; i<transactions.length; i++){
        	Node current = nodes.get(i);
        	if(m.containsKey(current.name)){
        		m.get(current.name).add(current);
        	}
        	else {
        		List<Node> tmp = new ArrayList();
        		tmp.add(current);
        		m.put(current.name, tmp);
        	}
        }
        HashSet<String> invalid = new HashSet<>();
        for(Map.Entry<String, List<Node>> entry: m.entrySet()){
        	List<Node> current = entry.getValue();
        	for(int i=0; i<current.size(); i++){
        		Node target = current.get(i);
        		if(target.amount > 1000){
        			invalid.add(target.transaction);
        		}
        		for(int j=0; j<current.size(); j++){
        			Node node = current.get(j);
        			if(!target.city.equals(node.city) && Math.abs(target.minutes-node.minutes) <= 60){
        				invalid.add(target.transaction);
        				invalid.add(node.transaction);
        			}
        		}
        	}
        }
        result.addAll(invalid);
        return result;
    }

    public static class Node{
    	public Node(String transaction){
    		this.transaction = transaction;
    		String[] splits = transaction.split(",");
    		this.name = splits[0];
    		this.minutes = Integer.valueOf(splits[1]);
    		this.amount = Integer.valueOf(splits[2]);
    		this.city = splits[3];
    	}

    	public String transaction;
    	public String name;
    	public int minutes;
    	public int amount;
    	public String city;
    }
}