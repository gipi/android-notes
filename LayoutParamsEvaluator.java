import android.view.ViewGroup;

import com.nineoldandroids.animation.IntEvaluator;
import com.nineoldandroids.animation.TypeEvaluator;


/**
 * This evaluator is used in animation of "layouting" a view.
 *
 * Remember: the LayoutParams MUST be the parent one!
 *
 * Created by Gianluca Pacchiella <pacchiella@elipse.it> on 9/4/13.
 */
public class LayoutParamsEvaluator<T extends ViewGroup.LayoutParams> implements TypeEvaluator<T> {
    private T mLayoutParams = null;
    static private IntEvaluator intEvaluator = new IntEvaluator();

    @Override
    public T evaluate(float t, T startLayoutParams, T finalLayoutParams) {
        if (mLayoutParams == null) {
            //mLayoutParams = new ViewGroup.LayoutParams(startLayoutParams);
            mLayoutParams = startLayoutParams;
        }

        mLayoutParams.width = intEvaluator.evaluate(t, startLayoutParams.width, finalLayoutParams.width);
        mLayoutParams.height = intEvaluator.evaluate(t, startLayoutParams.height, finalLayoutParams.height);

        return mLayoutParams;
    }
}