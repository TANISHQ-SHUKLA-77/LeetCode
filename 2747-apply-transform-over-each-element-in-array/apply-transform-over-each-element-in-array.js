/**
 * @param {number[]} arr
 * @param {Function} fn
 * @return {number[]}
 */

//  const fs = require('fs');
 
var map = function(arr, fn) {
    
    const ans = [];

    for(let i=0; i< arr?.length; i++) ans[i] = fn(arr[i], i);

    return ans;

}

// process.on('exit', () => {
//     fs.writeFileSync("display_runtime.txt", "0");
// });