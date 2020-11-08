/**
 * @param {number[]} inventory
 * @param {number} orders
 * @return {number}
 */
var maxProfit = function(inventory, orders) {
    const max = 1000000007;
    let currentOrder = 0, count = 0, index=1;
    inventory.sort((a, b) => b - a);
    while(currentOrder < orders){
        let diff = inventory[0], left = orders - currentOrder, length = index;
        if(index < inventory.length){
            diff = inventory[0] - inventory[index];
            index++;
        }
        let need = parseInt(left/length);
        let needLeft = left - need * length;
        if(diff > need){
            currentOrder += need * length;
            let tmp = _cal(inventory[0], need) * length % max;
            inventory[0] -= need;
            count = (count + tmp) % max;
        }
        else {
            currentOrder += diff * length;
            let tmp = _cal(inventory[0], diff) * length % max;
            inventory[0] -= diff;
            count = (count + tmp) % max;
        }
        if(needLeft > 0 && length === inventory.length){
            currentOrder += needLeft;
            count = (count + inventory[0] * needLeft) % max;
            break;
        }
    }

    function _cal(a, b){
        a = a % max;
        b = b % max;
        return ((((a + (a - b + 1)) * b) % max) / 2);
    }
    return count;
};