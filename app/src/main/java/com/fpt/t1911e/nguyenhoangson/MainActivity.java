package com.fpt.t1911e.nguyenhoangson;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.fpt.t1911e.nguyenhoangson.database.AppDatabase;
import com.fpt.t1911e.nguyenhoangson.database.FeedbackEntity;

public class MainActivity extends AppCompatActivity {
    private EditText edName;
    private EditText edEmail;
    private EditText edDesc;
    private Button btFeedback;
    private CheckBox ckBox;
    private Spinner spSelect;

    AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db= AppDatabase.getAppDatabase(this);
        initData();
    }


    private void initData(){
        edName = findViewById(R.id.edName);
        edEmail = findViewById(R.id.edEmail);
        edDesc = findViewById(R.id.edDesc);
        btFeedback = findViewById(R.id.btFeedback);
        ckBox = findViewById(R.id.ckBox);
        spSelect = findViewById(R.id.spSelect);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.selection, android.R.layout.simple_spinner_dropdown_item);
        spSelect.setAdapter(adapter);
        btFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SaveData();

            }
        });

    }

    private void SaveData(){
        final String name = edName.getText().toString();
        final String email = edEmail.getText().toString();
        final String select = spSelect.getSelectedItem().toString();
        final String desc = edDesc.getText().toString();
        if (name.isEmpty()) {
            edName.setError("Name is required");
            edName.requestFocus();
            return;
        }
        if (email.isEmpty()) {
            edEmail.setError("Name is required");
            edEmail.requestFocus();
            return;
        }
        if (desc.isEmpty()) {
            edDesc.setError("Please type something");
            edDesc.requestFocus();
            return;
        }
        FeedbackEntity feedEntity = new FeedbackEntity();
        feedEntity.setName(name);
        feedEntity.setEmail(email);
        feedEntity.setSelection(select);
        feedEntity.setDesc(desc);

        //add
        db.feedbackDao().insertFeedback(feedEntity);
        Toast.makeText(this,"send feedback successful",Toast.LENGTH_LONG).show();

        Intent intent = new Intent(MainActivity.this,ListFeedActitivy.class);
        startActivity(intent);

    }

}