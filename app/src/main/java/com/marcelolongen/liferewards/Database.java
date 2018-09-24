package com.marcelolongen.liferewards;

import android.os.Environment;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Database {
    private ArrayList<Gift> giftObjects;
    private ArrayList categories;

    public Database() {
        giftObjects = new ArrayList<>();
    }

    private static Database db;

    public ArrayList<Gift> getGiftObjects() {
        return giftObjects;
    }

    public void setItemObjects(ArrayList<Gift> itemObjects) {
        this.giftObjects = giftObjects;
    }

    public ArrayList getCategories() {
        return categories;
    }

    public void setCategories(ArrayList categories) {
        this.categories = categories;
    }


    public static Database getInstance(){
        if (db == null){ //if there is no instance available... create new one
            db = new Database();
        }

        return db;
    }
    private DatabaseReference root;
    private DatabaseReference user;

    public void readContentsFromFile(String userName) {

        root = FirebaseDatabase.getInstance().getReference();
        user = root.child("users").child(userName).child("Expenses");


        user.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot
                                             dataSnapshot) {
                giftObjects.clear();
                for (DataSnapshot giftSnapshot: dataSnapshot.getChildren()) {
                    Gift gift = giftSnapshot.getValue(Gift.class); // {id: .., name: ..., genre: ...)
                    giftObjects.add(0, gift); // add a new artist from DB to an arrayList
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }


}
