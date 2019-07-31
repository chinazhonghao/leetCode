class Solution {
public:
    int calPoints(vector<string>& ops) {
        stack<int> points;
        int length = ops.size();
        for(int i=0; i<length; i++){
            string current = ops[i];
            switch(current[0]){
                case 'C':
                    if(!points.empty()){
                        points.pop();
                    }
                    break;
                case 'D':
                {
                    int p = 0;
                    if(!points.empty()){
                        p = points.top() * 2;
                    }
                    points.push(p);
                    break;
                }
                case '+':
                {
                    int p1 = 0;
                    if(!points.empty()){
                        p1 = points.top();
                        points.pop();
                    }
                    int p2 = 0;
                    if(!points.empty()){
                        p2 = points.top();
                        points.pop();
                    }
                    int p3 = p1 + p2;
                    points.push(p2);
                    points.push(p1);
                    points.push(p3);
                }
                    break;
                default:
                {
                    int point = atoi(current.c_str());
                    points.push(point);
                }
                    break;
            }
        }
        int sum = 0;
        while(!points.empty()){
            sum += points.top();
            points.pop();
        }
        return sum;
    }
};