package edu.txstate.d_a204.carrental_diegoabelarmorales;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.graphics.drawable.Drawable;

import java.util.ArrayList;
import java.util.List;

public class CarListView extends ListActivity {
    List<Car> cars = new ArrayList<>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        cars.add(new Car(0,"M235I","BMW",100.00,"https://forza.fandom.com/wiki/BMW_M235i",R.drawable.bmw235i));
        cars.add(new Car(1,"CLA 45 AMG","Mercedez",125.00,"https://www.mbusa.com/en/vehicles/model/cla/coupe/cla45c4",R.drawable.cla45));
        cars.add(new Car(2,"Spyder","Porche",300.00,"https://en.wikipedia.org/wiki/Porsche_918_Spyder",R.drawable.spyder));
        cars.add(new Car(3,"NSX","Acura",250.00,null,R.drawable.nsx));
        cars.add(new Car(4,"Huracan","Lamborghini",350.00,null,R.drawable.lambo));




        ArrayAdapter<Car> arrayD = new ArrayAdapter<>(this,R.layout.activity_car_list_view,R.id.txtCarsView,cars);

        setListAdapter(arrayD);


    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        /* super.onListItemClick(l, v, position, id); */

        Intent carSelected = new Intent(CarListView.this, CarSelected.class);
        carSelected.putExtra("car",cars.get(position));

        startActivity(carSelected);


    }

}
