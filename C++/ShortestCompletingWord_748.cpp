class Solution {
public:
    string shortestCompletingWord(string licensePlate, vector<string>& words) {
        sort(words);
        int length = licensePlate.size();
        map<char, int> record;
        for(int i=0; i<length; i++){
        	if(licensePlate[i]>='a' && licensePlate[i]<='z'){
        		recordCount(record, licensePlate[i]);
        	}
        	else if(licensePlate[i]>='A' && licensePlate[i]<='Z'){
        		recordCount(record, licensePlate[i]-'A' + 'a');
        	}
        }
        length = words.size();
        for(int i=0; i<length; i++){
        	string& current = words[i];
        	map<char, int>::iterator iter = record.begin();
        	bool isFind = true;
        	for(; iter != record.end(); iter++){
        		char key = iter->first;
        		int nums = iter->second;
        		int count = findCounts(words[i], key);
        		if(count < nums){
        			isFind = false;
        			break;
        		}
        	}
        	if(isFind){
        		return current;
        	}
        }
        return "";
    }

    static bool compareFunc(string& left, string& right){
    	return left.size() <= right.size();
    }

    void sort(vector<string>& words){
    	int length = words.size();
    	for(int i=0; i<length; i++){
    		for(int j=0; j<length-i-1; j++){
    			if(!compareFunc(words[j], words[j+1])){
    				string tmp = words[j];
    				words[j] = words[j+1];
    				words[j+1] = tmp;
    			}
    		}
    	}
    }

    int findCounts(string& str, char target){
    	int length = str.size();
    	int count = 0;
    	for(int i=0; i<length; i++){
    		if(target == str[i]){
    			count++;
    		}
    	}
    	return count;
    }

    void recordCount(map<char, int>& record, char key){
    	if(record.find(key) != record.end()){
    		record[key]++;
    	}
    	else{
    		record[key] = 1;
    	}
    }
};