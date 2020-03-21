class Solution {
public:
    int findContentChildren(vector<int>& g, vector<int>& s) {
        sort(g.begin(), g.end());
        sort(s.begin(), s.end());
        int length = g.size();
        int lengthS = s.size();
        int count = 0;
        int start = 0;
        for(int i=0; i<length; i++){
            int current = g[i];
            for(int j=start; j<lengthS; j++){
                if(s[j] >= current){
                    start = j + 1;
                    count++;
                    break;
                }
            }
            if(start >= lengthS){
                break;
            }
        }
        return count;
    }
};