#include <vector>

class Solution {
public:
    vector<int> twoSum(vector<int>& numbers, int target) {
        vector<int> res;
        int index1 = 0;
        int index2 = numbers.size()-1;
        while(index2 > index1){
            int sum = numbers[index2] + numbers[index1];
            if(sum > target){
                index2--;
            }
            else if(sum < target){
                index1++;
            }
            else{
                return {index1+1, index2+1};
            }
        }
        return {};
    }
};