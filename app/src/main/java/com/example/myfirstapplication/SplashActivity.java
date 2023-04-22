package com.example.myfirstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.WindowManager;

public class SplashActivity extends AppCompatActivity {
    private Handler handler = new Handler();
    private Runnable runnableToMainActivity = new Runnable() {
        @Override
        public void run() {
            toMainActivity();
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        //this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //WindowInsetsController controller = getWindow().getInsetsController();
       // controller.hide(WindowInsets.Type.statusBars());

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                        WindowManager.LayoutParams.
                                FLAG_FULLSCREEN);
        handler.postDelayed(runnableToMainActivity,3000);
    }
    private void toMainActivity() {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        //防止内存泄漏
        handler.removeCallbacks(runnableToMainActivity);
    }
}