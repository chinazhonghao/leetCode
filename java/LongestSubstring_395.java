import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public int longestSubstring(String s, int k) {
        return _recursive(s, k);
    }

    private int _recursive(String s, int k){
        if(s==null || s.isEmpty()){
            return 0;
        }
        int[] counts = new int[26];
        for(int i=0; i<s.length(); i++){
            counts[s.charAt(i)-'a']++;
        }
        char current = '1';
        for(int i=0; i<26; i++){
            if(counts[i]==0){
                continue;
            }
            if(counts[i] < k){
                current = (char)('a' + i);
                break;
            }
        }
        if(current == '1'){
            return s.length();
        }
        List<String> tmp = new ArrayList<>();
        int last = 0;
        int now = 0;
        while((now = s.indexOf(current, last)) > -1){
            tmp.add(s.substring(last, now));
            last = now+1;
        }
        if(last < s.length()){
            tmp.add(s.substring(last));
        }
        int max = 0;
        for(int i=0; i<tmp.size(); i++){
            if(tmp.get(i).length() < k){
                continue;
            }
            max = Math.max(max, _recursive(tmp.get(i), k));
        }
        return max;
    }
}