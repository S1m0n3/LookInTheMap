package net.s1m0n3.lookinthemap;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    SupportMapFragment mapFragment;
    GoogleMap gMap;
    EditText edtxt_lat;
    EditText edtxt_long;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mapFragment = SupportMapFragment.newInstance();
        getSupportFragmentManager().beginTransaction().add(R.id.mapView, mapFragment).commit();

        edtxt_lat = (EditText) findViewById(R.id.edtxt_lat);
        edtxt_long = (EditText) findViewById(R.id.edtxt_long);

        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        gMap = googleMap;

    }

    public void onClickTrova(View v) {

        Log.v("Latitudine", edtxt_lat.getText().toString());
        Log.v("Longitudine", edtxt_long.getText().toString());

        Toast.makeText(this, "Ricerca coordinate in corso...", Toast.LENGTH_SHORT).show();
        LatLng myCoordinate = new LatLng(Double.valueOf(edtxt_lat.getText().toString()),Double.valueOf(edtxt_long.getText().toString()));
        gMap.addMarker(new MarkerOptions().position(myCoordinate)
                .title("Le tue coordinate"));
        gMap.moveCamera(CameraUpdateFactory.newLatLng(myCoordinate));

    }
}
