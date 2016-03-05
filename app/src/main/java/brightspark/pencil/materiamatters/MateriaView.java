package brightspark.pencil.materiamatters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by John on 05/03/2016.
 */
public class MateriaView extends View {

    public MateriaView(Context context) {
        super(context);
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void onDraw(Canvas canvas) {

        // initialise counters for pixel info
        int rCounter, gCounter, bCounter, pixelCounter;
        rCounter = gCounter = bCounter = pixelCounter = 0;

        // read in bitmap
        Bitmap src = BitmapFactory.decodeResource(getResources(), R.drawable.tile50blue50white);

        // read in component colours
        Bitmap bitmap = src.copy(Bitmap.Config.ARGB_8888, true);
        for(int x=0; x<bitmap.getWidth(); x++)
        {
            for(int y=0; y<bitmap.getHeight(); y++)
            {
                // here bitmap.getPixel(x, y)) gets the pixel at the position (x,y)
                int pixelValue = bitmap.getPixel(x, y);
                int rValue = Color.red(pixelValue); // gives value of R in "RGB"
                int gValue = Color.green(pixelValue); // gives value of G in "RGB"
                int bValue = Color.blue(pixelValue); // gives value of B in "RGB"

//                String msg = "Materia: pixel(";
//                msg += Integer.toString(x);
//                msg += ",";
//                msg += Integer.toString(y);
//                msg += ") RGB(";
//                msg += Integer.toString(rValue) + ",";
//                msg += Integer.toString(gValue) + ",";
//                msg += Integer.toString(bValue) + ")";
//                Log.d(TAG, msg);

                // increment counters
                rCounter += rValue;
                gCounter += gValue;
                bCounter += bValue;
                pixelCounter ++;
            }
        }

//        Log.d(TAG, "Materia: rTotal = " + Integer.toString(rCounter));
//        Log.d(TAG, "Materia: gTotal = " + Integer.toString(gCounter));
//        Log.d(TAG, "Materia: bTotal = " + Integer.toString(bCounter));
//        Log.d(TAG, "Materia: pixelTotal = " + Integer.toString(pixelCounter));

        int rAverage = (int)Math.floor(rCounter / pixelCounter);
        int gAverage = (int)Math.floor(gCounter / pixelCounter);
        int bAverage = (int)Math.floor(bCounter / pixelCounter);

        // draw result of average color
        Paint brush = new Paint();
        brush.setColor(Color.rgb(rAverage, gAverage, bAverage));
        canvas.drawRect(100, 100, 200, 200, brush);
    }
}
