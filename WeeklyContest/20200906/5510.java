class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        int result1 = _travel(n, edges, 1);
        if(result1 < 0){
            return -1;
        }

        int result2 = _travel(n, edges, 2);
        if(result2 < 0){
            return -1;
        }
        return result1 + result2;
    }

    private int _travel(int n, int[][] edges, int type){
        Map<Integer, Set<Integer>> m = new HashMap<>();
        int result = 0;
        int counts = edges.length;
        int countEdges = 0;
        for(int i=0; i<counts; i++){
            int[] current = edges[i];
            int from = current[1];
            int to = current[2];
            if(current[0] == type || current[0] == 3){
                if(m.containsKey(from)){
                    Set<Integer> f = m.get(from);
                    if(!f.contains(to)){
                        f.add(to);
                    }
                }
                else {
                    Set<Integer> f = new HashSet<>();
                    f.add(to);
                    m.put(from, f);
                }
                countEdges++;
            }
        }
        int start = 1;
        int nodes = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        Set<Integer> s = new HashSet<>();
        boolean[] flags = new boolean[n+1];
        flags[1] = true;
        int needEdges = 0;
        while(!q.isEmpty()){
            start = q.poll();
            nodes++;
            if(!m.containsKey(start)){
                continue;
            }
            Set<Integer> p = m.get(start);
            Iterator<Integer> it = p.iterator();
            while(it.hasNext()){
                int k = it.next();
                if(!flags[k]){
                    needEdges++;
                    q.add(k);
                    flags[k] = true;
                }
            }
        }
        if(nodes != n){
            return -1;
        }
        return countEdges - needEdges;
    }
}