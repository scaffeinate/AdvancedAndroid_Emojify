package com.example.android.emojify;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.util.SparseArray;
import android.widget.Toast;

import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.face.Face;
import com.google.android.gms.vision.face.FaceDetector;

/**
 * Created by sudharti on 11/13/17.
 */

public class Emojifier {
    public static void detectFaces(Context context, Bitmap bitmap) {
        FaceDetector faceDetector = new FaceDetector.Builder(context)
                .setTrackingEnabled(false)
                .build();
        Frame frame = new Frame.Builder().setBitmap(bitmap).build();
        SparseArray<Face> faces = faceDetector.detect(frame);
        Log.i(Emojifier.class.getSimpleName(), "Number of faces = " + faces.size());

        if(faces.size() == 0){
            Toast.makeText(context, context.getResources().getString(R.string.no_faces_message), Toast.LENGTH_SHORT).show();
        }

        faceDetector.release();
    }
}
