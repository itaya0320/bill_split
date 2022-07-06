package jp.ac.gifu_u.last;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Menu extends AppCompatActivity{

    private List<String> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        list = getIntent().getStringArrayListExtra("key1");

        TextView textview3 = findViewById(R.id.textView3);
        textview3.setText(list.get(0));

        final Button imageProductButton = (Button) findViewById(R.id.button4);
        imageProductButton.setOnClickListener((
                        View view2) -> {
                    startActivity(new Intent(getApplication(), Plus.class).putStringArrayListExtra("key2", (ArrayList<String>) list));
                }
        );
    }
}