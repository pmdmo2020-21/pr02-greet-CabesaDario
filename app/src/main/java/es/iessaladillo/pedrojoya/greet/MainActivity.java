package es.iessaladillo.pedrojoya.greet;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        setUpViews();
    }

    private void setUpViews(){
        ImageView icono = ActivityCompat.requireViewById(this, R.id.iconperson);
        RadioButton mister = ActivityCompat.requireViewById( this, R.id.senor);
        RadioButton mrs = ActivityCompat.requireViewById( this, R.id.senora);
        RadioButton ms = ActivityCompat.requireViewById(this, R.id.senorita);


        mister.setOnClickListener(v ->
                icono.setImageDrawable(getDrawable(R.drawable.ic_mr))
        );

        mrs.setOnClickListener(v ->
            icono.setImageDrawable(getDrawable(R.drawable.ic_mrs))
                );
        ms.setOnClickListener(v ->
                icono.setImageDrawable(getDrawable(R.drawable.ic_ms))
        );




        mister.setChecked(true);


    }

}