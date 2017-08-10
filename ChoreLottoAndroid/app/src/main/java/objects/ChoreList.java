package objects;

import android.support.annotation.Nullable;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Devin on 8/9/2017.
 */

public class ChoreList {
    private static final String TAG = ChoreList.class.getName();
    private static ArrayList<Chore> choreList;

    static{
        choreList = new ArrayList<>();
    }

    public static void add(Chore chore){
        choreList.add(chore);
    }

    public static Chore get(int position){
        try{
            return choreList.get(position);
        }catch(ArrayIndexOutOfBoundsException e){
            Log.e(TAG, "ArrayIndexOutOfBoundsExcpetion: " + e);
            return choreList.get(0);
        }
    }

    public static int size(){
        return choreList.size();
    }

    public static void setList(ArrayList<Chore> newList){
        choreList = newList;
    }

    public static class Chore {

        private String title;
        private String body;

        public Chore(String title, @Nullable String body){
            this.title = title;
            this.body = body;
        }

        public String getTitle(){
            return title;
        }

        @Nullable
        public String getBody(){
            return body;
        }
    }
}
