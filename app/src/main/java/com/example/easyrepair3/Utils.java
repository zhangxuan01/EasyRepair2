package com.example.easyrepair3;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

/**
 * Created by wubin on 2017/2/21.
 */

public class Utils {
    /**
     * ��pxֵת��Ϊdip��dpֵ����֤�ߴ��С����
     */
    public static int px2dip(Context context, float pxValue) {
        //scale   ��DisplayMetrics��������density��
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * ��dip��dpֵת��Ϊpxֵ����֤�ߴ��С����
     */
    public static int dip2px(Context context, float dipValue) {
        //scale    ��DisplayMetrics��������density��
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }

    /**
     * ��pxֵת��Ϊspֵ����֤���ִ�С����
     */
    public static int px2sp(Context context, float pxValue) {
        //fontScale ��DisplayMetrics��������scaledDensity��
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (pxValue / fontScale + 0.5f);
    }

    /**
     * ��spֵת��Ϊpxֵ����֤���ִ�С����
     */
    public static int sp2px(Context context, float spValue) {
        //fontScale ��DisplayMetrics��������scaledDensity��
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }

    public static void initToolbar(AppCompatActivity activity, Toolbar toolbar, String title, String subTitle, int resIcon, Drawable icon) {

        toolbar.setTitle(title);
        toolbar.setSubtitle(subTitle);

        activity.setSupportActionBar(toolbar);

        if (resIcon != 0) {
            toolbar.setNavigationIcon(resIcon);
            return;
        }
        toolbar.setNavigationIcon(icon);
    }
}
