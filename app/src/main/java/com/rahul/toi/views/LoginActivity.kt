package com.rahul.toi.views

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.rahul.toi.R

class LoginActivity : AppCompatActivity() {
//    private var mGoogleSignInClient: GoogleSignInClient? = null
    private val RC_SIGN_IN = 100
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
//        val gso =
//            GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
//                .requestEmail()
//                .build()
//        mGoogleSignInClient = GoogleSignIn.getClient(this, gso)
//        val account = GoogleSignIn.getLastSignedInAccount(this)
//        val signInButton = findViewById<SignInButton>(R.id.GoogleSingIn)
//        signInButton.setSize(SignInButton.SIZE_STANDARD)
//        signInButton.setOnClickListener { signIn() }


    }

//    private fun signIn() {
//        val signInIntent = mGoogleSignInClient!!.signInIntent
//        startActivityForResult(signInIntent, com.rahul.toi.views)
//    }
//
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//
//        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
//        if (requestCode == com.example.youtube.Login.RC_SIGN_IN) {
//            val task =
//                GoogleSignIn.getSignedInAccountFromIntent(data)
//            handleSignInResult(task)
//        }
//    }
//
//    private fun handleSignInResult(completedTask: Task<GoogleSignInAccount>) {
//        try {
//            val account =
//                completedTask.getResult(ApiException::class.java)
//            val acct = GoogleSignIn.getLastSignedInAccount(this)
//            if (acct != null) {
//                val personName = acct.displayName
//                val personGivenName = acct.givenName
//                val personFamilyName = acct.familyName
//                val personEmail = acct.email
//                val personId = acct.id
//                val personPhoto = acct.photoUrl
//                Toast.makeText(this, "User email : $personEmail", Toast.LENGTH_SHORT).show()
//            }
//            val intent = Intent(this, EditProfile::class.java)
//            startActivity(intent)
//        } catch (e: ApiException) {
//            Log.d("Sign in Failed", e.toString())
//        }
//    }
    
}