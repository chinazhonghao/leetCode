class Solution {
public:
    vector<vector<int>> largeGroupPositions(string S) {
        vector<vector<int>> result;
        int len = S.size();
        for(int i=0; i<len;){
            char& start = S.at(i);
            int length = 1;
            while(length < len - i){
                if(start == S.at(i + length)){
                    length++;
                    continue;
                }
                break;
            }
            if(length >= 3){
                vector<int> tmp = {i, i+length-1};
                result.push_back(tmp);
            }
            i += length;
        }
        return result;
    }
};