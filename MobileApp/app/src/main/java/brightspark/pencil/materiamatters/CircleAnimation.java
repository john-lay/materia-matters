package brightspark.pencil.materiamatters;

import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.view.animation.Transformation;

/**
 * Created by John on 15/03/2016.
 */
public class CircleAnimation {

    private CircleView circle;
    private float pivotX;
    private float pivotY;

    public CircleAnimation(CircleView circle,float pivotX, float pivotY) {

        this.circle = circle;
        this.pivotX = pivotX;
        this.pivotY = pivotY;
    }

    public void showBlue() {
        Animation an = new RotateAnimation(0.0f, 45.0f, pivotX, pivotY);

        // Set the animation's parameters
        an.setDuration(0);                   // duration in ms
        an.setRepeatCount(0);                // -1 = infinite repeated
        an.setRepeatMode(Animation.REVERSE); // reverses each repeat
        an.setFillAfter(true);               // keep rotation after animation

        // Apply animation to image view
        this.circle.setAnimation(an);
    }

    public void rotateToGreen(int durationMilli) {
        Animation an = new RotateAnimation(0.0f, 45.0f, pivotX, pivotY);

        // Set the animation's parameters
        an.setDuration(durationMilli);       // duration in ms
        an.setRepeatCount(0);                // -1 = infinite repeated
        an.setRepeatMode(Animation.REVERSE); // reverses each repeat
        an.setFillAfter(true);               // keep rotation after animation

        // Apply animation to image view
        this.circle.setAnimation(an);
    }

    public void rotateToRed(int durationMilli) {
        Animation an = new RotateAnimation(0.0f, 135.0f, pivotX, pivotY);

        // Set the animation's parameters
        an.setDuration(durationMilli);       // duration in ms
        an.setRepeatCount(0);                // -1 = infinite repeated
        an.setRepeatMode(Animation.REVERSE); // reverses each repeat
        an.setFillAfter(true);               // keep rotation after animation

        // Apply animation to image view
        this.circle.setAnimation(an);
    }

    public void rotateToPurple(int durationMilli) {
        Animation an = new RotateAnimation(0.0f, 225.0f, pivotX, pivotY);

        // Set the animation's parameters
        an.setDuration(durationMilli);       // duration in ms
        an.setRepeatCount(0);                // -1 = infinite repeated
        an.setRepeatMode(Animation.REVERSE); // reverses each repeat
        an.setFillAfter(true);               // keep rotation after animation

        // Apply animation to image view
        this.circle.setAnimation(an);
    }

    public void rotateToBlue(int durationMilli) {
        Animation an = new RotateAnimation(0.0f, 315.0f, pivotX, pivotY);

        // Set the animation's parameters
        an.setDuration(durationMilli);       // duration in ms
        an.setRepeatCount(0);                // -1 = infinite repeated
        an.setRepeatMode(Animation.REVERSE); // reverses each repeat
        an.setFillAfter(true);               // keep rotation after animation

        // Apply animation to image view
        this.circle.setAnimation(an);
    }
}
