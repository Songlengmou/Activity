package com.example.syp.startactivitywithargs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * 1.Activity中的 Intent 显示跳转  隐式跳转在StartActivityInAnotherApp工程中
 */
public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);
        textView = (TextView) findViewById(R.id.tv_hw);
        findViewById(R.id.btn_activityB).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //new Intent() 里 如果只填this是指 setOnClickListener，而不是指MainActivity，所以不能只填this
                Intent intent = new Intent(MainActivity.this, ActivityB.class);
                intent.putExtra("data", editText.getText());
//                startActivity(intent);

                startActivityForResult(intent, 0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        textView.setText(data.getCharSequenceExtra("result"));
        super.onActivityResult(requestCode, resultCode, data);
    }
}
