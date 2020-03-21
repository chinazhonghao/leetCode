class Solution {
public:
    vector<int> relativeSortArray(vector<int>& arr1, vector<int>& arr2) {
        vector<int> result;
        vector<int> notIn;
        int length = arr2.size();
        int len = arr1.size();
        for(int i=0; i<length; i++){
            int current = arr2[i];
            for(int j=0; j<len; j++){
                if(arr1[j] == current){
                    result.push_back(current);
                }
            }
        }
        for(int i=0; i<len; i++){
            int current = arr1[i];
            bool isIn = false;
            for(int j=0; j<length; j++){
                if(current == arr2[j]){
                    isIn = true;
                    break;
                }
            }
            if(!isIn){
                notIn.push_back(current);
            }
        }
        sort(notIn.begin(), notIn.end());
        for(int i=0; i<notIn.size(); i++){
            result.push_back(notIn[i]);
        }
        return result;
    }
};