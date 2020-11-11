package guandv.luchadores;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Movie;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

public class PlayGifView extends View{

    private static final int DEFAULT_MOVIEW_DURATION = 1000;

    private int mMovieResourceId;
    private Movie mMovie;

    private long mMovieStart = 0;
    private int mCurrentAnimationTime = 0;

    @SuppressLint("NewApi")
    public PlayGifView(Context context, AttributeSet attrs) {
        super(context, attrs);

        /**
         * Starting from HONEYCOMB have to turn off HardWare acceleration to draw
         * Movie on Canvas.
         */
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        }
    }

    public void setImageResource(int mvId){
        this.mMovieResourceId = mvId;
        mMovie = Movie.decodeStream(getResources().openRawResource(mMovieResourceId));
        requestLayout();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if(mMovie != null){
            setMeasuredDimension(mMovie.width(), mMovie.height());
        }else{
            setMeasuredDimension(getSuggestedMinimumWidth(), getSuggestedMinimumHeight());
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (mMovie != null){
            updateAnimtionTime();
            drawGif(canvas);
            invalidate();
        }else{
            drawGif(canvas);
        }
    }

    private void updateAnimtionTime() {
        long now = android.os.SystemClock.uptimeMillis();

        if (mMovieStart == 0) {
            mMovieStart = now;
        }
        int dur = mMovie.duration();
        if (dur == 0) {
            dur = DEFAULT_MOVIEW_DURATION;
        }
        mCurrentAnimationTime = (int) ((now - mMovieStart) % dur);
    }

    private void drawGif(Canvas canvas) {
        mMovie.setTime(mCurrentAnimationTime);
        mMovie.draw(canvas, 0, 0);
        canvas.restore();
    }

    public void MudarAnimção(int estado) {

        if(estado == 0)
        {
            this.setImageResource(R.drawable.luchador);
        }
        else if(estado == 1)
        {
            this.setImageResource(R.drawable.luchajabs);
        }
        else if(estado == 2)
        {
            this.setImageResource(R.drawable.luchacorda);
        }
        else if(estado == 3)
        {
            this.setImageResource(R.drawable.luchaagarrar);
        }
        //OPONENTE
        else if(estado == 4)
        {
            this.setImageResource(R.drawable.oponent);
        }
        else if(estado == 5)
        {
            this.setImageResource(R.drawable.oponentjab);
        }
        else if(estado == 6)
        {
            this.setImageResource(R.drawable.oponentcorda);
        }
        else if(estado == 7)
        {
            this.setImageResource(R.drawable.oponentgrab);
        }

    }
}