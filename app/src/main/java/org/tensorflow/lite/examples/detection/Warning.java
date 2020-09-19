package org.tensorflow.lite.examples.detection;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.widget.Toast;


public class Warning extends Thread {
    Context context;
    Handler handler;
    Warning(Context context, Handler handler){
        this.context = context;
        this.handler =handler;
    }
    @Override
    public void run() {
        while (((Global)context).isRunning())
            if(((Global)context).getWarning()) {
//                Toast.makeText(context, "Move Away", Toast.LENGTH_SHORT).show();
                Log.d("DISTANCE", "Sending to Handler");
                Message m = Message.obtain(); //get null message
                Bundle b = new Bundle();
                b.putString("warning1", "warning");
                m.setData(b);
                //use the handler to send message
                handler.sendMessage(m);
               // ((Global)context).getTts().speak("Please Keep Distance", TextToSpeech.QUEUE_FLUSH, null);
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
    }
}

