package jp.ac.gifu_u.last;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Register extends AppCompatActivity{

    private String number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        number = (String)getIntent().getSerializableExtra("key");
        setContentView(R.layout.register);
    }
}
