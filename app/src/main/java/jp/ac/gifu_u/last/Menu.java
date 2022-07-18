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
import java.util.Collections;
import java.util.List;

public class Menu extends AppCompatActivity{

    private List<String> viewdatas = new ArrayList<>();
    private List<Movemoney> list_movemoney = new ArrayList<>();
    private List<String> viewdatas2 = new ArrayList<>();


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

        if(!Register.data.equals(null)){
            calculate();
        }


        for(int i = 0 ; i < list_movemoney.size() ; i++) {
            viewdatas2.add(list_movemoney.get(i).lower + "が" + list_movemoney.get(i).upper + "に" + list_movemoney.get(i).balance +"円払う");
        }

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,viewdatas2);
        ListView resultlist = (ListView)findViewById(R.id.resultlist);
        resultlist.setAdapter(adapter2);

    }

    private void calculate(){
        int cnt = 0;
        int cnt_all = 0;
        int balance = 0;
        Calculatedata calculatedata = new Calculatedata();
        List<Calculatedata> all = new ArrayList<>();
        Movemoney movemoney = new Movemoney();
        for(int i = 0; i < Register.people.size() ; i++){
            for(int j = 0; j < Register.data.size() ; j ++){
                if (Register.data.get(j).name == Register.people.get(i)){
                    cnt += Integer.valueOf(Register.data.get(j).money);
                }
            }
            cnt_all += cnt;
            calculatedata.name=Register.people.get(i);
            calculatedata.money=cnt;
            all.add(calculatedata);
            cnt = 0;
            calculatedata = new Calculatedata();
        }
        for(int i = 0; i < all.size(); i++){
            all.get(i).money -= cnt_all/Register.people.size();
        }
        while(true){
            Collections.sort(all, new Compare());
            balance = Math.min(all.get(0).money,Math.abs(all.get(Register.people.size()-1).money));
            if(balance == 0){
                break;
            }
            all.get(Register.people.size()-1).money += balance;
            all.get(0).money -= balance;
            movemoney.upper = all.get(0).name;
            movemoney.lower = all.get(Register.people.size()-1).name;
            movemoney.balance = balance;
            list_movemoney.add(movemoney);
            movemoney = new Movemoney();
        }

    }
}