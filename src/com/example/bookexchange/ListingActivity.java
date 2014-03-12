package com.example.bookexchange;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListingActivity extends ListActivity {
	

	protected Map<String,BookForSale> bookList = new HashMap<String,BookForSale>();
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_listing);
		
		//add stuff to the bookList 
		BookForSale a = new BookForSale("Harry Poter","1234","Harry Poter, seller: Hongshan Liu",25);
		BookForSale a1 = new BookForSale("The Great Gatsby","1123","The Great Gatsby, seller: Junyi Wang",20);
		
		bookList.put(a.getSaleId(), a);
		bookList.put(a1.getSaleId(),a1);
		
		ArrayList<String> bookNames = new ArrayList<String>();
		
		for (Map.Entry<String, BookForSale> entry : bookList.entrySet()) {
		    String key = entry.getKey();
		    BookForSale value = entry.getValue();
		    bookNames.add(value.getSaleId());
		    
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
//		intent.putExtra("key", book);
		
		BookForSale bookObject = bookList.get(book);
		String isbn = bookObject.getISBN();
		int price1 = (bookObject.getPrice());
		String price = Integer.toString(price1);
		String bookName = bookObject.getName();
		
		intent.putExtra("ISBNkey", isbn);
		intent.putExtra("priceKey", price);
		intent.putExtra("nameKey", bookName);
		
		startActivity(intent);
	}
	

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.listing, menu);
		return true;
	}

}
