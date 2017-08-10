package n7.chorelotto.framework;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageButton;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.io.File;

import n7.chorelotto.R;
import objects.ChoreList;

public class MainActivity extends AppCompatActivity implements NewDialogFragment.NewDialogListener{
    private static final String TAG = MainActivity.class.getName();
    public static File mChoreFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeToolbar();
        initializeMain();
        initializeFAB();
        initializeChoreList();
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

        switch(id){
            case R.id.action_list:
                showViewDialog();
                return true;
            default:
                Log.e(TAG, "Unknown menu item id");
                return super.onOptionsItemSelected(item);
        }
    }

    private void initializeToolbar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    /**
     * Handles initialization of everything in content_main
     */
    private void initializeMain(){
        //Start with background image
        GradientDrawable rainbow = new GradientDrawable(GradientDrawable.Orientation.BL_TR,
                new int[] {
                        Color.RED,
                        Color.MAGENTA,
                        Color.BLUE,
                        Color.CYAN,
                        Color.GREEN,
                        Color.YELLOW,
                        Color.RED}
        );
        rainbow.setGradientType(GradientDrawable.SWEEP_GRADIENT);
        ImageView background = (ImageView) findViewById(R.id.content_main_bg);
        background.setImageDrawable(rainbow);

        //Initialize AppCompatImageButton src image
        AppCompatImageButton draw = (AppCompatImageButton) findViewById(R.id.content_main_draw);
        Picasso.with(this).load(R.drawable.closed3).into(draw);
    }

    private void initializeFAB(){
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showNewDialog();
            }
        });
    }

    private void initializeChoreList(){
        mChoreFile = new File(this.getFilesDir(), getString(R.string.chorelist));
    }

    private void showNewDialog(){
        DialogFragment dialog = new NewDialogFragment();
        dialog.show(getSupportFragmentManager(), "NewDialogFragment");
    }

    private void showViewDialog(){
        DialogFragment dialog = new ViewDialogFragment();
        dialog.show(getSupportFragmentManager(), "ViewDialogFragment");
    }

    public void onDialogPositiveClick(NewDialogFragment dialog){
        Dialog dialogView = dialog.getDialog();
        EditText titleET = (EditText) dialogView.findViewById(R.id.new_title);
        EditText subjectET = (EditText) dialogView.findViewById(R.id.new_subject);
        String title = titleET.getText().toString();
        String subject = subjectET.getText().toString();
        if(title.isEmpty()){
            Toast.makeText(this, getString(R.string.main_notitle), Toast.LENGTH_LONG).show();
        }else{
            ChoreList.Chore chore = new ChoreList.Chore(title, subject);
            ChoreList.add(chore);
            Toast.makeText(this, getString(R.string.main_choreadded), Toast.LENGTH_LONG).show();
        }
    }
}
