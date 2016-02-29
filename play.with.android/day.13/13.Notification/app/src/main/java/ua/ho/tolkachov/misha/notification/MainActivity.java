package ua.ho.tolkachov.misha.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final int NOTIFY_ID = 101;

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
}
