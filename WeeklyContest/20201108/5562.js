/**
 * @param {string} s
 * @return {number}
 */
var minDeletions = function(s) {
    let record = new Array(26);
    for(let i=0; i<26; i++){
        record[i] = 0;
    }
    let base = 'a'.charCodeAt(0);
    for(let i=0; i<s.length; i++){
        let c = s.charCodeAt(i) - base;
        record[c]++;
    }
    let obj = {};
    let repeated = {};
    let flag = {};
    for(let i=0; i<26; i++){
        let key = record[i];
        if(key < 1){
            continue;
        }
        if(obj[key]){
            obj[key]++; 
            repeated[key] = obj[key]-1;
        }
        else {
            obj[key] = 1;
            flag[key] = 1;
        }
    }
    let keys = Object.keys(repeated);
    if(keys.length < 1){
        return 0;
    }
    keys.sort((a, b) => a-b);
    let index = 0, count = 0;
    for(let i=0; i<keys.length; i++){
        let num = repeated[keys[i]];
        for(let k=0; k<num; k++){
            for(let m=keys[i]-1; m>=0; m--){
                if(!flag[m]){
                    count += (keys[i] - m);
                    if(m > 0){
                        flag[m] = 1;
                    }
                    break;
                }
            }
        }
    }
    return count;
};