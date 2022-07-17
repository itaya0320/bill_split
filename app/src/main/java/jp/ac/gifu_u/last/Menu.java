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

    private List<String> viewdatas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        for(int i = 0 ; i < Register.data.size() ; i++) {
            viewdatas.add(Register.data.get(i).way + ":" + Register.data.get(i).name + "が" + Register.data.get(i).money + "円");
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,viewdatas);
        ListView listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        startActivity(new Intent(getApplication(), EditPlus.class).putExtra("number",i));
                    }
                }
        );

        final Button imageProductButton = (Button) findViewById(R.id.button4);
        imageProductButton.setOnClickListener((
                        View view2) -> {
                    startActivity(new Intent(getApplication(), Plus.class));
                }
        );
    }

    private void calculate(){
        int cnt = 0;
        List<Integer> all = new ArrayList<>();
        for(int i = 0; i < Register.people.size() ; i++){
            for(int j = 0; j < Register.data.size() ; j ++){
                if (Register.data.get(j).name == Register.people.get(i)){
                    cnt += Integer.valueOf(Register.data.get(j).money);
                }
            }
            all.add(cnt);
            all.add(Register.people);
            cnt = 0;
        }
    }
}