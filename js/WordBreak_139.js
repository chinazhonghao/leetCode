/**
 * @param {string} s
 * @param {string[]} wordDict
 * @return {boolean}
 */
var wordBreak = function(s, wordDict) {
    let m = {};
    wordDict.forEach(word => m[word] = 1);
    let flags = [], current="";
    for(let i=0; i<s.length; i++){
        flags.push(false);
    }
    for(let i=0; i<s.length;){
        current += s[i++];
        if(m[current] === 1){
            flags[i] = true;
        }
        else {
            for(let j=0; j<i; j++){
                if(flags[j] == true && m[s.substring(j+1, i)]===1){
                    flags[i-1] = true;
                }
            }
        }
    }
    console.log(flags);
    return !!flags[s.length-1];
};