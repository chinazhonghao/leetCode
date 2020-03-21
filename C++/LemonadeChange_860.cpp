class Solution {
public:
    bool lemonadeChange(vector<int>& bills) {
        int length = bills.size();
        int count5 = 0;
        int count10 = 0;
        int count20 = 0;
        for(int i=0; i<length; i++){
            switch (bills[i]){
                case 5:
                    count5++;
                    break;
                case 10:
                    if(count5<1){
                        return false;
                    }
                    count5--;
                    count10++;
                    break;
                case 20:
                    int count = count5<count10?count5:count10;
                    if(count < 1){
                        if(count5 < 3){
                            return false;
                        }
                        count5 -= 3;
                    }
                    else{
                        count5--;
                        count10--;
                    }
                    count20++;
                    break;
            }
        }
        return true;
    }
};