package com.example.a8teammobileclient.ui;

        import android.os.Bundle;
        import android.widget.EditText;
        import android.widget.ImageView;
        import android.widget.TextView;

        import androidx.annotation.Nullable;
        import androidx.appcompat.app.AppCompatActivity;

        import com.example.a8teammobileclient.R;

public class ProfileActivity extends AppCompatActivity {

    TextView userNameTV, userEmailTV;
    ImageView userImgV;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        userNameTV = findViewById(R.id.userNameTextView);
        userEmailTV = findViewById(R.id.userEmailTextView);
        userImgV = findViewById(R.id.userImageView);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
