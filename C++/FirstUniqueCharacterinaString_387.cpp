class Solution {
public:
    int firstUniqChar(string s) {
        int count[26];
        memset(count, 0, sizeof(count));
        int length = s.size();
        for(int i=0; i<length; i++){
        	int index = s.at(i) - 'a';
        	count[index]++;
        }
        int findIndex = -1;
        for(int i=0; i<length; i++){
        	int index = s.at(i) - 'a';
        	if(count[index] == 1){
        		findIndex = s.at(i);
        		break;
        	}
        }
        if(findIndex == -1){
        	return -1;
        }
        return s.find(findIndex);
    }
};