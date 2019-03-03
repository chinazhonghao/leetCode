class Solution {
public:
    bool wordPattern(string pattern, string str) {
        vector<string> strVector;
        char * p = (char *)str.c_str();
        char * sp = strtok(p, " ");
        while(sp != NULL){
        	string a(sp);
        	strVector.push_back(a);
        	sp = strtok(NULL, " ");
        }
        int patternLenght = pattern.size();
        int strLength = strVector.size();
        if(strLength != patternLenght){
        	return false;
        }
        map<char, string> record;
        map<string, char> record1;
        for(int i=0; i<strLength; i++){
        	char s = pattern[i];
        	map<char, string>::iterator it = record.find(s);
        	if(it != record.end()){
        		if(it->second != strVector[i]){
        			return false;
        		}
        	}
        	else{
        		record.insert(pair<char, string>(s, strVector[i]));
        	}
        	map<string, char>::iterator it1 = record1.find(strVector[i]);
        	if(it1 != record1.end()){
        		if(it1->second != s){
        			return false;
        		}
        	}
        	else{
        		record1.insert(pair<string, char>(strVector[i], s));
        	}
        }
        return true;
    }
};