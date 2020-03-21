class Solution {
public:
    int uniqueMorseRepresentations(vector<string>& words) {
        vector<string> table = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        unordered_set<string> convert;
        int length = words.size();
        for(int i=0; i<length; i++){
            string result = "";
            string & current = words[i];
            int len = current.size();
            for(int j=0; j<len; j++){
                result += table[current[j]-'a'];
            }
            convert.insert(result);
        }
        return convert.size();
    }
};