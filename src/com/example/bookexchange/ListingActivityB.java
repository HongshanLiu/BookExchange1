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
import android.widget.ListView;
import android.widget.Toast;

public class ListingActivityB extends ListActivity {

	
	protected Map<String,BookForSale> bookList = new HashMap<String,BookForSale>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_listing_activity_b);
		
		//add stuff to the bookList 
		BookForSale a = new BookForSale("Harry Poter","12345","author A","X",30);
		BookForSale a1 = new BookForSale("The Great Gatsby","1123","author B","The Great Gatsby, seller: Junyi Wang",20);
		
		bookList.put(a.getSaleId(), a);
		bookList.put(a1.getSaleId(),a1);
		

		ArrayList<BookForSale> bookNames = new ArrayList<BookForSale>();
		
		for (Map.Entry<String, BookForSale> entry : bookList.entrySet()) {
		    String key = entry.getKey();
		    BookForSale value = entry.getValue();
		    bookNames.add(value);
		    
		}
		Log.i("fail2","fail2");
		Log.i(bookNames.get(1).getTitle(),"fail" + bookNames.get(1).getTitle());
		
		


		BookAdapter adapter = new BookAdapter(this, bookNames);
		// Attach the adapter to a ListView
		ListView list = getListView();
		ListView listView = (ListView) list;
		listView.setAdapter(adapter);
		setListAdapter(adapter);
		
		
		
	}
	
	
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		Log.i("alex","alex");
		Object o =  this.getListAdapter().getItem(position);
		BookForSale bookObject = (BookForSale) o;
		String a = bookObject.getTitle();
		Log.i("alex","alex"+a);
		

		Intent intent = new Intent(ListingActivityB.this, BookDetail.class);
//		intent.putExtra("key", book);

		String isbn = bookObject.getISBN();
		int price1 = (bookObject.getPrice());
		String price = Integer.toString(price1);
		String bookName = bookObject.getTitle();

		intent.putExtra("ISBNkey", isbn);
		intent.putExtra("priceKey", price);
		intent.putExtra("nameKey", bookName);
		
		startActivity(intent);

	}

	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.listing_activity_b, menu);
		return true;
	}

}
