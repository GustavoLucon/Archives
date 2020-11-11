package com.example.luchadores;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Champselect extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_champselect);

		setupBack();
		setupNext();
		setupSelect();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.champselect, menu);
		return true;

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	private void setupBack() {
		// TODO Auto-generated method stub
		Button Botaochampselect = (Button) findViewById(R.id.Votlar);
		Botaochampselect.setBackgroundColor(Color.TRANSPARENT);
		Botaochampselect.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				// startActivity(new
				// Intent(TelaPrincipal.this,Champselect.class));
				startActivity(new Intent(Champselect.this, TelaPrincipal.class));
			}
		});
	}

	private void setupNext() {
		// TODO Auto-generated method stub
		Button Botaochampselect = (Button) findViewById(R.id.Proximo);
		Botaochampselect.setBackgroundColor(Color.TRANSPARENT);
		Botaochampselect.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				// startActivity(new
				// Intent(TelaPrincipal.this,Champselect.class));
				// startActivity(new
				// Intent(Champselect.this,Champselect.class));
				Toast.makeText(Champselect.this, "Ainda nao implementado",
						Toast.LENGTH_LONG).show();
			}
		});
	}

	private void setupSelect() {
		// TODO Auto-generated method stub
		Button Botaochampselect = (Button) findViewById(R.id.Selecionar);
		Botaochampselect.setBackgroundColor(Color.TRANSPARENT);
		Botaochampselect.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				// startActivity(new
				// Intent(TelaPrincipal.this,Champselect.class));
				startActivity(new Intent(Champselect.this, Arena.class));
			}
		});
	}
}
