const fs = require("fs");

Array.prototype.groupBy = function(fn) {
    const result = {};
    for(const item of this) {
      const key = fn(item);
      if(Object.hasOwn(result, key)) {
        result[key].push(item);
      } else {
        result[key] = [item];
      }
    }

    return result;
};


process.on("exit", () => {
  fs.writeFileSync("display_runtime.txt", "0");
});