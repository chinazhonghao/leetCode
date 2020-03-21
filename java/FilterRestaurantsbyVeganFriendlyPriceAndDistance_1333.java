class Solution {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        List<Restaurant> rests = new LinkedList<>();
        int row = restaurants.length;
        for(int i=0; i<row; i++){
        	int[] current = restaurants[i];
        	if(current[2] >= veganFriendly && current[3] <= maxPrice && current[4] <= maxDistance){
        		insert(rests, new Restaurant(current[0], current[1]));
        	}
        }
        List<Integer> ids = new ArrayList<>();
        for(Restaurant rest: rests){
        	ids.add(rest.id);
        }
        return ids;
    }

    private void insert(List<Restaurant> rests, Restaurant rest){
    	int i=0;
    	for(; i<rests.size(); i++){
    		Restaurant current = rests.get(i);
    		if(current.rating < rest.rating){
    			break;
    		}
    		else if(current.rating == rest.rating && current.id < rest.id){
    			break;
    		}
    	}
    	rests.add(i, rest);
    }
    
    public static class Restaurant {
        public Restaurant(int id, int rating){
            this.id = id;
            this.rating = rating;
        }
        
        public int id;
        public int rating;
    }
}