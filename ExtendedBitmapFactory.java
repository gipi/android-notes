import android.graphics.BitmapFactory;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
 
 
/**
 * The aim of this class is to augment the original factory
 * of Bitmap in order to allow overlaying the created Bitmap
 * with indicator.
 *
 * {@link http://ruibm.com/?p=184}
 */
public class ExtendedBitmapFactory extends BitmapFactory {
	static Bitmap decodeResourceOverlaying(Resources resources, int id, Bitmap overlay) {
		final int topX = 0;
		final int topY = 0;
 
		Bitmap bg = decodeResource(resources, id);
		Bitmap copyBg = Bitmap.createBitmap(bg.getWidth(), bg.getHeight(), Config.ARGB_8888);
 
		Canvas cBg = new Canvas(copyBg);
		Paint  p = new Paint();
		cBg.drawBitmap(bg, 0, 0, p);
 
		Canvas c = new Canvas(copyBg);
		Rect   r = new Rect(topX, topY, overlay.getWidth() + topX, overlay.getHeight() + topY);
 
		c.drawBitmap(overlay, null, r, p);
 
		return copyBg;
	}
 
	/**
	 * Creates a Bitmap having a number overlayed.
	 */
	static Bitmap decodeResourceOverlayingWithNumber(Resources resources, int id, int number) {
		final int width = 15;
		final int height = 15;
		final float roundPx = 7;
		final int bgColor = 0xffff0000;
		final int fgColor = 0xff000000;
		String text = "" + number;
 
		Bitmap numberBitmap = Bitmap.createBitmap(width, height, Config.ARGB_8888);
 
		Canvas c = new Canvas(numberBitmap);
		Paint  p = new Paint();
		Rect   r = new Rect(0, 0, width, height);
 
		final RectF rectF = new RectF(r);
 
		p.setColor(bgColor);
		c.drawRoundRect(rectF, roundPx, roundPx, p);
		p.setColor(fgColor);
 
		Rect bounds = new Rect();
		p.getTextBounds(text, 0, text.length(), bounds);
 
		c.drawText(
			text,
			0, text.length(),
			- (bounds.right/2) + (width/2), - (bounds.top/2) + (height/2),
			p);
 
		return decodeResourceOverlaying(resources, id, numberBitmap);
	}
}