package com.example.fastsms.app;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class Contacts {
    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField(unique = true)
    private Contact contact;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }
}
