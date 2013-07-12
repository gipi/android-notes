- [class to download remote resources and implemente Observer pattern and a simple extension of ImageView that use it.](https://gist.github.com/gipi/1393709)
 - [extend BitmapFactory to overlay images.](https://gist.github.com/gipi/1405176)


**Layout inflating**

```java
import android.view.LayoutInflater;

  LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
  View view = inflater.inflate(R.layout.my_layout, null);
```

Activity starting
-----------------

[source](http://stackoverflow.com/questions/768969/passing-a-bundle-on-startactivity)

    public void startRicettarioActivity(View view) {
        Intent i = new Intent(this, RicettarioActivity.class);
        
        i.putExtra("miao", 5);

        startActivity(i);
    }

Retrieve parameters
-------------------

    public void onCreate(Bundle savedInstanceState) {
    	getIntent().getExtras().getInt("miao");
    }

Filter a SimpleCursorAdapter
----------------------------

in the Fragment/Activity containing the ListView/Adapter

        // this enables the filtering capabilities
        mListView.setTextFilterEnabled(true);
        // pass to the detail when an item is clicked
                ((EditText)getActivity().findViewById(R.id.search_box))
                .addTextChangedListener(new TextWatcher() {

                    public void afterTextChanged(Editable s) {
                    }

                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                    }

                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        android.util.Log.d(TAG, "filter with " + s);
                        // strange enough, if we use mAdapter raise NullPointerException
                        SimpleCursorAdapter adapter = (SimpleCursorAdapter)mListView.getAdapter();
                        adapter.getFilter().filter(s);
                        adapter.notifyDataSetChanged();
                    }
                });

In the adapter

            setFilterQueryProvider(new FilterQueryProvider() {
                @Override
                public Cursor runQuery(CharSequence charSequence) {
                    android.util.Log.d(TAG, "runQuery(): " + charSequence);
                    return new DatabaseMeta(getActivity()).getFilteredRicettario(charSequence.toString());
                }
            });


Create preferences
------------------

```java
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

Fix orientation to portrait
---------------------------

```xml
<application
       ...
       >
       <activity android:name=".HomeActivity"
                  android:label="@string/app_name"
                  android:screenOrientation="portrait"
                  />
```

**Add a telephone number in android contacts not associated with any account on the telephone**

```java
ArrayList<ContentProviderOperation> ops = new ArrayList<ContentProviderOperation>();

ops.add(ContentProviderOperation.newInsert(ContactsContract.RawContacts.CONTENT_URI)
		/*
		 * ACCOUNT_TYPE
		 *
		 * The type of account to which this row belongs, which when paired with ACCOUNT_NAME
		 * identifies a specific account. It should be set at the time the raw contact is
		 * inserted and never changed afterwards.
		 * 
		 * To ensure uniqueness, new account types should be chosen according to the Java
		 * package naming convention. Thus a Google account is of type "com.google".
		 */
				.withValue(ContactsContract.RawContacts.ACCOUNT_TYPE, null)// null to create an unassociated one
				.withValue(ContactsContract.RawContacts.ACCOUNT_NAME, null)
				.build());


		ops.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI)
				.withValueBackReference(ContactsContract.Data.RAW_CONTACT_ID, 0)
				.withValue(ContactsContract.Data.MIMETYPE,
					ContactsContract.CommonDataKinds.StructuredName.CONTENT_ITEM_TYPE)
				.withValue(ContactsContract.CommonDataKinds.StructuredName.DISPLAY_NAME, whatever)
				.build());

		ops.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI)
				.withValueBackReference(ContactsContract.Data.RAW_CONTACT_ID, 0)
				.withValue(ContactsContract.Data.MIMETYPE,
					ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE)
				.withValue(ContactsContract.CommonDataKinds.Phone.NUMBER, mTelephone)
				.withValue(ContactsContract.CommonDataKinds.Phone.TYPE, Contacts.Phones.TYPE_MOBILE)
				.build());
		ContentProviderResult[] cprs = getContentResolver().applyBatch(ContactsContract.AUTHORITY, ops);
```

**Enable javascript and Flash in an Android WebView**

```java
        WebView wv = (WebView)findViewById(R.id.webViewId);
        wv.getSettings().setJavaScriptEnabled(true);
        wv.getSettings().setPluginsEnabled(true);
```

**webview that handles fixed credentials for authentication**

```java
        WebView wv = (WebView)findViewById(R.id.webViewId);

        wv.setWebViewClient(new WebViewClient() {
                public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                        Toast.makeText(EmbedActivity.this, "Oh no! " + description, Toast.LENGTH_SHORT).show();
                }

                public void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler handler, String host, String realm) {
                        handler.proceed("username", "password");
                }
        });

        wv.loadUrl("http://www.example.com/");
```

**Avoid the webview to scroll when inside a scroll view**

```java
/**
 * Inserts into a WebView the htmlContent passed as argument.
 *
 * <b>NOTE:</b> the move touch events are removed.
 */
static public void insertHTML(WebView wv, String htmlContent) {
	 wv.setOnTouchListener(new View.OnTouchListener() {
		public boolean onTouch(View v, MotionEvent event) {
			 return (event.getAction() == MotionEvent.ACTION_MOVE);
		}
	});
	wv.loadData(htmlContent, "text/html", "UTF-8");
}
```