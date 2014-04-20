var exec = require('cordova/exec');

module.exports = function(successCallback, errorCallback){
	return exec(successCallback, errorCallback, "AppInfo", "getInfo", []);
};