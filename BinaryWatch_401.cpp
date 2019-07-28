class Solution {
public:
    vector<string> readBinaryWatch(int num) {
        int hourNum = 3;
        int minuteNum = 5;
        vector<string> result;
        if(num > hourNum + minuteNum){
            return result;
        }
        else if(num < 1){
            result.push_back("0:00");
            return result;
        }

        vector<int> hourAll = {8, 4, 2, 1};
        vector<int> minuteAll = {32, 16, 8, 4, 2, 1};
        int hourLimit = hourNum<num?hourNum:num;
        set<int> res;
        vector<int> recordIndex;
        set<int> minuteRes;
        vector<int> minuteIndex;
        for(int i=0; i<=hourLimit; i++){
            res.clear();
            recordIndex.resize(i);
            choose(hourAll, i, 0, 12, res, recordIndex);
            minuteRes.clear();
            minuteIndex.resize(num-i);
            choose(minuteAll, num-i, 0, 60, minuteRes, minuteIndex);
            set<int>::iterator hourBegin, minuteBegin;
            char hourStr[4];
            char minuteStr[4];
            for(hourBegin=res.begin(); hourBegin != res.end(); hourBegin++){
                sprintf(hourStr, "%d", *hourBegin);
                for(minuteBegin=minuteRes.begin(); minuteBegin!=minuteRes.end(); minuteBegin++){
                    sprintf(minuteStr, "%02d", *minuteBegin);
                    result.push_back(string(hourStr)+":"+string(minuteStr));
                }
            }
        }
        return result;
    }

    void choose(vector<int>& p, int num, int start, int limit, set<int>& res, vector<int>& recordIndex){
        if(num == 0){
            int sum = 0;
            int count = recordIndex.size();
            for(int i=0; i<count; i++){
                sum += p[recordIndex[i]];
            }
            if(sum < limit){
                res.insert(sum);
            }
            return;
        }
        int M = p.size();
        for(int i=start; i<=M-num; i++){
            recordIndex[num-1] = i;
            choose(p, num-1, i+1, limit, res, recordIndex);
        }
    }
};