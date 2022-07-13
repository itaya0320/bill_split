package jp.ac.gifu_u.last;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Menu extends AppCompatActivity{

    private List<String> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        list = getIntent().getStringArrayListExtra("key1");

        List<List<String>> list4 = new ArrayList<>();
        List<String> in_list = new ArrayList<String>();

        in_list.add("1000");
        in_list.add("aaa");

        list4.add(in_list);


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list4);

        ListView listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Toast.makeText(Menu.this, "ok", Toast.LENGTH_SHORT).show();
                    }
                }
        );


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