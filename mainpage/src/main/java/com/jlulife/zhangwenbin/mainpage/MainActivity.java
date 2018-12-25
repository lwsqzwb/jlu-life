package com.jlulife.zhangwenbin.mainpage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.jlulife.zhangwenbin.mainpage.network.NetAPI;
import com.jlulife.zhangwenbin.netapi.listener.IRequestListener;
import com.jlulife.zhangwenbin.netapi.result.ResponseData;

public class MainActivity extends AppCompatActivity {

    private Button mButton;
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mButton = findViewById(R.id.bt_get_msg);
        mTextView = findViewById(R.id.tv_msg);


        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NetAPI.requestMsg(new IRequestListener() {
                    @Override
                    public void success(ResponseData responseData) {
                        mTextView.setText(responseData.getData());
                    }

                    @Override
                    public void fail(ResponseData responseData) {

                    }
                });
            }
        });
    }
}
