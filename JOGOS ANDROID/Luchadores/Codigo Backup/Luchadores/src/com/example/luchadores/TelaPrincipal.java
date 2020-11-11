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

public class TelaPrincipal extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_principal);

		setuploginFB();
		setuploginguest();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tela_principal, menu);
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

	private void setuploginFB() {
		// TODO Auto-generated method stub
		Button Botaochampselect = (Button) findViewById(R.id.FB);
		Botaochampselect.setBackgroundColor(Color.TRANSPARENT);
		Botaochampselect.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(TelaPrincipal.this, "Ainda nao implementado",
						Toast.LENGTH_LONG).show();

			}
		});
	}

	private void setuploginguest() {
		// TODO Auto-generated method stub
		Button Botaochampselect = (Button) findViewById(R.id.Guest);
		Botaochampselect.setBackgroundColor(Color.TRANSPARENT);
		Botaochampselect.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				// startActivity(new
				// Intent(TelaPrincipal.this,Champselect.class));
				startActivity(new Intent(TelaPrincipal.this, Champselect.class));
			}
		});
	}
}