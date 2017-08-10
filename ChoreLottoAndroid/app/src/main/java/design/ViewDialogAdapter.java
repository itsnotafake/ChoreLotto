package design;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import n7.chorelotto.R;
import objects.ChoreList;

/**
 * Created by Devin on 8/9/2017.
 */

public class ViewDialogAdapter extends
        RecyclerView.Adapter<ViewDialogAdapter.ViewDialogAdapterViewHolder>{
    private Context mContext;
    private static final String TAG = ViewDialogAdapter.class.getName();

    public ViewDialogAdapter(Context context){
        mContext = context;
    }

    @Override
    public ViewDialogAdapterViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType){
        View view = LayoutInflater.from(mContext)
                .inflate(R.layout.view_dialog_item, viewGroup, false);
        return new ViewDialogAdapterViewHolder(view, viewType);
    }

    @Override
    public void onBindViewHolder(ViewDialogAdapterViewHolder vh, int position){
        Log.e(TAG, ChoreList.get(position).getTitle());
        vh.setTitle(ChoreList.get(position).getTitle());
    }

    @Override
    public int getItemCount(){
        return ChoreList.size();
    }

    class ViewDialogAdapterViewHolder extends RecyclerView.ViewHolder{
        private TextView mTitle;

        ViewDialogAdapterViewHolder(View view, int viewType){
            super(view);
            mTitle = (TextView) view.findViewById(R.id.view_title);
        }

        void setTitle(String title){
            mTitle.setText(title);
        }
    }
}
