package es.iessaladillo.pedrojoya.greet;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {
    private int times=0;
    private String treatmentButtoms="Mr.";
    private String firstGreet="Hello";
    private String treatment="";
    private String binaryPolite="what's up?";
    String name = "";
    String surname="";
    boolean politeBool=false, premiumBool=false;

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
        CheckBox check = ActivityCompat.requireViewById(this, R.id.polite);
        SwitchCompat premium = ActivityCompat.requireViewById(this, R.id.swt1);
        ProgressBar bar = ActivityCompat.requireViewById(this, R.id.progressbar);
        Button greetButton = ActivityCompat.requireViewById(this, R.id.button);
        TextView finalGreet = ActivityCompat.requireViewById(this, R.id.textgreet);
        TextView textBar = ActivityCompat.requireViewById(this, R.id.textBar);
        EditText editName = ActivityCompat.requireViewById(this, R.id.editt1);
        EditText editSurName = ActivityCompat.requireViewById(this, R.id.editt2);
        finalGreet.setText(getString(R.string.main_textgreet,"",
                "", "","", ""));
        textBar.setText(getString(R.string.main_text_bar, times));

        mister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                icono.setImageDrawable(getDrawable(R.drawable.ic_mr));
                treatmentButtoms="Mr.";
                treatment=treatmentButtoms;
            }
        });

        mrs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                icono.setImageDrawable(getDrawable(R.drawable.ic_mrs));
                treatmentButtoms="Mrs.";
                treatment=treatmentButtoms;
            }
        });

        ms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                icono.setImageDrawable(getDrawable(R.drawable.ic_ms));
                treatmentButtoms="Ms.";
                treatment=treatmentButtoms;
            }
        });

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(politeBool){
                    politeBool=false;
                    firstGreet="Hello";
                    treatment="";
                    binaryPolite="What's up?";
                }else{
                    politeBool=true;
                    firstGreet="Good morning";
                    treatment=treatmentButtoms;
                    binaryPolite="Pleased to meet you";
                }
            }
        });



        greetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name=editName.getText().toString();
                surname=editSurName.getText().toString();
                  if(surname.length()>0 && name.length()>0 && (times<10 || premiumBool)){
                      finalGreet.setText(getString(R.string.main_textgreet,firstGreet,
                              treatment, name, surname, binaryPolite));
                      times++;
                      bar.setProgress(times);
                      textBar.setText(getString(R.string.main_text_bar, times));
                  }

            }
        });

        premium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(premiumBool){
                    premiumBool=false;
                    textBar.setVisibility(View.VISIBLE);
                    bar.setVisibility(View.VISIBLE);
                    times=0;
                    bar.setProgress(times);
                    textBar.setText(getString(R.string.main_text_bar, times));
                }else{
                    premiumBool=true;
                    textBar.setVisibility(View.GONE);
                    bar.setVisibility(View.GONE);
                }
            }


        });


        mister.setChecked(true);


    }

}