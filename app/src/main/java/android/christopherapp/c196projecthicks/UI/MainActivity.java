package android.christopherapp.c196projecthicks.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.christopherapp.c196projecthicks.R;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void onLogin(View view) {
        Intent intent=new Intent(MainActivity.this, Home.class );
        startActivity(intent);
    }
}