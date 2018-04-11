# CIDM4385FinalProject
Final Project for CIDM4385

For chat application (Messy) we will be using a two table method database scheme. 
One for the user profile and one for the message database. 
UserId and Password will be used to create a profile when first registering for the messaging app. 
The user will be able to choose a nickname to be displayed on the messages. 
The user profile will store items such as 
-UUID 
-USERID 
-PASSWORD 
-NICKNAME (this will be what shows up on the actual message) 
-Profile Picture

The messages database will store items such as 
-UUID 
-NICKNAME 
-SENT (displays whether the message was successfully sent or not) 
-TIME (displays what time the message was sent/recieved) 
-LOCATION (will display where the user sent the message from)

Some basic features of the app include : 
-creating a new user for the app 
-logging in to the server after a user is created 
-use SendBird messaging API 
-send messages back and forth between connected accounts
