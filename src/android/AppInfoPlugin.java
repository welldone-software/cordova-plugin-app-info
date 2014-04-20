package welldonesoftware.cordova.plugins.appInfo;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

public class AppInfoPlugin extends CordovaPlugin {
	@Override
	public boolean execute(String action, JSONArray args,
			CallbackContext callbackContext) throws JSONException {
		if (action.equals("getInfo")) {

			Activity activity = this.cordova.getActivity();
			PackageManager packageManager = activity.getPackageManager();
			
			try {
				PackageInfo packageInfo = packageManager.getPackageInfo(activity.getPackageName(), 0);
				
				Class<?> buildConfigClass = Class.forName(packageInfo.packageName + ".BuildConfig");
				boolean debug = buildConfigClass.getField("DEBUG").getBoolean(null);
				
				JSONObject result = new JSONObject();
				
				result.put("version", packageInfo.versionName);
				result.put("name", activity.getPackageName());
				result.put("displayName", packageManager.getApplicationLabel(packageInfo.applicationInfo));
				result.put("debug", debug);
				
				callbackContext.success(result);
				
			} catch (Exception e) {
				e.printStackTrace();
				callbackContext.error(e.getMessage());
			}
			
			return true;
		}
		
		return false;
	}
}
