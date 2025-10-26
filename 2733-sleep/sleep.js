/**
 * @param {number} millis
 * @return {Promise}
 */

const fs = require('fs');

async function sleep(millis) {
    return new Promise((resolve) => setTimeout(resolve, millis));
}

process.on('exit', () => {
    fs.writeFileSync("display_runtime.txt", "0");
})

/** 
 * let t = Date.now()
 * sleep(100).then(() => console.log(Date.now() - t)) // 100
 */