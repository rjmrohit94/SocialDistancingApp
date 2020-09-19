package org.tensorflow.lite.examples.detection;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;

import org.acra.*;
import org.acra.annotation.*;

@AcraToast(resText=R.string.acra_toast, length = Toast.LENGTH_LONG)
@AcraMailSender(mailTo = "rjmrohit94@gmail.com")
@AcraCore(buildConfigClass = BuildConfig.class)
public class Global extends Application {
    private boolean warning =false;


    private boolean running = true;

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public void setWarning(boolean warning){
        this.warning = warning;
    }
    public boolean getWarning(){
        return  warning;
    }
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);

        // The following line triggers the initialization of ACRA
        ACRA.init(this);
    }


}
/*  */