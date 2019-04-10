package edu.txstate.d_a204.carrental_diegoabelarmorales;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;

public class CarSelected extends AppCompatActivity {

    String id;
    String displayName;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_selected);

        Intent main = getIntent();
        final Car carSelected = (Car)main.getSerializableExtra("car");

        id = Integer.toString(carSelected.getId());
        displayName = carSelected.toString() +"| Id: " + id;

        TextView dispName = findViewById(R.id.txtNameID);
        TextView cost = findViewById(R.id.txtCost);
        final TextView total = findViewById(R.id.txtTotal);
        final EditText txtDays = findViewById(R.id.editDays);
        ImageView carPic = findViewById(R.id.imageView);


        carPic.setImageResource(carSelected.getCarPic());

        cost.setText("$"+Double.toString(carSelected.getRentalCost()));
        dispName.setText(displayName);


        Button btnCalc = findViewById(R.id.btnCalcCost);
        Button btnCarInfo = findViewById(R.id.btnCarInfo);


        if (carSelected.getCarUrl()==null){
            btnCarInfo.setEnabled(false);
        }

        btnCarInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent info = new Intent(Intent.ACTION_VIEW, Uri.parse(carSelected.getCarUrl()));
                startActivity(info);
            }
        });

        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int days = Integer.parseInt(txtDays.getText().toString());
                double  totalCost;
                totalCost = carSelected.carRentalTotal(days);

                DecimalFormat currency = new DecimalFormat("$###,###.##");

                total.setText("Total: "+currency.format(totalCost));

            }
        });







    }
}
