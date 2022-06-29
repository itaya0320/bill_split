package jp.ac.gifu_u.last;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Register extends AppCompatActivity{

    private String number;
    private LinearLayout box;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        number = (String)getIntent().getSerializableExtra("key");
        setContentView(R.layout.register);
        box = findViewById(R.id.scroll);
        addmoney();
    }
    void addmoney(){
        LinearLayout info = new LinearLayout(this);
        info.setOrientation(LinearLayout.HORIZONTAL);
        EditText mon = new EditText(this);
        mon.setText("金");
        EditText name = new EditText(this);
        name.setText("名前");
        mon.setTextSize(30);
        name.setTextSize(30);
        info.addView(name);
        info.addView(mon);
        box.addView(info);
}
