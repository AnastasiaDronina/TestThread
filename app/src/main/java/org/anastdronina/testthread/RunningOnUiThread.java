package org.anastdronina.testthread;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class RunningOnUiThread extends AppCompatActivity implements View.OnClickListener{

    private Button uiButton, backgroundButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_running_on_ui_thread);

        uiButton = findViewById(R.id.uiButton);
        backgroundButton = findViewById(R.id.backgroundButton);

        uiButton.setOnClickListener(this);
        backgroundButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.uiButton:
                for(int i = 0; i < 10; i++){
                    Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.waterfall);
                }
                break;
            case R.id.backgroundButton:
                Thread thread = new Thread(){
                    @Override
                    public void run() {
                        super.run();
                        for(int i = 0; i < 10; i++){
                            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.waterfall);
                        }
                    }
                };
                thread.start();
                break;
            default:

        }
    }
}
