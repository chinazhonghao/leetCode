class Solution {
    public String rankTeams(String[] votes) {
        Map<String, Node> m = new HashMap<>();
        int length = votes[0].length();
        for(int i=0; i<length; i++){
            Node node = new Node(votes[0].charAt(i), length);
            node.seqs[i]++;
            m.put(votes[0].substring(i, i+1), node);
        }
        for(int i=1; i<votes.length; i++){
            for(int j=0; j<length; j++){
                Node node = m.get(votes[i].substring(j, j+1));
                node.seqs[j]++;
            }
        }
        Node[] nodes = new Node[length];
        int index = 0;
        for(String key: m.keySet()){
            nodes[index++] = m.get(key);
        }
        Arrays.sort(nodes, (a, b) -> {
            for(int i=0; i<a.seqs.length; i++){
                if(a.seqs[i] > b.seqs[i]){
                    return -1;
                }
                else if(a.seqs[i] < b.seqs[i]){
                    return 1;
                }
            }

            if(a.name > b.name){
                return 1;
            }

            return 1;
        });
        StringBuilder builder = new StringBuilder();
        for(Node node: nodes){
            builder.append(node.name);
        }
        return builder.toString();
    }
}

class Node {
    public Node(char name, int length){
        this.name = name;
        seqs = new int[length];
    }

    public int[] seqs;
    public char name;
}