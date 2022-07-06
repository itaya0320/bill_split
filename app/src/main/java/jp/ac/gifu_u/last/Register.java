package jp.ac.gifu_u.last;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class Register extends AppCompatActivity {

    private String number;
    private LinearLayout box;
    List<EditText> list = new ArrayList<>();
    List<String> list2 = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        number = (String) getIntent().getSerializableExtra("key");
        setContentView(R.layout.register);
        box = findViewById(R.id.scroll);
        addMoney();
        final Button imageProductButton = (Button) findViewById(R.id.button2);
        imageProductButton.setOnClickListener((View view2) -> {
            for(int count = 0; count < list.size(); count++){
                list2.add(String.valueOf(list.get(count).getText()));
            }
            startActivity(new Intent(getApplication(), Menu.class).putStringArrayListExtra("key1", (ArrayList<String>) list2));
        });
    }

    void addMoney() {
        LinearLayout info = new LinearLayout(this);
        info.setOrientation(LinearLayout.VERTICAL);
        for (int count = 0; count < Integer.valueOf(number); count++) {
            EditText str = new EditText(this);
            str.setTextSize(30);
            info.addView(str);
            list.add(str);
        }
        list.get(0).getText();
        box.addView(info);
    }
}
