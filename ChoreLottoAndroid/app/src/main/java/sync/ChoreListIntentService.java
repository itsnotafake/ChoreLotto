package sync;

import android.app.IntentService;
import android.content.Intent;
import android.widget.Toast;

import java.io.File;

import n7.chorelotto.R;
import n7.chorelotto.framework.MainActivity;

/**
 * Created by Devin on 8/9/2017.
 */

public class ChoreListIntentService extends IntentService {

    public ChoreListIntentService(){
        super("ChoreListIntentService");
    }

    @Override
    public void onHandleIntent(Intent intent){
        MainActivity.mChoreFile = new File(this.getFilesDir(), getString(R.string.chorelist));
        if(!MainActivity.mChoreFile.exists()){
            Toast.makeText(this, "Hello", Toast.LENGTH_LONG).show();
        }
    }
}
