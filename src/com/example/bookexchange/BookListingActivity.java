package com.example.bookexchange;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class BookListingActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_book_listing);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.book_listing, menu);
		return true;
	}

}
