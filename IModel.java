import android.database.Cursor;
import android.os.Bundle;

import java.util.Observable;

/**
 * Interface to be implemented by a model to be called with SimpleCursorLoader.
 *
 * The "args" contains the parameter with respect to filter the query.
 */
public interface IModelFilter {
    public Cursor get(Bundle args);
    public Observable getObservable();
}