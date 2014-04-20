#import <Cordova/CDVPlugin.h>

@interface AppInfoPlugin : CDVPlugin
- (void) getInfo:(CDVInvokedUrlCommand*)command;
@end
