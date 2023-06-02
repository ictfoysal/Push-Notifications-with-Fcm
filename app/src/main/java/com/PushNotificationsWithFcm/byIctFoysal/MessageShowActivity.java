package com.PushNotificationsWithFcm.byIctFoysal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class MessageShowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_show);

        // receive data from MyFirebaseMessagingService class
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String timeStampString = intent.getStringExtra("timestamp");
        String articleString = intent.getStringExtra("article_data");
        String imageUrl = intent.getStringExtra("image");

        try {
            Picasso.get().load(imageUrl)
                    .placeholder(R.mipmap.ic_launcher_round)
                    .error(R.mipmap.ic_launcher_round)
                    .into((ImageView) findViewById(R.id.featureGraphics));
        } catch (Exception e) {
            e.printStackTrace();
        }

        TextView titleTV = findViewById(R.id.header);
        titleTV.setText(title);
        TextView timeStampStringTv = findViewById(R.id.timeStamp);
        timeStampStringTv.setText(timeStampString);
        TextView articleStringtv =  findViewById(R.id.article);
        articleStringtv.setText(articleString);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) onBackPressed();

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(MessageShowActivity.this,MainActivity.class));
        finish();
    }
}