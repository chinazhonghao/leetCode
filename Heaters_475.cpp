class Solution {
public:
    int findRadius(vector<int>& houses, vector<int>& heaters) {
        sort(houses.begin(), houses.end());
        sort(heaters.begin(), heaters.end());
        int a = 0, b, mid, res = 0;
        bool flag;
        for(int h: houses){
            b = heaters.size()-1;
            if(heaters[a] == h || heaters[b] == h)
                continue;
            flag = false;
            while(b - a > 1){
                mid = (a + b) >> 1;
                if(heaters[mid] > h){
                    b = mid;
                }
                else{
                    a = mid;
                }
            }
            res = max(res, min(abs(heaters[a]-h), abs(heaters[b]-h)));
        }
        return res;
    }
};