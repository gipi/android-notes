import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.content.AsyncTaskLoader;

import java.util.Observable;
import java.util.Observer;


public class SimpleCursorLoader extends AsyncTaskLoader<Cursor> implements Observer {
    private Context mContext;
    private Integer mId = null;
    private IModelFilter mModel = null;
    private Bundle mArgs;
    private final static String TAG = "LOADER";

    public SimpleCursorLoader(Context context, Integer _id) {
        super(context);

        mContext = context;
        mId = _id;
    }

    public SimpleCursorLoader(Context context, IModelFilter model, Bundle args) {
        super(context);

        mContext = context;
        mModel = model;
        mArgs = args;

        model.getObservable().addObserver(this);
    }

    @Override
    protected void onStartLoading() {
        android.util.Log.d(TAG, "onStartLoading()");
        super.onStartLoading();

        // TODO: more logic here (see http://developer.android.com/reference/android/content/AsyncTaskLoader.html)
        forceLoad();
    }

    @Override
    public Cursor loadInBackground() {
        android.util.Log.d(TAG, "loadInBackground()");
        return mModel.get(mArgs);
    }

    @Override
    public void update(Observable obs, Object data) {
        android.util.Log.d(TAG, "update()");
        onContentChanged();
    }
}