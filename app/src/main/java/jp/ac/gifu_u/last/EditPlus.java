package jp.ac.gifu_u.last;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class EditPlus extends AppCompatActivity {

    private Plusdata plusdata = new Plusdata();
    private int number;
    private List<String> people2 = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_plus);
        Spinner nameselecter = (Spinner) findViewById(R.id.nameselecter);
        EditText editway = findViewById(R.id.editway);
        EditText editTextNumber = findViewById(R.id.editTextNumber);
        Button button = findViewById(R.id.button_plus);
        number = (Integer) getIntent().getSerializableExtra("number");
        people2 = Register.people;
        for(int i = 0;i < people2.size();i++){
            if(people2.get(i) == Register.data.get(number).name){
                people2.add(0,people2.get(i));
                people2.remove(i+1);
                break;
            }
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        for(String name : people2){
            adapter.add(name);
        }

        nameselecter.setAdapter(adapter);

        editway.setText(Register.data.get(number).way);
        editTextNumber.setText(Register.data.get(number).money);

        button.setOnClickListener(view -> {
            if(editTextNumber.getText().toString().equals("")){
                Toast.makeText(this, "料金を入力してください", Toast.LENGTH_SHORT).show();
            }
            else {
                plusdata.name = nameselecter.getSelectedItem().toString();
                plusdata.way = editway.getText().toString();
                plusdata.money = editTextNumber.getText().toString();
                Register.data.set(number, plusdata);
                startActivity(new Intent(getApplication(), Menu.class));
            }
        });


    }
}