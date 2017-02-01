package com.ahmetmatematikci.contentprovider;

import android.app.ListActivity;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        baglantilar();
    }

    private void baglantilar() {

        final Cursor baglantiCursor = getContentResolver().query(ContactsContract.Contacts.CONTENT_URI,
                new String[]{
                        ContactsContract.PhoneLookup._ID, ContactsContract.PhoneLookup.DISPLAY_NAME}, null,null,null);

        if (baglantiCursor == null){
            return;
        }

        startManagingCursor(baglantiCursor);
        SimpleCursorAdapter baglantiAdapter = new SimpleCursorAdapter(this, android.R.layout.simple_expandable_list_item_1, baglantiCursor,
                new String[]{ContactsContract.PhoneLookup.DISPLAY_NAME},
                new int[]{android.R.id.text1});

        setListAdapter(baglantiAdapter);
    }
}
