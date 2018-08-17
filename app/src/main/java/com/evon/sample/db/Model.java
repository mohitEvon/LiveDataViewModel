package com.evon.sample.db;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import java.util.Date;

@Entity
public class Model {

    @PrimaryKey(autoGenerate = true)
    public int id;
    private String itemName;
    private String personName;


    public Model(String itemName, String personName) {
        this.itemName = itemName;
        this.personName = personName;
    }

    public String getItemName() {
        return itemName;
    }

    public String getPersonName() {
        return personName;
    }

}
