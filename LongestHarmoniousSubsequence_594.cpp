class Solution {
public:
    int findLHS(vector<int>& nums) {
        int resLen = 0;
        sort(nums.begin(), nums.end());
        int length = nums.size();
        if(length < 1){
        	return 0;
        }
        vector<int> uniqueNums;
        map<int, int> record;
        int current = nums[0];
        int count = 1;
        for(int i=1; i<length; i++){
        	if(nums[i] != current){
        		uniqueNums.push_back(current);
        		record.insert(pair<int, int>(current, count));
        		current = nums[i];
        		count = 1;
        	}
        	else{
        		count++;
        	}
        }
        uniqueNums.push_back(current);
        record.insert(pair<int, int>(current, count));

        current = uniqueNums[0];
        length = uniqueNums.size();
        for(int i=1; i<length; i++){
        	if(uniqueNums[i] - current < 2){
        		map<int, int>::iterator it1 = record.find(current);
        		map<int, int>::iterator it2 = record.find(uniqueNums[i]);
        		if(it1->second + it2->second > resLen){
        			resLen = it1->second + it2->second;
        		}
        	}
        	current = uniqueNums[i];
        }
        return resLen;
    }
};