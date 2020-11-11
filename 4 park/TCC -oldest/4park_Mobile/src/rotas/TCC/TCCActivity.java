package rotas.TCC;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class TCCActivity extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

	}
	public void selfStart(View view) {
		setContentView(R.layout.ajuda);
	}
	public void selfDestruct(View view) {
		super.finish();
	}
	public void selfConfig(View view) {
		setContentView(R.layout.confi);
	}
	public void selfAjuda(View view) {
		setContentView(R.layout.ajuda);
	}
	public void selfBack(View view) {
		setContentView(R.layout.main);
	}
}