package com.example.swedatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button add;
    EditText title , date ,time,location,type,des;



    Database db=new Database( this );
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        title= (EditText) findViewById(R.id.title);
        date= (EditText)findViewById(R.id.date);
        time= (EditText)findViewById(R.id.time);
        location=(EditText) findViewById(R.id.location);
        type= (EditText)findViewById(R.id.type);
        des= (EditText)findViewById(R.id.des);


        add=findViewById(R.id.add);



        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (title.length()==0)
                    title.setError("Enter title") ;
                else if (date.length()==0)
                    date.setError("Enter date") ;
                else if (time.length()==0)
                    time.setError("Enter time") ;
                else if (location.length()==0)
                    location.setError("Enter location") ;
                else if (type.length()==0)
                    type.setError("Enter type") ;
                else if (des.length()==0)
                    des.setError("Enter description") ;

                Event Event1;
                Database db;
                try {

                    Event1 = new Event(title.getText().toString(), Integer.parseInt(date.getText().toString()), Integer.parseInt(time.getText().toString()), location.getText().toString(), type.getText().toString(), des.getText().toString());


                }
                catch (Exception e) {
                    Toast.makeText(MainActivity.this, "Error creating event!", Toast.LENGTH_SHORT).show();
                    Event1=new Event("one",3,4,"ksu","gaming","not new event");
                }

                db = new Database(MainActivity.this);

                boolean success = db.addEvent(Event1);
                if(success)
                    Toast.makeText(MainActivity.this, success+" [The event was added successfully]", Toast.LENGTH_SHORT).show();
                else{
                    Toast.makeText(MainActivity.this, success+" [The event was not added successfully]", Toast.LENGTH_SHORT).show();
                }
            }
    });
}


}
