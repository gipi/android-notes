[class to download remote resources and implemente Observer pattern and a simple extension of ImageView that use it.](https://gist.github.com/gipi/1393709)

Create preferences
------------------

```python
package com.example.android;

import android.preference.PreferenceActivity;
import android.os.Bundle;


public class Preference extends PreferenceActivity {
	@Override
	public void onCreate(Bundle b) {
		super.onCreate(b);

                // so we link this preferences with this name
                // and we can edit that with SharedPreferences.Editor instance
		getPreferenceManager()
			.setSharedPreferencesName(MyApplication.PREFS_NAME);
		addPreferencesFromResource(R.xml.preferences);
	}
}
```