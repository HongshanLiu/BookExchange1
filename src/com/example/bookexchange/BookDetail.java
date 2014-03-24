package com.example.bookexchange;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

public class BookDetail extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_book_detail);
		
		Intent intent = getIntent();
		String value = intent.getStringExtra("ISBNkey");
		String bookName = intent.getStringExtra("nameKey");
		String price = intent.getStringExtra("priceKey");
		
		TextView t = (TextView)findViewById(R.id.bookTitleTag);
		t.setText(bookName);
		
		TextView t1 = (TextView)findViewById(R.id.isbn);
		t1.setText(value);
		
		TextView t2 = (TextView)findViewById(R.id.price);
		t2.setText(price);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.book_detail, menu);
		return true;
	}

}
