class Solution {
public:
    vector<vector<int>> generate(int numRows) {
        vector<vector<int>> res;
        for(int i=0; i<numRows; i++){
            vector<int> line;
            line.push_back(1);
            if(i==0){
                res.push_back(line);
                continue;
            }
            if(i==1){
                line.push_back(1);
                res.push_back(line);
                continue;
            }
            vector<int>& last_line = res[res.size() - 1];
            for(int j=0; j<last_line.size()-1; j++){
                line.push_back(last_line[j] + last_line[j+1]);
            }
            line.push_back(1);
            res.push_back(line);
        }
        return res;
    }
};