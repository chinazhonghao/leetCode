/**
 * @param {string} number
 * @return {string}
 */
var reformatNumber = function(number) {
    var splits = [], index = 0, left = number.length;
    number = number.replace(/\s+|-+/g, '');
    while(index < number.length){
        left = number.length - index;
        if(left > 4){
            splits.push(number.substring(index, index+3));
            index += 3;
        }
        else if(left === 4){
            splits.push(number.substring(index, index+2));
            index += 2;
        }
        else {
            splits.push(number.substring(index, number + left));
            index += left;
        }
    }
    return splits.join('-');
};

console.log(reformatNumber("1-23-45 6"));