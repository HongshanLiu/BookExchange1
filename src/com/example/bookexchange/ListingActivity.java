package com.example.bookexchange;

import java.util.ArrayList;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ListingActivity extends ListActivity {
	

	protected ArrayList<Book> bookList = new ArrayList<Book>();
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_listing);
		
		//add stuff to the bookList 
		Book a = new Book("Harry Poter","123");
		Book a1 = new Book("The Great Gatsby","1123");
		
		bookList.add(a);
		bookList.add(a1);
		
		ArrayList<String> bookNames = new ArrayList<String>();
		
		for (int i = 0; i < bookList.size(); i++) {
			bookNames.add(bookList.get(i).getName());
			
		}
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, bookNames);
		setListAdapter(adapter);
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		Object o = this.getListAdapter().getItem(position);
		String book = o.toString();
		Toast.makeText(this, "you have chosen the book" + " " + book, Toast.LENGTH_LONG).show();
		
		Intent intent = new Intent(ListingActivity.this, BookDetail.class);
		intent.putExtra("key", book);
		startActivity(intent);
	}
	

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.listing, menu);
		return true;
	}

}
