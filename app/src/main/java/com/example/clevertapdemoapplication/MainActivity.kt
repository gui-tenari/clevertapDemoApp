package com.example.clevertapdemoapplication

import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.clevertap.android.sdk.CleverTapAPI
import com.example.clevertapdemoapplication.ui.theme.CleverTapDemoApplicationTheme
import java.util.*

class MainActivity : ComponentActivity() {

    private var cleverTapDefaultInstance: CleverTapAPI? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        cleverTapDefaultInstance = CleverTapAPI.getDefaultInstance(applicationContext)
        if (cleverTapDefaultInstance == null) {
            Log.e("CleverTap", "CleverTap instance is null. Check configuration.")
        } else {
            Log.i("CleverTap", "CleverTap initialized successfully!")
        }

        setContent {
            CleverTapDemoApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LoginScreen(
                        onLoginClick = { email -> sendCleverTapLogin(email) },
                        getCleverTapId = { cleverTapDefaultInstance?.cleverTapID ?: "Unavailable" },
                        onProductViewClick = { sendProductViewEvent() }
                    )
                }
            }
        }
    }

    private fun sendCleverTapLogin(email: String) {
        val profileUpdate = HashMap<String, Any>()
        profileUpdate["Email"] = email
        cleverTapDefaultInstance?.onUserLogin(profileUpdate)
        Log.i("CleverTap", "onUserLogin sent successfully with $email")
        Toast.makeText(this, "Login enviado para CleverTap!", Toast.LENGTH_SHORT).show()
    }

    private fun sendProductViewEvent() {
        val eventProps = HashMap<String, Any>()
        eventProps["Product ID"] = 1
        eventProps["Product Image"] = "https://d35fo82fjcw0y8.cloudfront.net/2018/07/26020307/customer-success-clevertap.jpg"
        eventProps["Product Name"] = "CleverTap"

        cleverTapDefaultInstance?.pushEvent("Product Viewed", eventProps)
        Log.i("CleverTap", "Product Viewed event sent with: $eventProps")
        Toast.makeText(this, "Event sent!", Toast.LENGTH_SHORT).show()
    }
}

@Composable
fun LoginScreen(
    onLoginClick: (String) -> Unit,
    getCleverTapId: () -> String,
    onProductViewClick: () -> Unit
) {
    var email by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf("") }
    var successMessage by remember { mutableStateOf("") }
    var cleverTapId by remember { mutableStateOf<String?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Welcome to CleverTap App demo!",
            style = MaterialTheme.typography.headlineSmall
        )
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = email,
            onValueChange = {
                email = it
                errorMessage = ""
                successMessage = ""
            },
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth()
        )

        if (errorMessage.isNotEmpty()) {
            Text(text = errorMessage, color = MaterialTheme.colorScheme.error)
        }

        if (successMessage.isNotEmpty()) {
            Text(text = successMessage, color = MaterialTheme.colorScheme.primary)
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    errorMessage = "Invalid format."
                } else {
                    onLoginClick(email)
                    successMessage = "Login completed!"
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Login")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { cleverTapId = getCleverTapId() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Get CleverTap ID")
        }

        cleverTapId?.let {
            Spacer(modifier = Modifier.height(8.dp))
            Text("CleverTap ID: $it")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { onProductViewClick() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Product View")
        }
    }
}
