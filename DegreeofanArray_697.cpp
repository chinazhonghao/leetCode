typedef struct Record{
	int count;
	int begin;
	int end;
}Record;

class Solution {
public:
    int findShortestSubArray(vector<int>& nums) {
        int length = nums.size();
        // 统计出现次数
        map<int, Record> counts;
        for(int i=0; i<length; i++){
        	if(counts.find(nums[i]) != counts.end()){
        		Record &record = counts[nums[i]];
        		record.count++;
        		record.end = i;
        	}
        	else{
        		Record record;
        		record.count = 1;
        		record.begin = i;
        		record.end = i;
        		counts.insert(pair<int, Record>(nums[i], record));
        	}
        }

        // 寻找次数最大的
        map<int, Record>::iterator iter = counts.begin();
        int currentCount = 0;
        vector<int> minLength;
        for(; iter != counts.end(); iter++){
        	Record &record = iter->second;
        	if(record.count > currentCount){
        		currentCount = record.count;
        		minLength.clear();
        		minLength.push_back(record.end - record.begin + 1);
        	}
        	else if(record.count == currentCount){
        		minLength.push_back(record.end - record.begin + 1);
        	}
        }

        // 输出最大次数
        int subArrayLength = minLength[0];
        length = minLength.size();
        for(int i=1; i<length; i++){
        	if(subArrayLength > minLength[i]){
        		subArrayLength = minLength[i];
        	}
        }

        return subArrayLength;
    }
};