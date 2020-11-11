package guandv.luchadores;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Movie;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;

import java.io.InputStream;

/**
 * Created by Gustavo on 7/29/2016.
 */
public class GifView extends View{

    private InputStream gifInputStream;
    private Movie gifMovie;
    private int movieWidth , movieheight;
    private long movieStart;
    private int endIt=0;

    public GifView (Context context)
    {
        super(context);
        init(context);
    }
    public GifView (Context context , AttributeSet attrs)
    {
        super(context,attrs);
        init(context);
    }
    public GifView (Context context, AttributeSet attrs , int defStyleAttr)
    {
        super(context, attrs , defStyleAttr);
        init(context);
    }

    private void init(Context context)
    {
        setFocusable(true);
        gifInputStream = context.getResources().openRawResource(+R.drawable.luchador); // AQUI A ANIMAÇÂO È INSERIDA

        gifMovie = Movie.decodeStream(gifInputStream);
        movieWidth = gifMovie.width();
        movieheight = gifMovie.height();


    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(movieWidth,movieheight);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        long now = SystemClock.uptimeMillis();

            if (movieStart == 0) {
                movieStart = now;
            }

            if (gifMovie != null) {
                if (endIt == 0) {
                    int dur = gifMovie.duration();
                    if (dur == 0) {
                        dur = 1000;
                    }

                    int relTime = (int) ((now - movieStart) % dur);

                    gifMovie.setTime(relTime);

                    gifMovie.draw(canvas, 0, 0);
                    invalidate();
                }
            }

    }
}
