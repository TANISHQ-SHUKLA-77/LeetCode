/**
 * @param {Array} arr
 * @param {number} depth
 * @return {Array}
 */

 function flatten(el, arrRes, n, curN){
    if(!Array.isArray(el) || curN > n){
        arrRes.push(el);
    } else {
        curN++;
        for(let i=0; i< el.length;i++){
            flatten(el[i], arrRes, n, curN);
        }
        curN--;
    }
    return;
 }

var flat = function (arr, n) {
    var curN = 1;
    var arrRes = [];

    for(let i=0; i<arr.length; i++){
        flatten(arr[i], arrRes, n, curN);
    }

    return arrRes;

};