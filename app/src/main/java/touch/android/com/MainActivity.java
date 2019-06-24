package touch.android.com;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import touch.android.com.view.MyTextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnTouchListener {
    private MyTextView textView;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.mytextview);
        textView.setOnClickListener(this);
        textView.setOnTouchListener(this);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.d(TAG, "dispatchTouchEvent: MotionEvent.ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.d(TAG, "dispatchTouchEvent: MotionEvent.ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.d(TAG, "dispatchTouchEvent: MotionEvent.ACTION_UP");
                break;
        }
        return super.dispatchTouchEvent(ev);  //如果没有返回super方法，无论是返回的是true，还是false,都不在继续分发事件
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.d(TAG, "onTouchEvent: MotionEvent.ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.d(TAG, "onTouchEvent: MotionEvent.ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.d(TAG, "onTouchEvent: MotionEvent.ACTION_UP");
                break;
        }
        return super.onTouchEvent(event);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.mytextview:
                Log.d(TAG, "onClick: MyTextVIiew clik");
                break;
        }

    }


    /**
     *如果组件在此处将事件提前消费掉（即返回是true），则内层view将不会收到这个事件
     * */
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (v.getId()) {
            case R.id.mytextview:
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        Log.d(TAG, "MianActivity onTouch action_down");
                        break;
                    case MotionEvent.ACTION_UP:
                        Log.d(TAG, "MianActivity onTouch action_up");
                        break;
                    case MotionEvent.ACTION_MOVE:
                        Log.d(TAG, "MianActivity onTouch action_move");
                        break;
                }
                break;
        }
        return false;  //返回true 不在继续分发action_down事件，不会出发点mytextview击事件
    }
}
