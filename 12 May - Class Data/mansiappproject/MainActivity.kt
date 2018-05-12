package com.bmpl.mansiappproject

import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    // In separate class --> variables --> 20-25 keys
    val CONTACTS_REQUEST = 1 // key identify unique request  --> contacts - 1,  gallery images - 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        contact3.setOnClickListener {  }
    }

    fun buttonClicked(view : View){
                            // action --> what to do
        var intent = Intent(Intent.ACTION_PICK, ContactsContract.CommonDataKinds.Phone.CONTENT_URI)
        startActivityForResult(intent, CONTACTS_REQUEST)
    }


    fun cameraAccess(){
        var intent = Intent()
        startActivityForResult(intent, 12)
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        var uri = data!!.data // path + TableName --> select * from TableName
                                                    // select Column_name from TableName where name="Ram" DESC
                    // contentprovider --> type
        // select
        // Cursor -->  interface
        var cursor = contentResolver.query(uri, null, null, null, null)
                                                      // 1
        var displayName = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME))
        var number = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))

        Log.i("name", displayName)
        Log.i("number", number)

        cursor.close()
    }



}
