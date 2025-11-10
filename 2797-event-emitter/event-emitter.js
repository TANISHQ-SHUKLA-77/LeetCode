const fs = require('fs');

class EventEmitter {
    
    /**
     * @param {string} eventName
     * @param {Function} callback
     * @return {Object}
     */
    eventMap = {};
    subscribe(eventName, callback) {
      if (!this.eventMap[eventName]) {
        this.eventMap[eventName]= new Set();
      }
      this.eventMap[eventName].add(callback);
        return {
            unsubscribe: () => {
              this.eventMap[eventName].delete(callback);
            }
        };
    }
    
    /**
     * @param {string} eventName
     * @param {Array} args
     * @return {Array}
     */
    emit(eventName, args = []) {
      const res = [];

      (this.eventMap[eventName] ?? []).
        forEach((cb) => res.push(cb(...args)));
      return res;
        
    }
}

process.on('exit', ()=> {
    fs.writeFileSync("display_runtime.txt", "0")
})