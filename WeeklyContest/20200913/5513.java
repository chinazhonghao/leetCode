class Solution {
    public int minCostConnectPoints(int[][] points) {
        int length = points.length;
        int counts = 0;
        if(length < 2){
            return counts;
        }
        List<Node> nodes = new ArrayList<>();
        for(int i=0; i<length; i++){
            for(int j=i+1; j<length; j++){
                int distance = Math.abs(points[i][0]-points[j][0]) + Math.abs(points[i][1]-points[j][1]);
                nodes.add(new Node(i, j, distance));
                nodes.add(new Node(j, i, distance));
            }
        }
        Collections.sort(nodes, new MyComparator());
        Set<Integer> set = new HashSet<>();
        int from = nodes.get(0).from;
        int to = nodes.get(0).to;
        set.add(from);
        set.add(to);
        while(set.size() < length){
            int current = 0;
            int distance = Integer.MAX_VALUE;
            for(int i=0; i<length; i++){
                if(set.contains(i)){
                    continue;
                }

            }
            break;
        }
        return counts;
    }
}

class Node {
    public Node(int from, int to, int distance){
        this.from = from;
        this.to = to;
        this.distance = distance;
    }
    int from;
    int to;
    int distance;
}

class MyComparator implements Comparator<Node> {
    @Override
    public int compare(Node a, Node b){
        return a.distance - b.distance;
    }
}