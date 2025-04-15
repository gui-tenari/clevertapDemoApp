# CleverTap Demo Application

This is a simple Android demo application built with Jetpack Compose and CleverTap SDK integration.  
It demonstrates:

- How to trigger a CleverTap user login
- How to retrieve the CleverTap ID
- How to send a "Product Viewed" event with properties to CleverTap

---

## 📱 Features

### ✅ Login Button
- Prompts the user to input their email
- Validates the format
- Sends a `onUserLogin` event to CleverTap with the email as a profile property

### ✅ Get CleverTap ID Button
- Retrieves and displays the unique CleverTap ID for the current user session

### ✅ Send Product View Event Button
- Sends a `Product Viewed` event to CleverTap with the following properties:
  - Product ID: `1`
  - Product Image:  
    `https://d35fo82fjcw0y8.cloudfront.net/2018/07/26020307/customer-success-clevertap.jpg`
  - Product Name: `CleverTap`

---

## 🚀 How to Run

1. Clone this repository:
   ```bash
   git clone https://github.com/your-username/clevertap-demo-app.git
Open the project in Android Studio

Add your google-services.json to the app/ directory
(This file can be downloaded from your Firebase Console)

Make sure your AndroidManifest.xml includes the CleverTap FCM service:

xml
Copiar
Editar
<service
    android:name="com.clevertap.android.sdk.pushnotification.fcm.FcmMessageListenerService"
    android:exported="true">
    <intent-filter>
        <action android:name="com.google.firebase.MESSAGING_EVENT" />
    </intent-filter>
</service>
Connect a device or start an emulator

Click "Run" or use:

bash
Copiar
Editar
./gradlew installDebug
🧪 Screenshots
Below you can add screenshots to demonstrate that the app is working:

✅ Login Sent to CleverTap

📩 CleverTap ID Displayed

🛍 Product View Event Sent

🛠 Technologies
Kotlin

Jetpack Compose

CleverTap Android SDK

Firebase (for push configuration)

📬 Contact
For any questions or feedback, feel free to open an issue or contact me directly.

yaml
Copiar
Editar

---

Se quiser, posso personalizar ainda mais esse readme com seu nome de usuário do GitHub ou com links diretos 
