class Solution {
public:
    vector<int> getRow(int rowIndex) {
        vector<int> res;
        
        if(rowIndex==0){
            res.push_back(1);
            return res;          
        }
        
        res.push_back(1);
        res.push_back(1);
        if(rowIndex == 1){
            return res;
        }

        vector<int> line;
        for(int i=1; i<rowIndex; i++){
            line = res;
            res.clear();
            res.push_back(1);
            for(int j=0; j<line.size()-1; j++){
                line.push_back(line[j] + line[j+1]);
            }
            res.push_back(1);
        }
        return res;
    }
};