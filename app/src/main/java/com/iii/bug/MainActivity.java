package com.iii.bug;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button btnLoginServer, btnBug, btnNormal;
    private EditText edtUsername, edtPassword;
    private TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        setupViewComponent();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void setupViewComponent(){
        btnLoginServer = (Button) findViewById(R.id.btnLoginServer);
        txtResult = (TextView) findViewById((R.id.txtResult));
        btnBug = (Button) findViewById(R.id.btnBug);
        btnNormal = (Button) findViewById(R.id.btnNormal);

        btnLoginServer.setOnClickListener(btnLoginServerOnClick);
        btnBug.setOnClickListener(btnBugOnClick);
        btnNormal.setOnClickListener(btnNormalOnClick);
    }

    private Button.OnClickListener btnLoginServerOnClick = new Button.OnClickListener(){
        public void onClick(View v){

        }
    };

    private Button.OnClickListener btnBugOnClick = new Button.OnClickListener(){
        public void onClick(View v){
            int a = 1/0;
        }
    };

    private Button.OnClickListener btnNormalOnClick = new Button.OnClickListener(){
        public void onClick(View v){
            Intent intent = new Intent();
            intent.setClass(MainActivity.this, NextActivity.class);
            startActivity(intent);
        }
    };
}
