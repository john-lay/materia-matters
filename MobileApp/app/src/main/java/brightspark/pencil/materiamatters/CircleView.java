package brightspark.pencil.materiamatters;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by John on 15/03/2016.
 */
public class CircleView extends View {

    public CircleView(Context context, AttributeSet attrs) {
        super(context, attrs);


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        final int strokeWidth = 2;
        final int circleDiameter = 200;

        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);

        //fill color
        paint.setColor(Color.rgb(204, 0, 0));

        //size 200x200 example
        RectF rect = new RectF(strokeWidth,
                strokeWidth,
                circleDiameter + strokeWidth, circleDiameter + strokeWidth);

        // draw filled circle
        canvas.drawOval(rect, paint);

        // set stroke
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(strokeWidth);
        paint.setColor(Color.rgb(102, 0, 0));

        // draw stroke
        canvas.drawOval(rect, paint);

        // top right
        ///////////////////////////////////////////////////////////////////////////

        //size 200x200 example
        RectF rect2 = new RectF(circleDiameter + strokeWidth + strokeWidth,
                strokeWidth, (circleDiameter * 2) + strokeWidth,
                circleDiameter + strokeWidth);

        // set fill
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.rgb(0, 204, 0));

        // draw filled circle
        canvas.drawOval(rect2, paint);

        // set stroke
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(strokeWidth);
        paint.setColor(Color.rgb(0, 102, 0));

        // draw stroke
        canvas.drawOval(rect2, paint);

        // bottom right
        ///////////////////////////////////////////////////////////////////////////

        //size 200x200 example
        RectF rect3 = new RectF(circleDiameter + strokeWidth + strokeWidth,
                circleDiameter + strokeWidth + strokeWidth,
                (circleDiameter * 2) + strokeWidth, (circleDiameter * 2) + strokeWidth);

        // set fill
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.rgb(0, 0, 204));

        // draw filled circle
        canvas.drawOval(rect3, paint);

        // set stroke
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(strokeWidth);
        paint.setColor(Color.rgb(0, 0, 102));

        // draw stroke
        canvas.drawOval(rect3, paint);

        // bottom left
        ///////////////////////////////////////////////////////////////////////////

        //size 200x200 example
        RectF rect4 = new RectF(strokeWidth,
                circleDiameter + strokeWidth + strokeWidth,
                circleDiameter + strokeWidth,
                (circleDiameter * 2) + strokeWidth);

        // set fill
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.rgb(102, 0, 204));

        // draw filled circle
        canvas.drawOval(rect4, paint);

        // set stroke
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(strokeWidth);
        paint.setColor(Color.rgb(51, 0, 102));

        // draw stroke
        canvas.drawOval(rect4, paint);

        ///////////////////////////////////////////////////////////////////////////
    }
}
