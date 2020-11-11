package guandv.luchadores;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

/**
 * Created by Gustavo on 6/16/2016.
 */
public class ChampSelect extends Activity {
    ViewPager viewPager;
    ImageAdapter adapter;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.champselect);

        viewPager = (ViewPager) findViewById(R.id.view_pager);

        adapter = new ImageAdapter(this);
        viewPager.setAdapter(adapter);

        CancelBotao();
        SelectBotao();
    }

    private void CancelBotao() {
        final Button switchact = (Button) findViewById(R.id.Cancel);
        switchact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });
    }
    private void SelectBotao() {

        final Button switchact = (Button) findViewById(R.id.Select);
        switchact.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent act2 = new Intent(view.getContext(),Arena.class);
                startActivity(act2);
            }
        });


    }
}