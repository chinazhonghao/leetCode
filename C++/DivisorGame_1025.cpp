class Solution {
public:
    bool divisorGame(int N) {
        bool flag[1001];
        memset(flag, 0, sizeof(flag));
        for(int i=2; i<=N; i++){
        	for(int j=1; j<sqrt(i); j++){
        		if(i % j == 0 && !flag[i-j]){
        			flag[i] = true;
        			break;
        		}
        	}
        }
        return flag[N];
    }
};