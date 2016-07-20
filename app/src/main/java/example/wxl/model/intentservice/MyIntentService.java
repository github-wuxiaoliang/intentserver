package example.wxl.model.intentservice;

import android.app.IntentService;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;

/**
 * Created on 2016/7/16.
 *
 * @author wuxiaoliang
 * @since 1.0
 */
public class MyIntentService extends IntentService {
    private static final String TAG = "MyIntentService";

    public MyIntentService() {
        this("MyTHread");
    }

    public MyIntentService(String name) {
        super(name);
    }
    public Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.d(TAG, "onHandleIntent: " + Thread.currentThread().getName());
        String url = intent.getStringExtra("url");
        Log.d(TAG, "onHandleIntent:开始下载 " + url);
        SystemClock.sleep(5000);
        Log.d(TAG, "onHandleIntent: 下载完毕");

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }
}
