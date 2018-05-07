package com.bmpl.mansiappproject

import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract
import android.support.v7.app.AppCompatActivity
import android.view.View

class MainActivity : AppCompatActivity() {

    val CONTACTS_REQUEST = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun buttonClicked(view : View){
        var intent = Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI)
        intent.type = ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE;
        startActivityForResult(intent, CONTACTS_REQUEST)
    }


//    public fun onActivityResult(int reqCode, int resultCode, Intent data) {
//        super.onActivityResult(reqCode, resultCode, data);
//        switch (reqCode) {
//            case (REQUEST_CODE):
//            if (resultCode == Activity.RESULT_OK) {
//                Uri contactData = data.getData();
//                Cursor c = getContentResolver().query(contactData, null, null, null, null);
//                if (c.moveToFirst()) {
//                    String contactId = c.getString(c.getColumnIndex(ContactsContract.Contacts._ID));
//                    String hasNumber = c.getString(c.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER));
//                    String num = "";
//                    if (Integer.valueOf(hasNumber) == 1) {
//                        Cursor numbers = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = " + contactId, null, null);
//                        while (numbers.moveToNext()) {
//                            num = numbers.getString(numbers.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
//                            Toast.makeText(MainActivity.this, "Number="+num, Toast.LENGTH_LONG).show();
//                        }
//                    }
//                }
//                break;
//            }
//        }
// }

}
