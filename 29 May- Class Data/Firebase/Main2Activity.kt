package com.bmpl.android.firebasedemo_java

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import com.google.android.gms.tasks.OnFailureListener
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import kotlinx.android.synthetic.main.activity_main2.*
import java.io.File


class Main2Activity : AppCompatActivity() {

    lateinit var storageReference : StorageReference
    lateinit private var nameOfFile: String
    lateinit var riversRef : StorageReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        storageReference = FirebaseStorage.getInstance().getReferenceFromUrl("gs://fir-demo-26e13.appspot.com/myimages") // by default it will fetch the root ref of storage

               // .getReferenceFromUrl("gs://fir-demo-26e13.appspot.com/myimages/document")

        uploadButton.setOnClickListener {
            // Implicit Intent
            var intent = Intent(Intent.ACTION_OPEN_DOCUMENT) //Document --> pdf, .doc, .jpg
            intent.type = "image/jpeg" //MIME Type --> Implicit Intent

            // src --> destination(document) --> result(image) --> further(location) --> image upload

            startActivityForResult(intent, 1) // camera --> Activity --> 2 requrest
            // to identify every request uniquely
            // --> Response --> Predefined method
        }

        downloadButton.setOnClickListener {
            val localFile = File.createTempFile("4955", "jpg")
            riversRef.getFile(localFile)
                    .addOnSuccessListener({
                        Toast.makeText(this@Main2Activity, "File Downloaded", Toast.LENGTH_SHORT).show()
                    }).addOnFailureListener(OnFailureListener {
                        Toast.makeText(this@Main2Activity, "Unable to download", Toast.LENGTH_SHORT).show()
                    })
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, intent: Intent?) {
        super.onActivityResult(requestCode, resultCode, intent)

        // Universal Keys --> Android OS --> Implicit Intent -->
        if(requestCode==1 && resultCode == Activity.RESULT_OK){
            // path "c://program/java/jdk/bin"
            // uri --> path dealing --> android or url --> path
            val uri : Uri = intent!!.data   // data fetching through implicit intent
            nameOfFile = uri.path

            Log.d("WelcomeActivity", "name = " + nameOfFile + "uri data= " + uri)
                        // myimages/document/4955.jpeg
            riversRef = storageReference.child(nameOfFile)

            riversRef.putFile(uri)
                    .addOnSuccessListener(
                            {
                                Toast.makeText(this@Main2Activity, "Uploaded", Toast.LENGTH_LONG).show()
                            }
                    )
                    .addOnFailureListener({ exception ->
                        Toast.makeText(this@Main2Activity, "Error Occurred" + exception.message, Toast.LENGTH_LONG).show()
                        Log.d("WelcomeActivity", exception.message)
                    })
        }
    }
}