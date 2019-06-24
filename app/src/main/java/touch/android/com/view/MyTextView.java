package touch.android.com.view;


import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

public class MyTextView extends android.support.v7.widget.AppCompatTextView {

    private static final String TAG = "MytextView";

    public MyTextView(Context context) {
        super(context);
    }

    public MyTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
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
        return super.dispatchTouchEvent(event); //此处view是最小的组件单元所以不会继续分发是默认super方法
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
        return super.onTouchEvent(event);  //返回super或者true，表示消费了改事件，Action的行为传递完成。如果返回false，则由外层来消费事件
    }
}
