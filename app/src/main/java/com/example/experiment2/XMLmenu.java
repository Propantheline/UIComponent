package com.example.experiment2;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/*
参考
https://blog.csdn.net/qq_43377749/article/details/85104965
https://developer.android.google.cn/guide/topics/ui/menus
 */
public class XMLmenu extends AppCompatActivity {

    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xmlmenu);
        textView = findViewById(R.id.test);
        registerForContextMenu(textView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = new MenuInflater(this);
        //装填R.Menu.my_menu菜单，并添加到menu中
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //菜单项被单击后的回调方法

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.isCheckable()) {
            //勾选菜单项
            item.setCheckable(true);
        }
        //switch 判断单击哪个菜单项，并有针对性的做出响应
        switch (item.getItemId()) {
            case R.id.small:
                textView.setTextSize(10 * 2);
                break;

            case R.id.medium:
                textView.setTextSize(16 * 2);
                break;
            case R.id.large:
                textView.setTextSize(20 * 2);
                break;
            case R.id.red_font:
                textView.setTextColor(Color.RED);
                break;
            case R.id.black_font:
                textView.setTextColor(Color.BLACK);
                break;
            case R.id.simple:
                Toast.makeText(XMLmenu.this,"这是普通选择项",Toast.LENGTH_SHORT).show();
        }
        return true;
    }

}
