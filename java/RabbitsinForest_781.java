import java.util.HashSet;

class Solution {
    public int numRabbits(int[] answers) {
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<answers.length; i++){
            int current = answers[i];
            if(current == 0){
                result++;
            }
            else if(!map.containsKey(current)){
                result += current+1;
                map.put(current, 1);
            }
            else {
                int count = map.get(current);
                if(count <= current){
                    map.put(current, count+1);
                }
                else {
                    map.put(current, 1);
                    result += current+1;
                }
            }
        }
        return Math.max(result, answers.length);
    }
}