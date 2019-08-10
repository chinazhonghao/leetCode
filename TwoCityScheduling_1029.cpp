class Solution {
public:
    int twoCitySchedCost(vector<vector<int>>& costs) {
        map<int, int> diff;
        int length = costs.size();
        for(int i=0; i<length; i++){
            diff.insert(pair<int, int>(i, costs[i][0] - costs[i][1]));
        }
        vector<pair<int, int>> vec(diff.begin(), diff.end());
        sort(vec.begin(), vec.end(), cmp);
        int N = length >> 1;
        int cost = 0;
        for(int i=0; i<N; i++){
            int index = vec[i].first;
            cost += costs[index][0];
        }
        for(int i=N; i<length; i++){
            int index = vec[i].first;
            cost += costs[index][1];
        }
        return cost;
    }

private:
    bool static cmp(const pair<int, int>& a, const pair<int, int>& b){
        return a.second < b.second;
    }
};