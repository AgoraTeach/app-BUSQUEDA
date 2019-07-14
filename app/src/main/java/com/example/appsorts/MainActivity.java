package com.example.appsorts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ArrayList<ItemList>  mItemlist;
    private ArrayList<ItemList>  orderlist;
    private ArrayList<ItemList>  searchitem;
    private ListAdapter mListAdaper;
    private ListAdapter orderListAdapter;
    String[] Apellidos = new String[] {"Gutierrez","Lee","Sotelo", "Quispe" , "Mamani", "Castillo", "Boza","Mendoza","Melendez"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        setContentView(R.layout.activity_main);
        initlist(Apellidos);
        mListAdaper = new ListAdapter(this,mItemlist);
        final ListView listView = (ListView) findViewById(R.id.listview);
        Button button = (Button) findViewById(R.id.button);
        SearchView searchView = (SearchView) findViewById(R.id.searchView);
        listView.setAdapter(mListAdaper);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<String> order  = new ArrayList<>();
                for (String element: Apellidos ) {
                    order.add(element);
                }
                Collections.sort(order);
                orderlist = new ArrayList<>();
                for (String element : order ) {
                    orderlist.add(new ItemList(element));
                }
                orderListAdapter = new ListAdapter(MainActivity.this,orderlist);
                listView.setAdapter(orderListAdapter);
                }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                Toast.makeText(MainActivity.this, "Buscando", Toast.LENGTH_SHORT).show();
                searchitem = new ArrayList<>();
                for (ItemList element: mItemlist  ) {
                    if (element.getApellidos().equalsIgnoreCase(s)){
                        searchitem.add(element);
                    }
                }
                if (searchitem.size()!=0){
                orderListAdapter = new ListAdapter(MainActivity.this,searchitem);
                listView.setAdapter(orderListAdapter);}
                else {
                    Toast.makeText(MainActivity.this, "No existen Coincidencias", Toast.LENGTH_SHORT).show();
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {

                return false;
            }
        });


    }

    private void initlist(String[] Apellidos) {
        mItemlist = new ArrayList<>();
        for (String element: Apellidos ) {
            mItemlist.add(new ItemList(element));
        }

    }



}
