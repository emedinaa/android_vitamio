package com.emedinaa.appvitamio;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import io.vov.vitamio.LibsChecker;
import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;


public class HomeActivity extends Activity {

    //private String pathToFileOrUrl= "rtmp://204.107.26.252:8086/live/796.high.stream";
    //private String pathToFileOrUrl= "rtsp://127.0.0.1:1935/vod/sample.mp4";
    //private String pathToFileOrUrl= "rtmp://s3b78u0kbtx79q.cloudfront.net/cfx/st";
    //private String pathToFileOrUrl= "rtsp://85.25.199.31:1935/rtp-live/willow.stream";
    private String pathToFileOrUrl= "rtmp://cycnow.az-streamingserver.com:3333/live/cyc2";
   // private String pathToFileOrUrl= "rtmp://fms5.visionip.tv/live/RT_2";
    //private String pathToFileOrUrl= "rtmp://41.110.184.51:1935/live/dzairnewstube.cpkh-t8yw-qjwt-d2r5&autoPlay=true&streamType=live";
    //rtmp://41.110.184.51:1935/live/dzairnewstube.cpkh-t8yw-qjwt-d2r5&autoPlay=true&streamType=live
    //rtmp://41.110.184.51:1935/live/dzairnewstube.cpkh-t8yw-qjwt-d2r5&autoPlay=true&streamType=live
    private VideoView mVideoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        if (!LibsChecker.checkVitamioLibs(this))
            return;

        mVideoView = (VideoView) findViewById(R.id.surface_view);

        mVideoView.setVideoPath(pathToFileOrUrl);
        mVideoView.setMediaController(new MediaController(this));
        mVideoView.requestFocus();

        mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                // optional need Vitamio 4.0
                mediaPlayer.setPlaybackSpeed(1.0f);
            }
        });
    }

    public void startPlay(View view) {
        if (!TextUtils.isEmpty(pathToFileOrUrl)) {
            mVideoView.setVideoPath(pathToFileOrUrl);
        }
    }

    public void openVideo(View View)
    {
        mVideoView.setVideoPath(pathToFileOrUrl);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return false;

    }
}
