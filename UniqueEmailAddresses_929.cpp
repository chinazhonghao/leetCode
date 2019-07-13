class Solution {
public:
    int numUniqueEmails(vector<string>& emails) {
        int length = emails.size();
        int result = 0;
        unordered_set<string> filter_emails;
        for(int i=0; i<length; i++){
            string& current = emails[i];
            int domainStartIndex = current.find_first_of('@');
            string localName(current, 0, domainStartIndex);
            int plusIndex = localName.find_first_of('+');
            localName = localName.substr(0, plusIndex);
            string actualLocalName = "";
            int startIndex = -1;
            while(1){
                int dotIndex = localName.find_first_of('.', startIndex+1);
                actualLocalName += localName.substr(startIndex+1, dotIndex-startIndex-1);
                startIndex = dotIndex;
                if(dotIndex == string::npos){
                    break;
                }
            }
            filter_emails.insert(actualLocalName + current.substr(domainStartIndex));
        }
        return filter_emails.size();
    }
};