package com.davidpradosm.chuckjokes;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    //TAB1
    private TextView txt;
    private TextView txt_tab2;
    private Button btn;
    private ImageView iv;
    private Bitmap loadedImage;
    private String logo = "https://assets.chucknorris.host/img/chucknorris_logo_coloured_small@2x.png";

    //TAB2
    private RecyclerView recyclerView;
    private ArrayList<Result> data;
    private Adaptador adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv = (ImageView) findViewById(R.id.iv);
        Picasso.with(this).load(logo).into(iv);
        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadJSON();
            }
        });

        loadTabs();
        initViews();
    }



    private void loadJSON(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.chucknorris.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ChuckJokesServices request = retrofit.create(ChuckJokesServices.class);
        Call<Joke> call = request.getJoke();
        call.enqueue(new Callback<Joke>() {
            @Override
            public void onResponse(Call<Joke> call, Response<Joke> response) {

                Joke joke = response.body();
                txt = (TextView) findViewById(R.id.tv);
                Typeface face=Typeface.createFromAsset(getAssets(),"fonts/Roboto-Bold.ttf");
                txt.setTypeface(face);
                txt.setText(joke.getValue());

            }

            @Override
            public void onFailure(Call<Joke> call, Throwable t) {
                Log.d("Error",t.getMessage());
            }
        });
    }

    private void loadTabs(){
        Resources res = getResources();

        TabHost tabs =(TabHost)findViewById(android.R.id.tabhost);
        tabs.setup();

        TabHost.TabSpec spec=tabs.newTabSpec("mitab1");
        spec.setContent(R.id.tab1);
        spec.setIndicator("Aleatorio");
        tabs.addTab(spec);

        spec=tabs.newTabSpec("mitab2");
        spec.setContent(R.id.tab2);
        spec.setIndicator("Categoria");
        tabs.addTab(spec);

        tabs.setCurrentTab(0);
    }

    private void initViews(){
        recyclerView = (RecyclerView)findViewById(R.id.RecView);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        loadJSONRecycler();
    }
    private void loadJSONRecycler(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.chucknorris.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ChuckJokesServices request = retrofit.create(ChuckJokesServices.class);
        Call<QuerySport> call = request.getSports();
        call.enqueue(new Callback<QuerySport>() {
            @Override
            public void onResponse(Call<QuerySport> call, Response<QuerySport> response) {
                /*
                txt_tab2 = (TextView) findViewById(R.id.tv_tab2);
                txt_tab2.setText("Hola");
                */
                QuerySport joke = response.body();
                data = new ArrayList<>(Arrays.asList(joke.getResult()));
                adapter = new Adaptador(data);
                recyclerView.setAdapter(adapter);
            }



            @Override
            public void onFailure(Call<QuerySport> call, Throwable t) {
                Toast toast1 =
                        Toast.makeText(getApplicationContext(),
                                "Error", Toast.LENGTH_SHORT);

                toast1.show();
            }
        });
    }
}
