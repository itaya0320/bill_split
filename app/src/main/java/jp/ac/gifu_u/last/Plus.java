package jp.ac.gifu_u.last;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class Plus extends AppCompatActivity {

    private Plusdata plusdata = new Plusdata();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plus);
        Spinner nameselecter = (Spinner) findViewById(R.id.nameselecter);
        EditText editway = findViewById(R.id.editway);
        EditText editTextNumber = findViewById(R.id.editTextNumber);
        Button button = findViewById(R.id.button_plus);


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        for(String name : Register.people){
            adapter.add(name);
        }

        nameselecter.setAdapter(adapter);

        button.setOnClickListener(view -> {
            plusdata.name=nameselecter.getSelectedItem().toString();
            plusdata.way=editway.getText().toString();
            plusdata.money=editTextNumber.getText().toString();
            Register.data.add(plusdata);
            startActivity(new Intent(getApplication(),Menu.class));
        });
    }
}
