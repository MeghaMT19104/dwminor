package com.example.dwminor;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import java.util.ArrayList;

class MyCustomstudent extends BaseAdapter implements ListAdapter {
    private final ArrayList<String> list;
    private final ArrayList<String> name;
    private final Context context;
    AlertDialog.Builder builder;
    public MyCustomstudent(ArrayList<String> list, Context context,ArrayList<String> name) {
        this.list=list;
        this.context=context;
        this.name = name;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v=view;
        if(v==null)
        {
            LayoutInflater li=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            v=li.inflate(R.layout.list_layout, viewGroup,false);


        }
        TextView t=(TextView)v.findViewById(R.id.sub_name);
        t.setText(list.get(i));
        t.setClickable(true);
        builder = new AlertDialog.Builder(context);
        t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                builder.setMessage("Do you want to drop this course?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                                Toast.makeText(context,"Your selected subject has been dropped",
                                        Toast.LENGTH_SHORT).show();

                                dialog.cancel();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                //  Action for 'NO' Button
                                dialog.cancel();
                                Toast.makeText(context,"OK",
                                        Toast.LENGTH_SHORT).show();
                            }
                        });
                //Creating dialog box
                AlertDialog alert = builder.create();
                //Setting the title manually
                alert.setTitle("DROP SUBJECT");
                alert.show();


            }
        });
        t=(TextView)v.findViewById(R.id.subcode);
        t.setText(name.get(i));
        t.setClickable(true);


        return v;
    }
}
