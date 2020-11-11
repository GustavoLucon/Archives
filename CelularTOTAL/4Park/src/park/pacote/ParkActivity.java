package park.pacote;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.GridView;
import android.widget.ImageView;

public class ParkActivity extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.inicial);
		// Instance of ImageAdapter Class

	}

	private void ConferirModulos() {
		CheckBox dalt = (CheckBox) findViewById(R.id.dalt);
		CheckBox def = (CheckBox) findViewById(R.id.defc);
		if (dalt != null) {
			daltonico = dalt.isChecked();
			deficiente = def.isChecked();
		}
	}

	private Integer[] mapa;
	private boolean daltonico;
	private boolean deficiente;
	private PathFinder path;

	public void selfDestruct(View view) {
		super.finish();
	}

	public void selfStart(View view) {
		path = new PathFinder(null);
		CriarTela(0);
		setContentView(R.layout.main);
		GridView gridView = (GridView) findViewById(R.id.gridview);
		gridView.setAdapter(new ImageAdapter(this, mapa));
	}

	// Metodo de abrir a tela de configurações
	// Vinculado ao botao config

	public void selfConfig(View view) {
		setContentView(R.layout.configurar);
	}

	public void selfDef(View view) {
		CheckBox def = (CheckBox) findViewById(R.id.defc);
		deficiente = def.isChecked();

	}

	public void selfDal(View view) {
		CheckBox dal = (CheckBox) findViewById(R.id.dalt);
		daltonico = dal.isChecked();
	}

	// Metodo voltar a tela inicial
	// Vinculado ao botao Voltar (em todas as telas)

	public void selfBack(View view) {
		setContentView(R.layout.inicial);
	}

	// Metodo Connectar a tela inicial
	// Vinculado ao botao Connectar (em todas as telas)

	public void selfConnect(View view) {
		setContentView(R.layout.connectar);

	}

	private void CriarTela(int primeira) {

		int[][] caminho = path.Criar(deficiente, primeira);

		int caminh = 0;

		mapa = new Integer[400];
		int cont = 0;

		for (int x = 0; x < path.getMap().length; x++) { // nao esta pegando o x
			for (int y = 0; y < path.getMap().length; y++) { // nao esta pegando

				if (caminho[1][caminho[1].length - 1] != caminho[1][caminh]
						&& caminho[0][caminho[0].length - 1] != caminho[0][caminh]
						&& caminho[0][caminh] == x && caminho[1][caminh] == y) {
					if (path.getMap()[x][y] == path.getD()) {
						if (deficiente) {
							mapa[cont] = R.drawable.deficientex;
						} else {
							mapa[cont] = R.drawable.deficienterx;
						}
					} else if (path.getMap()[x][y] == path.getIn()) {
						if (daltonico) {
							mapa[cont] = R.drawable.qcinza4x;
						} else {
							mapa[cont] = R.drawable.qverdex;
						}
					} else if (path.getMap()[x][y] == path.getFi()) {
						if (daltonico) {
							mapa[cont] = R.drawable.qcinza4x;
						} else {
							mapa[cont] = R.drawable.qcinza3x;
						}
					} else if (path.getMap()[x][y] == path.getE()) {
						if (daltonico) {
							mapa[cont] = R.drawable.qcinza2x;
						} else {
							mapa[cont] = R.drawable.qazulx;
						}
					} else if (path.getMap()[x][y] == path.getF()) {
						mapa[cont] = R.drawable.qbrancox;
					} else if (path.getMap()[x][y] == path.getI()) {
						if (daltonico) {
							mapa[cont] = R.drawable.qcinza5x;
						} else {
							mapa[cont] = R.drawable.qvermelhox;
						}
					} else if (path.getMap()[x][y] == path.getP()) {
						mapa[cont] = R.drawable.qcinzax;
					} else if (path.getMap()[x][y] == path.getT()) {
						mapa[cont] = R.drawable.qfaixax;
					}
					cont++;
					caminh++;

				} else {
					if (path.getMap()[x][y] == path.getD()) {
						if (deficiente) {
							mapa[cont] = R.drawable.deficiente;
						} else {
							mapa[cont] = R.drawable.deficienter;
						}
					} else if (path.getMap()[x][y] == path.getIn()) {
						if (daltonico) {
							mapa[cont] = R.drawable.qcinza4;
						} else {
							mapa[cont] = R.drawable.qverde;
						}
					} else if (path.getMap()[x][y] == path.getFi()) {
						if (daltonico) {
							mapa[cont] = R.drawable.qcinza4;
						} else {
							mapa[cont] = R.drawable.qcinza3x;
						}
					} else if (path.getMap()[x][y] == path.getE()) {
						if (daltonico) {
							mapa[cont] = R.drawable.qcinza2;
						} else {
							mapa[cont] = R.drawable.qazul;
						}
					} else if (path.getMap()[x][y] == path.getF()) {
						mapa[cont] = R.drawable.qbranco;
					} else if (path.getMap()[x][y] == path.getI()) {
						if (daltonico) {
							mapa[cont] = R.drawable.qcinza5;
						} else {
							mapa[cont] = R.drawable.qvermelho;
						}
					} else if (path.getMap()[x][y] == path.getP()) {
						mapa[cont] = R.drawable.qcinza;
					} else if (path.getMap()[x][y] == path.getT()) {
						mapa[cont] = R.drawable.qfaixa;
					}
					cont++;
				}

			}

		}

	}

	// Metodo abrir a tela de ajuda
	// Vinculado ao botao Ajuda

	public void selfAjuda(View view) {
		setContentView(R.layout.ajuda);
	}

	public void selfleg(View view) {
		String ajuda = "";

		if (deficiente) {
			ajuda = ajuda + "Azul Claro Sinaliza Vagas de Deficientes\n";
		}
		if (daltonico) {
			ajuda = ajuda
					+ "Cinza São estradas \n Brancos sao Faixas \n Marrom são vagas (Sinalizado Pelo caminho a percorrer)\n Verde é o ponto de saida e entrada (Ficar marcado pelo caminho)\n Rosa São paredes (ou vagas de deficientes) ";
		} else {
			ajuda = ajuda
					+ "Cinza significa estradas \n Verde são os pontos de inicio e fim \n Brancos são faixas \n Vermelhos são paredes(ou vagas de deficientes) \n Azul são vagas";
		}

		AlertDialog alert;
		alert = new AlertDialog.Builder(this).create();
		alert.setTitle("Legenda");
		alert.setMessage(ajuda);
		alert.show();

	}

	// Metodo connectar ao BD
	// Vinculado ao botao Connectar

	public class ImageAdapter extends BaseAdapter {

		private Context mContext;
		public ImageView imageView;

		public ImageView getImageView() {
			return imageView;
		}

		// Keep all Images in array
		public Integer[] mThumbIds = { R.drawable.ic_launcher, R.drawable.ajuda };

		// Constructor
		public ImageAdapter(Context c, Integer[] mapa) {
			mContext = c;
			mThumbIds = mapa;

		}

		public Context getMContext() {
			return mContext;
		}

		@Override
		public int getCount() {
			return mThumbIds.length;
		}

		@Override
		public Object getItem(int position) {
			return mThumbIds[position];
		}

		@Override
		public long getItemId(int position) {
			return 0;
		}

		@Override
		public View getView(final int position, View convertView,
				ViewGroup parent) {

			imageView = new ImageView(mContext);
			imageView.setImageResource(mThumbIds[position]);
			imageView.setPadding(0, 2, 0, 2);

			// AQUI O CLICK DOS EVENTOS

			imageView.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View view) {
					int x = position / 20;
					int y = position % 20;
					if (path.getLocal(x, y) == path.getE()) {
						path.troca(x, y, true);
						CriarTela(1);
						GridView gridView = (GridView) findViewById(R.id.gridview);
						gridView.setAdapter(new ImageAdapter(mContext, mapa));
					}
					if (path.getLocal(x, y) == path.getD() && path.getD() == 4) {
						path.troca(x, y, false);
						CriarTela(1);
						GridView gridView = (GridView) findViewById(R.id.gridview);
						gridView.setAdapter(new ImageAdapter(mContext, mapa));
					}

				}
			});

			imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
			imageView.setLayoutParams(new GridView.LayoutParams(23, 23));
			return imageView;
		}
	}
}