package com.vinayak09.wsafety;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class RegisterNumberActivity extends AppCompatActivity {

    private EditText nameEdit, numberEdit;
    private Button saveButton;
    private ListView contactListView;
    private ArrayList<String> contacts;
    private ArrayAdapter<String> adapter;

    private static final String PREFS_NAME = "EmergencyContacts";
    private static final String CONTACTS_KEY = "contacts";
    private static final String DEFAULT_NAME = "Naveen";
    private static final String DEFAULT_NUMBER = "9677396491";  // Default contact

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_number);

        nameEdit = findViewById(R.id.nameEdit);
        numberEdit = findViewById(R.id.numberEdit);
        saveButton = findViewById(R.id.saveButton);
        contactListView = findViewById(R.id.contactList);

        contacts = loadContacts();

        // Ensure default contact is always present
        if (!contacts.contains(DEFAULT_NAME + ": " + DEFAULT_NUMBER)) {
            contacts.add(0, DEFAULT_NAME + ": " + DEFAULT_NUMBER);
            saveContactsToPreferences();
        }

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, contacts);
        contactListView.setAdapter(adapter);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveContact();
            }
        });

        contactListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                showEditDeleteDialog(position);
                return true;
            }
        });
    }

    private void saveContact() {
        String name = nameEdit.getText().toString().trim();
        String number = numberEdit.getText().toString().trim();

        if (name.isEmpty() || number.isEmpty()) {
            Toast.makeText(this, "Please enter a name and number.", Toast.LENGTH_SHORT).show();
            return;
        }

        if (contacts.size() >= 3) {
            Toast.makeText(this, "You can only add 3 emergency contacts.", Toast.LENGTH_SHORT).show();
            return;
        }

        for (String contact : contacts) {
            if (contact.contains(number)) {
                Toast.makeText(this, "This contact is already added.", Toast.LENGTH_SHORT).show();
                return;
            }
        }

        contacts.add(name + ": " + number);
        adapter.notifyDataSetChanged();
        saveContactsToPreferences();

        // Clear input fields after saving
        nameEdit.setText("");
        numberEdit.setText("");

        Toast.makeText(this, "Contact saved successfully!", Toast.LENGTH_SHORT).show();
    }

    private void showEditDeleteDialog(int position) {
        String selectedContact = contacts.get(position);

        // If default contact, disable edit and delete
        if (selectedContact.equals(DEFAULT_NAME + ": " + DEFAULT_NUMBER)) {
            Toast.makeText(this, "This contact cannot be edited or deleted.", Toast.LENGTH_SHORT).show();
            return;
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Edit or Delete Contact")
                .setItems(new CharSequence[]{"Edit", "Delete"}, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (which == 0) {
                            editContact(position);
                        } else {
                            removeContact(position);
                        }
                    }
                })
                .show();
    }

    private void editContact(int position) {
        String contact = contacts.get(position);
        String[] parts = contact.split(": ");
        String oldName = parts[0];
        String oldNumber = parts[1];

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Edit Contact");

        View view = getLayoutInflater().inflate(R.layout.dialog_edit_contact, null);
        EditText editName = view.findViewById(R.id.editName);
        EditText editNumber = view.findViewById(R.id.editNumber);

        editName.setText(oldName);
        editNumber.setText(oldNumber);

        builder.setView(view);
        builder.setPositiveButton("Save", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String newName = editName.getText().toString().trim();
                String newNumber = editNumber.getText().toString().trim();

                if (newName.isEmpty() || newNumber.isEmpty()) {
                    Toast.makeText(RegisterNumberActivity.this, "Name or Number cannot be empty", Toast.LENGTH_SHORT).show();
                    return;
                }

                contacts.set(position, newName + ": " + newNumber);
                adapter.notifyDataSetChanged();
                saveContactsToPreferences();
                Toast.makeText(RegisterNumberActivity.this, "Contact updated successfully!", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("Cancel", null);
        builder.show();
    }

    private void removeContact(int position) {
        contacts.remove(position);
        adapter.notifyDataSetChanged();
        saveContactsToPreferences();
        Toast.makeText(this, "Contact removed.", Toast.LENGTH_SHORT).show();
    }

    private ArrayList<String> loadContacts() {
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        Set<String> contactSet = prefs.getStringSet(CONTACTS_KEY, new HashSet<>());
        return new ArrayList<>(contactSet);
    }

    private void saveContactsToPreferences() {
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        Set<String> contactSet = new HashSet<>(contacts);
        editor.putStringSet(CONTACTS_KEY, contactSet);
        editor.apply();
    }
}
