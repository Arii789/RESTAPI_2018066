package com.example.restapi_2018066;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    ListView komputerListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        komputerListView = findViewById(R.id.KomputerListView);
        getKomputer();
    }

    private void getKomputer() {
        Call<komputer> call = RetrofitClient.getInstance().getMyApi().getKomputer();
        call.enqueue(new Callback<komputer>() {
            @Override
            public void onResponse(Call<komputer> call, Response<komputer> response) {
                komputer komputerData = response.body();
                ArrayList<ResultsItem> data = komputerData.getResults();
                String[] oneKomputer = new String[data.size()];

                for (int i = 0; i < data.size(); i++) {
                    oneKomputer[i] = data.get(i).getName();
                }
                komputerListView.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, oneKomputer));
            }
            @Override
            public void onFailure(Call<komputer> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "An error has occured", Toast.LENGTH_LONG).show();
            }

        });
    }

}