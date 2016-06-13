package com.example.qiang_pc.slidingmenustatusbar;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            setViewHeight();
        }
    }

    private void setViewHeight() {
        View view_content = findViewById(R.id.view_content);
        view_content.setBackgroundColor(Color.parseColor("#3F51B5"));
        ViewGroup.LayoutParams content_params = view_content.getLayoutParams();
        content_params.height = getStatusBarHeight(this);
        view_content.setLayoutParams(content_params);

        View view_menu = findViewById(R.id.view_menu);
        view_menu.setBackgroundColor(Color.parseColor("#FF4081"));
        ViewGroup.LayoutParams menu_params = view_menu.getLayoutParams();
        menu_params.height = getStatusBarHeight(this);
        view_menu.setLayoutParams(menu_params);
    }

    /**
     * 获取状态栏的高度
     * @param acitivity
     * @return
     */
    private static int getStatusBarHeight(Activity acitivity){

        int resourceId = acitivity.getResources().getIdentifier("status_bar_height", "dimen", "android");

        return acitivity.getResources().getDimensionPixelOffset(resourceId);
    }
}
