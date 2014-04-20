cordova-plugin-app-info
===

Get information about the native application wrapping your html app, such as the app version, name, displayName and build (debug/release) status.

Supported platfroms
===
+ Cordova command line >= 3.0.
+ Android and iOS. WP8 is on its way.

Usage
===

```JavaScript
window.cordova.getAppInfo(
	function(info){
    	alert(
    			'Is Debug: ' + info.debug 
    		+ ', Display Name: ' + info.displayName 
    		+ ', Technical Name: ' +  info.name 
    		+ ', Version: ' + info.version
    	);
	}, function(err){
	    alert(err);
	}
);
```

Installation
===
```bash
cordova plugins add 'https://github.com/welldone-software/cordova-plugin-app-info.git'
```

iOS quriks
===
The `debug` property on ios is set at compile time using the preprocessor symbol `DEBUG` as follows.

```ObjC
    BOOL debug = NO;
#ifdef DEBUG
    debug = YES;
#endif
```

If the `DEBUG` preprocessor symbol is not defined in your debug builds, you will always get a value of false.
Please make sure the symbol is available or add it yourself. See [Apple Build Setting Docs on 'Preprocessor Macros'](https://developer.apple.com/library/mac/documentation/DeveloperTools/Reference/XcodeBuildSettingRef/1-Build_Setting_Reference/build_setting_ref.html#//apple_ref/doc/uid/TP40003931-CH3-SW13).

License
===
MIT