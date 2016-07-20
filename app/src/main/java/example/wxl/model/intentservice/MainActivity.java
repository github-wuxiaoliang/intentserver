package example.wxl.model.intentservice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private ThreadLocal<String> mThreadLocal = new ThreadLocal<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mThreadLocal.set("thread-main");
        Log.d(TAG, "onCreate: " + mThreadLocal.get());

        new Thread("thread-1") {
            @Override
            public void run() {
                mThreadLocal.set("thread-1");
                Log.d(TAG, "run: " + mThreadLocal.get());
                super.run();
            }
        }.start();
        new Thread("thread-2") {
            @Override
            public void run() {
                Log.d(TAG, "run: " + mThreadLocal.get());
            }
        }.start();
    }

    public void startIntentService(View view) {
        Intent intent = new Intent(this, MyIntentService.class);
        intent.putExtra("url", "http://wwww.wxl.com/?xxx");
        startService(intent);
    }
    public void startSecondAct(View v) {
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("url", "http://wwww.wxl.com/?xxx");
        startActivity(intent);
    }

    public void startThird(View v) {
        Intent intent = new Intent(this, ThirdActivity.class);
        intent.putExtra("url", "http://wwww.wxl.com/?xxx");
        startActivity(intent);
    }
}
