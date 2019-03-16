class Solution {
public:
    int numberOfBoomerangs(vector<pair<int, int>>& points) {
        int count = 0;
        int length = points.size();
        for(int i=0; i<length; i++){
        	pair<int, int>& start = points[i];
        	map<int, int> record;
        	for(int j=0; j<length; j++){
        		if(j == i){
        			continue;
        		}
        		pair<int, int>& current = points[j];
        		int dis = (start.first - current.first) * (start.first - current.first) + (start.second - current.second) * (start.second - current.second);
        		if(record.find(dis) != record.end()){
        			record[dis]++;
        		}
        		else{
        			record.insert(pair<int, int>(dis, 1));
        		}
        	}
        	for(map<int, int>::iterator it=record.begin(); it != record.end(); it++){
        		count += (it->second * (it->second - 1));
        	}
        }
        return count;
    }
};