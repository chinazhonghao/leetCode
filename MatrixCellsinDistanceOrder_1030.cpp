class Solution {
public:
    vector<vector<int>> allCellsDistOrder(int R, int C, int r0, int c0) {
        vector<vector<int>> coors;
        for(int r=0; r<R; r++){
            for(int c=0; c<C; c++){
                vector<int> pos;
                pos.push_back(r);
                pos.push_back(c);
                coors.push_back(pos);
            }
        }
        map<int, int> diff;
        int length = coors.size();
        for(int i=0; i<length; i++){
            int minus = fabs(coors[i][0]-r0)+fabs(coors[i][1]-c0);
            diff.insert(pair<int, int>(i, minus));
        }
        vector<pair<int, int>> vec(diff.begin(), diff.end());
        sort(vec.begin(), vec.end(), cmp);
        vector<vector<int>> result;
        for(int i=0; i<length; i++){
            result.push_back(coors[vec[i].first]);
        }
        return result;
    }

private:
    bool static cmp(const pair<int, int>& a, const pair<int, int>& b){
        return a.second < b.second;
    }
};