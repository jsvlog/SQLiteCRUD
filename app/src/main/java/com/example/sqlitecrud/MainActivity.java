package com.example.sqlitecrud;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    RecyclerView recycler;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycler = findViewById(R.id.recycler);
        fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addValueRecyclerView();
            }
        });

    }



    private void addValueRecyclerView() {
        AlertDialog.Builder myDialog = new AlertDialog.Builder(this);
        LayoutInflater inflater = LayoutInflater.from(this);

        View myView =inflater.inflate(R.layout.adding_recyclerview,null);
        myDialog.setView(myView);

        AlertDialog dialog = myDialog.create();
        dialog.show();

        Button btnadd, btnCancel;
        EditText edtName, edtAge, edtCourse, edtEmail;

        btnadd = myView.findViewById(R.id.btnAdd);
        btnCancel = myView.findViewById(R.id.btnCancel);
        edtName = myView.findViewById(R.id.studentName);
        edtAge = myView.findViewById(R.id.studentAge);
        edtCourse = myView.findViewById(R.id.studentCourse);
        edtEmail = myView.findViewById(R.id.studentEmail);


        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String studentName = edtName.getText().toString();
                int studentAge = Integer.parseInt(edtAge.getText().toString());
                String studentCourse = edtCourse.getText().toString();
                String studentEmail = edtEmail.getText().toString();


                StudentModel studentModel = new StudentModel(studentName,studentCourse,studentEmail,studentAge);

                DatabaseHelper databaseHelper = new DatabaseHelper(MainActivity.this,"SB",null,1);
                try {
                    databaseHelper.addOne(studentModel);
                    Toast.makeText(MainActivity.this, "success", Toast.LENGTH_SHORT).show();
                }catch (Exception e){
                    Toast.makeText(MainActivity.this, "failed", Toast.LENGTH_SHORT).show();
                }


                }
        });



        }
    }
