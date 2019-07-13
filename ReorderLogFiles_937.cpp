class Solution {
public:
    vector<string> reorderLogFiles(vector<string>& logs) {
        int length = logs.size();
        vector<string> letterLogs;
        vector<string> digitLogs;
        string delimited = " ";
        for(int i=0; i<length; i++){
            string &current = logs[i];
            int identifierEndIndex = current.find_first_of(delimited);
            char letter = current[identifierEndIndex+1];
            if(letter>='0' && letter<='9'){
                digitLogs.push_back(current);
            }
            else{
                letterLogs.push_back(current);
            }
        }
        sort(letterLogs.begin(), letterLogs.end(), comp);
        for(int i=0; i<digitLogs.size(); i++){
            letterLogs.push_back(digitLogs[i]);
        }
        return letterLogs;
    }

    bool static comp(string a, string b){
        string delimited = " ";
        int identifierEndIndex = a.find_first_of(delimited);
        string _a = a.substr(identifierEndIndex+1);
        string __a = a.substr(0, identifierEndIndex);
        identifierEndIndex = b.find_first_of(delimited);
        string _b = b.substr(identifierEndIndex+1);
        string __b = b.substr(0, identifierEndIndex);
        if(_a == _b){
            return __a < __b;
        }
        return _a < _b;
    }
};