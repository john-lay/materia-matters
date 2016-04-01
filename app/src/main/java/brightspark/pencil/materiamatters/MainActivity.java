package brightspark.pencil.materiamatters;

import android.content.Intent;
import android.net.Uri;
import android.os.Debug;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    static final int REQUEST_TAKE_PHOTO = 1;
    static final float viewDiameter = 200f;
    String mCurrentPhotoPath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_status);

        // Locate view
        CircleView view = (CircleView) findViewById(R.id.circleView);

        //draw view 200 units from the top and 200 units from the left of the screen origin (top-left)
        float viewOriginX = 200f;
        float viewOriginY = 200f;
        view.setX(viewOriginX);
        view.setY(viewOriginY);

        // Create an animation instance
        //Animation an = new RotateAnimation(0.0f, 360.0f);//, pivotX, pivotY);

        //Log.d(TAG, "width = " + Integer.toString(circle.getWidth()));

        CircleAnimation circle = new CircleAnimation(view, viewOriginX + viewDiameter, viewOriginY +viewDiameter);
        //circle.showBlue();
        //circle.rotateToGreen(1000);
        //circle.rotateToRed(1000);
        //circle.rotateToPurple(1000);
        circle.rotateToBlue(1000);

//        // set view at 45 degree angle all views are relative to the screen origin
//        Animation an = new RotateAnimation(0.0f, 45.0f, viewOriginX + viewDiameter, viewOriginY +viewDiameter);
//
//        // Set the animation's parameters
//        an.setDuration(0);               // duration in ms
//        an.setRepeatCount(0);                // -1 = infinite repeated
//        an.setRepeatMode(Animation.REVERSE); // reverses each repeat
//        an.setFillAfter(true);               // keep rotation after animation
//
//        // Apply animation to image view
//        view.setAnimation(an);
//
//        // rotate animation
//        Animation rot = new RotateAnimation(0.0f, 45.0f, viewOriginX + viewDiameter, viewOriginY +viewDiameter);
//
//        // Set the animation's parameters
//        rot.setDuration(3000);               // duration in ms
//        rot.setRepeatCount(0);                // -1 = infinite repeated
//        rot.setRepeatMode(Animation.REVERSE); // reverses each repeat
//        rot.setFillAfter(true);               // keep rotation after animation
//
//        // Apply animation to image view
//        view.setAnimation(rot);

//        CircleAnimation animation = new CircleAnimation(circle);
//        animation.setDuration(1000);
//        circle.startAnimation(animation);

        //setContentView(new MateriaView(this));
//        Button btn = (Button) findViewById(R.id.btn_takePhoto);
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                TextView textView = (TextView)findViewById(R.id.txt_TextView);
////                textView.setText("Button Clicked");
//                dispatchTakePictureIntent();
//            }
//        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // Ensure that there's a camera activity to handle the intent
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            // Create the File where the photo should go
            File photoFile = null;
            try {
                photoFile = createImageFile();
            } catch (IOException ex) {
                // Error occurred while creating the File
            }
            // Continue only if the File was successfully created
            if (photoFile != null) {
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT,
                        Uri.fromFile(photoFile));
                startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO);
            }
        }
    }

    private File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );

        // Save a file: path for use with ACTION_VIEW intents
        mCurrentPhotoPath = "file:" + image.getAbsolutePath();
        TextView textView = (TextView)findViewById(R.id.txt_TextView);
        textView.setText(mCurrentPhotoPath);
        return image;
    }

    private void galleryAddPic() {
        Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        File f = new File(mCurrentPhotoPath);
        Uri contentUri = Uri.fromFile(f);
        mediaScanIntent.setData(contentUri);
        this.sendBroadcast(mediaScanIntent);
    }
}