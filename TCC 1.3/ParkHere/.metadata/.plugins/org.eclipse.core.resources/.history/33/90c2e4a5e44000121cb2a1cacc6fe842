package com.example.testlista;

import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity{
	private String[] inserir= new String[]{"teste","teste2","teste3","teste","teste2","teste3","teste","teste2","teste3","teste","teste2","teste3"};
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        ListView list = (ListView)findViewById(R.id.listView1);
       
        list.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,inserir));
        
        
        list.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				mostrar(inserir[arg2]);
				
			}
        });
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


	public void mostrar (String texto)
	{
		Toast.makeText(this,"you have selected "+ texto,Toast.LENGTH_LONG).show();
		
	}
}
