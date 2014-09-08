package de.appplant.cordova.plugin.localnotification;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class ReceiverCancel extends BroadcastReceiver {
	
    public static final String OPTIONS = "LOCAL_NOTIFICATION_OPTIONS";
	
    private Context context;
    private Options options;
    
	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub

		Options options = null;
        Bundle bundle   = intent.getExtras();
        JSONObject args;

        try {
            args    = new JSONObject(bundle.getString(OPTIONS));
            options = new Options(context).parse(args);
        } catch (JSONException e) {
            return;
        }

        this.context = context;
        this.options = options;
		
		int id = 0;
		id = Integer.parseInt(options.getId());
        
        NotificationManager mgr = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        //AlarmManager alarmManager = LocalNotification.getAlarmManager();
        //PendingIntent pi       = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);
        
        //alarmManager.cancel(pi);
        
        try {
            mgr.cancel(id);
        } catch (Exception e) {}
	}

}
