/**
 * @param {Array} arr1
 * @param {Array} arr2
 * @return {Array}
 */
var join = function(arr1, arr2) {
    let x = new Map();
    for(let i=0;i<arr1.length;i++){
        x.set(arr1[i]["id"], i);
    }
    for(let i=0;i < arr2.length;i++){
        let j =x.get(arr2[i]["id"]);
        if(x.has(arr2[i]["id"])){
            arr1[j] = {...arr1[j],...arr2[i]};
        } else {
            arr1.push(arr2[i]);
        }
    }
    arr1.sort((a,b)=>(a["id"]-b["id"]));
    return arr1;
};