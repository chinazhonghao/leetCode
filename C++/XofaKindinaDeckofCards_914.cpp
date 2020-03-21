class Solution {
public:
    bool hasGroupsSizeX(vector<int>& deck) {
        int length = deck.size();
        if(length < 2){
            return false;
        }
        sort(deck.begin(), deck.end());
        int currentCount = 1;
        int currentObj = deck[0];
        vector<int> recordCount;
        for(int i=1; i<length; i++){
            if(deck[i] != currentObj){
                recordCount.push_back(currentCount);
                currentObj = deck[i];
                currentCount = 1;
            }
            else{
                currentCount++;
            }
        }
        recordCount.push_back(currentCount);
        
        int cnt = recordCount.size();
        int minCnt = recordCount[0];
        for(int i=1; i<cnt; i++){
            if(recordCount[i] < minCnt){
                minCnt = recordCount[i];
            }
        }
        bool res = false;
        for(int i=2; i<=minCnt; i++){
            int j=0;
            for(; j<cnt; j++){
                if((recordCount[j] % i) != 0){
                    break;
                }
            }
            if(j==cnt){
                res = true;
                break;
            }
        }
        return res;
    }
};