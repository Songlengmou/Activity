package com.example.syp.startactivitywithargs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class ActivityB extends AppCompatActivity {
    private TextView textView;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);

        textView = (TextView) findViewById(R.id.tv_activityB);
        editText = (EditText) findViewById(R.id.et_B);

        CharSequence data = getIntent().getCharSequenceExtra("data");
        textView.setText(data);

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("result", editText.getText());
        setResult(0, intent);

        super.onBackPressed();
    }
}
