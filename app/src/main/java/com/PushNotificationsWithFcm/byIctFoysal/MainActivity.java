package com.PushNotificationsWithFcm.byIctFoysal;


import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;

public class MainActivity extends AppCompatActivity {

    private final String TAG = "MainActivity";
    private static final String TOPIC_GLOBAL = "global";
    TextView HelloWorld;
    private EditText textField, etTitle, etMessage, etArticleData, etImageUrl;
    private Button button, btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI elements
        button = findViewById(R.id.button);
        textField = findViewById(R.id.textField);
        HelloWorld = findViewById(R.id.Hello_World);
        etTitle = findViewById(R.id.etTitle);
        etMessage = findViewById(R.id.etMessage);
        etArticleData = findViewById(R.id.etArticleData);
        etImageUrl = findViewById(R.id.etImageUrl);
        btnSend = findViewById(R.id.btnSend);

        // Set click listener for the button
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textfieldData = textField.getText().toString().trim();
                HelloWorld.setText(textfieldData);
            }
        });

        // Get FCM registration token
        FirebaseMessaging.getInstance().getToken().addOnCompleteListener(new OnCompleteListener<String>() {
            @Override
            public void onComplete(Task<String> task) {
                if (!task.isSuccessful()) {
                    Log.w(TAG, "Fetching FCM registration token failed", task.getException());
                    return;
                }

                String token = task.getResult();
                Log.d(TAG, "FCM registration token: " + token);
                // firebaseId.setText(token);
            }
        });

        // Subscribe to the global topic
        FirebaseMessaging.getInstance().subscribeToTopic(TOPIC_GLOBAL).addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                Log.d(TAG, "Global topic subscription successful");
            } else {
                Log.e(TAG, "Global topic subscription failed. Error: " + task.getException().getLocalizedMessage());
            }
        });

        // Set click listener for the send button
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendNotification();
            }
        });
    }

    // Method to send a test push notification
    private void sendNotification() {
        final String title = etTitle.getText().toString();
        final String message = etMessage.getText().toString();
        final String articleData = etArticleData.getText().toString();
        final String imageUrl = etImageUrl.getText().toString();

        // Construct the notification URL with the entered data
        String url = "https://ict.foysalofficial.com/fcm/send_notification.php" +
                "?title=" + title +
                "&message=" + message +
                "&article_data=" + articleData +
                "&image_url=" + imageUrl +
                "&push_type=topic";

        // Execute the HTTP request to send the notification
        HttpRequestHelper httpRequestHelper = new HttpRequestHelper();
        httpRequestHelper.execute(url);
    }

}