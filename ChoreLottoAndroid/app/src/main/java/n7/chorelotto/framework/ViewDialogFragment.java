package n7.chorelotto.framework;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import design.ViewDialogAdapter;
import n7.chorelotto.R;
import objects.ChoreList;

/**
 * Created by Devin on 8/9/2017.
 */

public class ViewDialogFragment extends DialogFragment {
    Context mContext;
    private static final String TAG = ViewDialogFragment.class.getName();

    @Override
    @NonNull
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        mContext = getContext();
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();

        View view  = inflater.inflate(R.layout.view_dialog, null);
        RecyclerView recycler = (RecyclerView) view.findViewById(R.id.view_recycler);
        recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        recycler.setAdapter(new ViewDialogAdapter(getContext()));

        builder.setView(view)
                .setPositiveButton(R.string.view_positive, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        ViewDialogFragment.this.getDialog().cancel();
                    }
                });
        return builder.create();
    }

    /*@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.view_dialog, container, false);
        RecyclerView recycler = (RecyclerView) view.findViewById(R.id.view_recycler);
        recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        //ViewDialogAdapter adapter = new ViewDialogAdapter(mContext);
        recycler.setAdapter(new ViewDialogAdapter(getContext()));
        return view;
    }*/
}
