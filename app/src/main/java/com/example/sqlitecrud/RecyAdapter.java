package com.example.sqlitecrud;

import android.content.Context;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyAdapter extends RecyclerView.Adapter<RecyAdapter.myViewholder> {

    List<StudentModel> students;
    Context context;

    public RecyAdapter(List<StudentModel> students, Context context) {
        this.students = students;
        this.context = context;
    }

    //this is for auto refresh
    public void setData(List<StudentModel> newData) {
        this.students = newData;

        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public myViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_for_recyclerview,parent,false);
        return new myViewholder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull myViewholder holder, int position) {
        StudentModel model = students.get(holder.getAdapterPosition());

        String ageString = String.valueOf(model.getAge());
        holder.age.setText(ageString);
        holder.name.setText(model.getName().toString());
        holder.course.setText(model.getCourse().toString());
        holder.email.setText(model.getEmail().toString());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseHelper databaseHelper = new DatabaseHelper(context,"SB",null,1);
                databaseHelper.deleteOne(model.get);
            }
        });


    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    public class myViewholder extends RecyclerView.ViewHolder {

        TextView name, age, course, email;

        public myViewholder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.nameRecyclerview);
            age = itemView.findViewById(R.id.ageRecyclerview);
            course = itemView.findViewById(R.id.courseRecyclerview);
            email = itemView.findViewById(R.id.emailRecyclerview);
        }
    }
}
