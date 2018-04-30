package com.androidchatapp;

public class MessyDbSchema {
    public static final class ProfileTable {
        public static final String NAME = "profile";

        public static final class Profile {
            public static final String UUID = "uuid";
            public static final String USERID = "userid";
            public static final String PASSWORD = "password";
            public static final String PIC = "profilepic";
        }
    }

    public static final class MessagesTable {
        public static final String NAME = "messages";

        public static final class Messages {
            public static final String UUID = "uuid";
            public static final String MESSAGE = "message";
            public static final String NICKNAME = "nickname";
            public static final String SENT = "sentstatus";
            public static final String TIME = "timesent";
            public static final String LOCATION = "location";
        }
    }
}