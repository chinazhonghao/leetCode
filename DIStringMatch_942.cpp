class Solution {
public:
    vector<int> diStringMatch(string S) {
        int length = S.size();
        int right = length;
        int left = 0;
        vector<int> result(length + 1);
        for(int i=0; i<length; i++){
            if(S[i] == 'D'){
                result.push_back(right--);
            }
            else{
                result.push_back(left++);
            }
        }
        result.push_back(left);
        return result;
    }
};