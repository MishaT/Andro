package ua.ho.tolkachov.misha.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    private static final int NOTIFY_ID = 101;
    private static final int NOTIFY_ID2 = 102;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View v){
        Context context = getApplicationContext();

        Intent notifyIntent = new Intent(context, MainActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(context, 0, notifyIntent, PendingIntent.FLAG_CANCEL_CURRENT);

        Resources res = context.getResources();
        Notification.Builder builder = new Notification.Builder(context);

        builder.setContentIntent(contentIntent)
               .setLargeIcon(BitmapFactory.decodeResource(res, R.drawable.notification_big))
               .setSmallIcon(R.drawable.notification_small)
               .setTicker(res.getString(R.string.notify_ticker))
               .setWhen(System.currentTimeMillis())
               .setAutoCancel(true)
               .setContentTitle(res.getString(R.string.notify_title))
               .setContentText(res.getString(R.string.notify_text))
                ;

        Notification notification = builder.build();
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(NOTIFY_ID, notification);

    }

    public void  onClick2 (View v){
        Context context = getApplicationContext();
        Resources res = context.getResources();

        Intent notifyIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(res.getString(R.string.my_site_address)));
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, notifyIntent, PendingIntent.FLAG_CANCEL_CURRENT);

        Notification.Builder builder = new Notification.Builder(context)
                .setContentTitle(res.getString(R.string.visit_my_site))
                .setContentText(res.getString(R.string.my_site_address))
                .setTicker("Go go!")
                .setWhen(System.currentTimeMillis())
                .setContentIntent(pendingIntent)
               // .setDefaults(Notification.DEFAULT_SOUND)
                .setAutoCancel(true)
                .setSmallIcon(android.R.drawable.stat_sys_upload
                //.setSmallIcon(R.drawable.notification_small
                );


        NotificationManager notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        Notification noti = builder.build();
        noti.flags = noti.flags | Notification.FLAG_INSISTENT;

        notificationManager.notify(NOTIFY_ID2, noti);
    }

    public void  onClickClearNotification(View view){

        NotificationManager notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        if (view.getId() == findViewById(R.id.buttonHideNotification).getId()) {
            notificationManager.cancel(NOTIFY_ID);

        }else if (view.getId() == findViewById(R.id.buttonHideNotification2).getId()) {
            notificationManager.cancel(NOTIFY_ID2);
        }


    }

    public void onClickNewScreen(View v){
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        startActivity(intent);
    }
}
