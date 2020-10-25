class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int[] counts = new int[26];
        int len = keysPressed.length();
        int time = releaseTimes[0];
        int index = keysPressed.charAt(0) - 'a';
        counts[index] = time;
        for(int i=1; i<len; i++){
            index = keysPressed.charAt(i) - 'a';
            time = releaseTimes[i] - releaseTimes[i-1];
            if(time > counts[index]) {
                counts[index] = time;
            }
        }
        for(int i=0; i<26; i++){
            if(time <= counts[i]){
                time = counts[i];
                index = i;
            }
        }
        return (char)('a' + index);
    }
}