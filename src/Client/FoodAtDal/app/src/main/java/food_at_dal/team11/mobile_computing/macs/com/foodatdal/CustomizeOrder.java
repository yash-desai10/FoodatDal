package food_at_dal.team11.mobile_computing.macs.com.foodatdal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.lang.reflect.Array;

public class CustomizeOrder extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Button MakemyOrderButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customize_order);

        MakemyOrderButton = (Button) findViewById(R.id.btnMakemyOrder);

        MakemyOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CustomizeOrder.this, SubwayMenu.class);
                startActivity(intent);
                finish();
            }
        });

        Spinner pattiesSpinner = findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> pattiesAdapter = ArrayAdapter.createFromResource(this, R.array.Patties, android.R.layout.simple_spinner_item);
        pattiesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        pattiesSpinner.setAdapter(pattiesAdapter);

        Spinner bunsSpinner = findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> bunsAdapter = ArrayAdapter.createFromResource(this, R.array.Sauce, android.R.layout.simple_spinner_item);
        bunsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        bunsSpinner.setAdapter(bunsAdapter);
        bunsSpinner.setOnItemSelectedListener(this);

        Spinner sauceSpinner = findViewById(R.id.spinner3);
        ArrayAdapter<CharSequence>sauceAdapter = ArrayAdapter.createFromResource(this, R.array.Toppings, android.R.layout.simple_spinner_item);
        bunsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sauceSpinner.setAdapter(sauceAdapter);
        sauceSpinner.setOnItemSelectedListener(this);

        Spinner toppingsSpinner = findViewById(R.id.spinner4);
        ArrayAdapter<CharSequence>toppingsAdapter = ArrayAdapter.createFromResource(this, R.array.Cheese, android.R.layout.simple_spinner_item);
        bunsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        toppingsSpinner.setAdapter(toppingsAdapter);
        toppingsSpinner.setOnItemSelectedListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


}
