class Solution {
public:
    int maxDistToClosest(vector<int>& seats) {
        int length = seats.size();
        int distance = 0;
        int maxDistance = 0;
        bool begin = false;
        if(seats[0]==0){
            distance++;
        }
        else{
            begin = true;
        }
        for(int i=1; i<length; i++){
            if(seats[i]==0){
                distance++;
            }
            else{
                int current = distance-1;
                distance = 0;
                if(begin){
                    current = current >> 1;
                }
                if(current > maxDistance){
                    maxDistance = current;
                }
                begin = true;
            }
        }
        if(distance > maxDistance){
            maxDistance = distance-1;
        }
        return maxDistance+1;
    }
};