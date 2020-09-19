package org.tensorflow.lite.examples.detection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class VideoActivity extends AppCompatActivity {
    VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        videoView =findViewById(R.id.videoView);
        Intent selectVideo = new Intent(Intent.ACTION_PICK, MediaStore.Video.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(selectVideo,1);

     //   videoView.start();

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        //super.onActivityResult(requestCode, resultCode, data);
        // check if the request code is same as what is passed  here it is 2
        if(requestCode==1&& data !=null)
        {
            Uri videoSelected = data.getData();
            String[] filePathColumn = {MediaStore.Video.Media.DATA};
            if(videoSelected != null){
                Cursor cursor = getContentResolver().query(videoSelected,filePathColumn,null,null,null);
                if(cursor !=null){
                    cursor.moveToFirst();
                    int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                    String videoPath = cursor.getString(columnIndex);
                    MediaController mediaController = new MediaController(getApplicationContext());
                    mediaController.setAnchorView(findViewById(R.id.videoView));
                    //mediaController.setEnabled(true);

                    //      videoView.setVideoPath("");
                    videoView.setMediaController(mediaController);
                    videoView.setVideoPath(videoPath);
                    videoView.requestFocus();
                    videoView.start();
                    //mediaController.show();
                    Toast.makeText(getApplicationContext(),""+videoPath,Toast.LENGTH_SHORT).show();

                }
            }

        }
    }
}
