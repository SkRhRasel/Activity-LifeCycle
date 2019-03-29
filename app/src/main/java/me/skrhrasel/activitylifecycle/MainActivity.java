package me.skrhrasel.activitylifecycle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        notify("From onCreate method");
    }

    @Override
    protected void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
        notify("From onStart method");
    }

    @Override
    protected void onStop() {
        // TODO Auto-generated method stub
        super.onStop();
        notify("From onStop method");
    }

    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
        notify("From onDestroy method");
    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        notify("From onPause method");
    }

    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
        notify("From onResume method");
    }

    @Override
    protected void onRestart() {
        // TODO Auto-generated method stub
        super.onRestart();
        notify("From onRestart method");
    }

    public void notify(String methodName) {
        String name = this.getClass().getName();
        String[] strings = name.split("\\.");
        Notification noti = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN) {
            noti = new Notification.Builder(this)
                    .setContentTitle(methodName + "  " + strings[strings.length - 1]).setAutoCancel(true)
                    .setSmallIcon(R.drawable.ic_launcher_background).setContentText(name).build();
        }
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify((int) System.currentTimeMillis(), noti);
    }


}
