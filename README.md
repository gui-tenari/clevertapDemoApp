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
Connect a device or start an emulator

Click "Run"

🧪 Screenshots
Below you can add screenshots to demonstrate that the app is working:

✅ ###User on CleverTap Panel
![image](https://github.com/user-attachments/assets/9741e91d-4e23-4241-9aee-38845d3185b8)

🛍 ###Product View Event Sent
![image](https://github.com/user-attachments/assets/d76722a2-a5d7-4994-975e-2685c9948257)

💌 ###Push Message Sent
![image](https://github.com/user-attachments/assets/34ee1bb0-3b78-4697-bfe9-9e9904597b45)

![image](https://github.com/user-attachments/assets/80c4ce38-94e1-4608-825c-ee87fe2646f4)


🛠 ###Technologies
Kotlin

Jetpack Compose

CleverTap Android SDK

Firebase (for push configuration)

📬 ###Contact
For any questions or feedback, feel free to open an issue or contact me directly.

guilherme.tenarie@gmail.com
