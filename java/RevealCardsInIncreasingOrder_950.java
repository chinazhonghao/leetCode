class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        int length = deck.length;
        Queue<Integer> q = new LinkedList<>();
        int[] result = new int[length];
        for(int i=0; i<length; i++){
        	q.add(i);
        }
        for(int i=0; i<length; i++){
        	result[q.poll()] = deck[i];
        	if(!q.isEmpty()){
        		q.add(q.poll());
        	}
        }
        return result;
    }
}