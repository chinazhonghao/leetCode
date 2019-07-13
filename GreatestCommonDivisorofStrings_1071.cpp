class Solution {
public:
    string gcdOfStrings(string str1, string str2) {
        int length1 = str1.size();
        int length2 = str2.size();
        int length = length1 > length2 ? length2:length1;
        vector<int> common;
        for(int i=length; i>0; i--){
            if(length1 % i == 0 && length2 % i==0){
                common.push_back(i);
            }
        }
        for(int i=0; i<common.size(); i++){
            string currentCommon = str1.substr(0, common[i]);
            int count1 = length1 / common[i];
            string _str1 = "";
            for(int j=0; j<count1; j++){
                _str1 += currentCommon;
            }
            if(_str1 != str1){
                continue;
            }
            int count2 = length2 / common[i];
            string _str2 = "";
            for(int j=0; j<count2; j++){
                _str2 += currentCommon;
            }
            if(_str2 == str2){
                return currentCommon;
            }
        }
        return "";
    }
};