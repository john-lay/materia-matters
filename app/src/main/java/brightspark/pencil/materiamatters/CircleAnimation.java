package brightspark.pencil.materiamatters;

import android.view.animation.Animation;
import android.view.animation.Transformation;

/**
 * Created by John on 15/03/2016.
 */
public class CircleAnimation extends Animation {

    private CircleView circle;

    private float oldAngle;
    private float newAngle;

    public CircleAnimation(CircleView circle) {
        //this.oldAngle = circle.getAngle();
        //this.newAngle = newAngle;
        this.circle = circle;
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation transformation) {
        float angle = oldAngle + ((newAngle - oldAngle) * interpolatedTime);

        //circle.setAngle(angle);
        circle.requestLayout();
    }
}
