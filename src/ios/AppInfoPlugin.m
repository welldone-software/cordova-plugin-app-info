#import "AppInfoPlugin.h"

#import <Cordova/CDVPluginResult.h>

@implementation AppInfoPlugin

- (void)getInfo:(CDVInvokedUrlCommand *)command
{
    
    NSString* version = NSBundle.mainBundle.infoDictionary[@"CFBundleShortVersionString"];
    NSString* name = NSBundle.mainBundle.infoDictionary[(NSString *)kCFBundleNameKey];
    
    NSString * displayName = NSBundle.mainBundle.infoDictionary[@"CFBundleDisplayName"];
    BOOL debug = NO;
#ifdef DEBUG
    debug = YES;
#endif
    
    NSMutableDictionary* props = [NSMutableDictionary dictionaryWithCapacity:4];
    
    [props setObject:name forKey:@"name"];
    [props setObject:displayName forKey:@"displayName"];
    [props setObject:version forKey:@"version"];
    [props setObject:[NSNumber numberWithBool:debug] forKey:@"debug"];
    
    CDVPluginResult* pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsDictionary:props];
    [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
}

@end