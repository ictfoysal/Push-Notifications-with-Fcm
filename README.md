# Push Notifications with FCM

This Android application demonstrates the implementation of push notifications using Firebase Cloud Messaging (FCM).

## Project Overview

The project consists of an Android app that allows the user to click a button to change the text in a TextView and send a test push notification using FCM.

## Requirements

- Android Studio
- Firebase account and project setup

## Installation and Setup

1. Clone the repository or download the source code.
2. Open the project in Android Studio.
3. Connect your Android device or start an emulator.
4. Build and run the application on the device/emulator.

## Design Decisions

- Language: The project is developed using Java, which is a widely used language for Android development. It provides good compatibility and a large community of developers.
- User Interface: The UI consists of a button and a TextView. The button allows the user to change the text in the TextView, while the TextView displays the current text.
- FCM Integration: Firebase Cloud Messaging is used for sending push notifications. The project includes the necessary dependencies and code to retrieve the FCM registration token and subscribe to a global topic. However, the actual push notification sending part is simulated by making an HTTP request to a PHP script.

## Usage

1. Launch the application on your Android device/emulator.
2. Click the "Click Me" button to change the text in the TextView to "Hello, World!".
3. Enter the notification details (title, message, article data, image URL) in the respective fields.
4. Click the "Send Notification" button to send a test push notification.
5. Check the logcat for the FCM registration token and the result of the push notification request.

Note: For the actual push notification to work, you need to set up your own Firebase project and configure the necessary Firebase settings and credentials. Update the PHP script URL in the `sendNotification()` method to the appropriate endpoint in your server.

## License

This project is licensed under the [MIT License](LICENSE).

---

Feel free to customize the README file based on your specific project details and requirements.
