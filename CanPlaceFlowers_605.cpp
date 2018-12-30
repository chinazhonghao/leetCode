class Solution {
public:
    bool canPlaceFlowers(vector<int>& flowerbed, int n) {
        int length = flowerbed.size();
        int nums = 0;
        for(int i=0; i<length; i++){
            if(flowerbed[i]==1){
                i++;
            }
            else if(i<length-1 && flowerbed[i+1]==0 && (i==0 || flowerbed[i-1]==0)){
                nums++;
                i++;
            }
            else if(i==length-1 && flowerbed[i-1]==0){
                nums++;
            }
        }
        return nums >= n;
    }
};