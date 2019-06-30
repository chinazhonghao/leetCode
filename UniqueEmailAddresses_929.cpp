class Solution {
public:
    int numUniqueEmails(vector<string>& emails) {
        int length = emails.size();
        int result = 0;
        unordered_set<string> filter_emails;
        for(int i=0; i<length; i++){
            string& current = emails[i];
            int len = current.size();
            int index_plus = current.find_first_of('+');
            int index = current.find_first_of('@');
            string prefix = "";
            if(index_plus != string::npos){
                prefix.append(current, 0, index_plus);
            }

            string tail(current.begin()+index, current.end());
            int index_dot = prefix.find_first_of('.');
            while(index_dot != string::npos){
                prefix = string(prefix, 0, index_dot) + string(prefix.begin()+index_dot, prefix.end());
                index_dot = prefix.find_first_of('.');
            }
            filter_emails.insert(prefix + tail);
        }
        return filter_emails.size();
    }
};