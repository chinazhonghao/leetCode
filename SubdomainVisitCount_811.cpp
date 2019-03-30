class Solution {
public:
    vector<string> subdomainVisits(vector<string>& cpdomains) {
        int length = cpdomains.size();
        vector<string> result;
        unordered_map<string, int> record;
        for(int i=0; i<length; i++){
        	string current = cpdomains[i];
        	size_t pos = current.find_first_of(" ");
        	string nums_str = current.substr(0, pos);
        	int nums = atoi(nums_str.c_str());
        	string domains = current.substr(pos+1);
        	while(domains.size() > 0){
        		if(record.find(domains) != record.end()){
	        		record[domains] += nums;
	        	}
	        	else {
	        		record[domains] = nums;
	        	}
	        	domains = getSubDomain(domains);
        	}
        }
        for(unordered_map<string, int>::iterator iter=record.begin(); iter!=record.end(); iter++){
        	stringstream ss;
        	ss << iter->second;
        	string tmp = ss.str();
        	tmp.append(" ");
        	tmp.append(iter->first);
        	result.push_back(tmp); 
        }
        return result;
    }

    string getSubDomain(string& domains){
    	string flag = ".";
    	size_t pos = domains.find_first_of(flag);
    	if(pos == string::npos){
    		return "";
    	}
    	return domains.substr(pos+1);
    }
};