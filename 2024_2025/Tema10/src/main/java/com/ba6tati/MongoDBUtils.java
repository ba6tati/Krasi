package com.ba6tati;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MongoDBUtils {
    private static final String CONNECTION_STRING = "mongodb://localhost:27017";
    private static final String DATABASE_NAME = "testdb";

    public static MongoDatabase getDatabase() {
        MongoDatabase db = null;
        try {
            MongoClient mongoClient = MongoClients.create(CONNECTION_STRING); // създава връзка
            db = mongoClient.getDatabase(DATABASE_NAME); // свързва се към базата с конкретно име
            System.out.println("INFO: Connection to database " + DATABASE_NAME + " established successfully");
        } catch (Exception e) {
            System.out.println("EXCEPTION: Connection to database failed: " + e.getMessage());
        }

        return db;
    }
}
