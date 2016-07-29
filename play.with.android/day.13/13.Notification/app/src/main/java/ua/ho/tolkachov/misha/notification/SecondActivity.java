package ua.ho.tolkachov.misha.notification;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Misha on 05.06.2016.
 */
public class SecondActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    public void onClickSecond(View v){
        NotificationManager notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        Intent intent = new Intent(this, SecondActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

        if (v.getId() == findViewById(R.id.btnBasicNotification).getId()) {
            Notification builder = new Notification.Builder(this)
                    .setTicker("The parcel is come")
                    .setContentTitle("Parcel")
                    .setContentText("I bring you the parcel!")
                    .setSmallIcon(R.drawable.notification_small)
//                .setSmallIcon(R.mipmap.ic_launcher)
                    .addAction(R.drawable.notification_16, "Open", pendingIntent)
                    .addAction(R.mipmap.ic_launcher, "Dismiss", pendingIntent)
                    .addAction(R.drawable.notification_16, "Other Case", pendingIntent)
                    .setAutoCancel(true)
                    .build();

            builder.flags |= Notification.FLAG_AUTO_CANCEL;
            notificationManager.notify(0, builder);
//------------- LONG TEXT ---------------------------------------------------------------
        }else if (v.getId() == findViewById(R.id.btnBigTextNotification).getId()) {
            String bigText = "The Parcel is come, but I will not give it to you. "
                            + "Because You haven't a passport! ";

            Notification.Builder builder = new Notification.Builder(this)
                    .setTicker("The parcel is arrive")
                    .setContentTitle("The Parcel")
                    .setContentText("I'm Pechkin, the postman. I bring you a package")
                    .setSmallIcon(R.drawable.notification_16)
                    .addAction(R.drawable.notification_16, "run the Activity", pendingIntent)
                    .setAutoCancel(true);

            Notification notification = new Notification.BigTextStyle(builder)
                    .bigText(bigText)
                    .build();

            notificationManager.notify(1, notification);
//----------- BIG PICTURE -----------------------------------------------------------------
        }else if (v.getId() == findViewById(R.id.btnBigPictureNotification).getId()) {
            Notification.Builder builder = new Notification.Builder(this);
            builder.setContentTitle("Big Package")
                   .setTicker("THe Package is arrive")
                   .setContentText("the message with LARGE image")
                   .setSmallIcon(R.mipmap.ic_launcher)
                   .addAction(R.drawable.notification_16, "just Run", pendingIntent);

            Notification notification = new Notification.BigPictureStyle(builder)
                    .bigPicture(BitmapFactory.decodeResource(getResources(), R.drawable.shrek))
                    .build();

            notification.flags |= Notification.FLAG_AUTO_CANCEL;
            notificationManager.notify(2, notification);


//----------------------------------------------------------------------------
        }else if (v.getId() == findViewById(R.id.btnInboxStyleNotification).getId()) {
            Notification.Builder builder = new Notification.Builder(this)
                    .setTicker("The Package is come")
                    .setContentTitle("the message in the Inbox style")
                    .setContentText("Inbox style Notification!")
                    .setSmallIcon(R.drawable.notification_32)
                    .addAction(R.drawable.notification_16, "Run Inbox intent", pendingIntent)
                    .setPriority(Notification.PRIORITY_MAX);

            Notification notification = new Notification.InboxStyle(builder)
                    .addLine("First Line")
                    .addLine("Second Line")
                    .addLine("Third Line")
                    .addLine("Fours Line")
                    .setSummaryText("+5 more")
                    .build();
            notification.flags |= Notification.FLAG_AUTO_CANCEL;
            notificationManager.notify(3, notification);
        }

    }
}
