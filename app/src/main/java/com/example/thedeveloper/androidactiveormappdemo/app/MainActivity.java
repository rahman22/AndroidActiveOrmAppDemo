package com.example.thedeveloper.androidactiveormappdemo.app;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.activeandroid.query.Select;
import com.example.thedeveloper.androidactiveormappdemo.R;
import com.example.thedeveloper.androidactiveormappdemo.adapter.SubjectAdapter;
import com.example.thedeveloper.androidactiveormappdemo.models.SubjectList;

import java.util.ArrayList;
import java.util.List;

import es.dmoral.toasty.Toasty;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    ListView listView;
    SubjectAdapter adapter;
    ArrayList<SubjectList> subjectLists;
    SubjectList subjects;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        toolbar.setTitle("List Of Subjects");
        toolbar.inflateMenu(R.menu.main_menu);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                switch (item.getItemId()) {

                    case R.id.menu_add:
                        startActivity(new Intent(MainActivity.this, AddActivity.class));
                        break;

                }

                return true;
            }
        });

        listView = (ListView) findViewById(R.id.my_subjects);
        subjectLists = new ArrayList<>();
        subjects = new SubjectList();
        List<SubjectList> myList = getAll();
        for (int i = 0; i < myList.size(); i++) {

            subjects = myList.get(i);
            subjectLists.add(subjects);
        }

        adapter = new SubjectAdapter(MainActivity.this, subjectLists);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {

                List<SubjectList> myList = getAll();
                subjects = myList.get(position);
                final Dialog dialog = new Dialog(MainActivity.this, R.style.DialogTheme);
                dialog.setTitle("Edit Subject");
                dialog.setCanceledOnTouchOutside(true);
                dialog.setContentView(R.layout.edit_subject_layout);
                final EditText names = (EditText) dialog.findViewById(R.id.updatenameeditText);
                final EditText dec = (EditText) dialog.findViewById(R.id.updatedescriptioneditText);
                Button editBtn = (Button) dialog.findViewById(R.id.updateButton);
                names.setText(subjects.getNameSubject());
                dec.setText(subjects.getDescriptionSubject());

                editBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String subject_names = names.getText().toString();
                        String sub_dec = dec.getText().toString();
                        subjects.setNameSubject(subject_names);
                        subjects.setDescriptionSubject(sub_dec);
                        subjects.save();
                        subjectLists.remove(position);
                        subjectLists.add(subjects);
                        Toasty.info(MainActivity.this, "Edit Successfully", 1).show();
                        listView.setAdapter(adapter);
                        adapter.notifyDataSetChanged();
                        dialog.hide();

                    }
                });
                dialog.show();

            }
        });


        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                subjects = subjectLists.get(position);
                subjects.delete();
                subjectLists.remove(position);
                Toasty.info(MainActivity.this, "Delete Successfully", 1).show();
                listView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
                return true;
            }
        });

    }


    public static List<SubjectList> getAll() {
        return new Select()
                .from(SubjectList.class)
                .execute();
    }

}
