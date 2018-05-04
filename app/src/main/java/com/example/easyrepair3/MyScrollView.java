package com.example.easyrepair3;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ScrollView;

/**
 * Created by Administrator on 2016/4/13.
 */
public class MyScrollView extends ScrollView {
    public MyScrollView(Context context) {
        super(context);
    }

    public MyScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        View view = (View) getChildAt(getChildCount() - 1);
        if (null != scrollingListener) {
            scrollingListener.onScrolling(l, t, oldl, oldt);
        }
        int d = view.getBottom();
        d -= (getHeight() + getScrollY());
        if (d == 0) {
            //������:���Ѿ�����scrollView�ײ�,��дʲô��д��...
            if (null != scrollToEndListener) {
                scrollToEndListener.onScrollToEnd();
            }
        } else {
            super.onScrollChanged(l, t, oldl, oldt);
        }
    }

    ScrollToEndListener scrollToEndListener;

    ScrollingListener scrollingListener;

    public void setScrollingListener(ScrollingListener scrollingListener) {
        this.scrollingListener = scrollingListener;
    }

    public void setScrollToEndListener(ScrollToEndListener scrollToEndListener) {
        this.scrollToEndListener = scrollToEndListener;
    }

    public interface ScrollToEndListener {
        void onScrollToEnd();
    }

    public interface ScrollingListener {
        void onScrolling(int l, int t, int oldl, int oldt);
    }
}