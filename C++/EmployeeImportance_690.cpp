/*
// Employee info
class Employee {
public:
    // It's the unique ID of each node.
    // unique id of this employee
    int id;
    // the importance value of this employee
    int importance;
    // the id of direct subordinates
    vector<int> subordinates;
};
*/
class Solution {
public:
    int getImportance(vector<Employee*> employees, int id) {
        Employee* start = findTargetEmployee(employees, id);
        if(!start){
            return 0;
        }
        int importance = start->importance;
        vector<int> idStack(start->subordinates.begin(), start->subordinates.end());
        while(!idStack.empty()){
            int currentId = idStack[0];
            idStack.erase(idStack.begin());
            start = findTargetEmployee(employees, currentId);
            if(start){
                importance += start->importance;
                for(int i=0; i<start->subordinates.size(); i++){
                    idStack.push_back(start->subordinates[i]);
                }
            }
        }
        return importance;
    }

    Employee* findTargetEmployee(vector<Employee*> employees, int id){
        int length = employees.size();
        for(int i=0; i<length; i++){
            if(employees[i]->id == id){
                return employees[i];
            }
        }
        return NULL;
    }
};