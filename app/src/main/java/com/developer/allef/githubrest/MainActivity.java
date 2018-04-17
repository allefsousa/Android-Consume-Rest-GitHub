package com.developer.allef.githubrest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    ArrayList<Repo> repositorios;
    ListView  lv;

    ArrayAdapter<String> adapter;
    ArrayList<String> re;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView)findViewById(R.id.list);


          repositorios = new ArrayList<>();
             re= new ArrayList<>();

        /**
         * adapeter para criar a lista
         */
         adapter = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,re);

        /**
         * passando a URL base para o retrofit depois so adicionar o restante
         */
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com") // URL base que vamos consumir os dados
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        /**
         * interface responsavel pela rota que a Api vai direcionar se
         * e é essa api que sera completada junto a URL BASE
         */
        GitHubServices gitHubServices = retrofit.create(GitHubServices.class);
         gitHubServices.listRepos("AllefSousa");

        /**
         * interface responsavel pela rota que a Api vai direcionar se
         * e é essa api que sera completada junto a URL BASE
         chega ae jhow
         */

        Call<List<Repo>> repos = gitHubServices.listRepos("AllefSousa");
        repos.enqueue(new Callback<List<Repo>>() {
            @Override
            public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
                /**
                 * ITERANDO A resposta e pegando os resultados obtidos na Requisição.
                 */
                if(response.isSuccessful()){
                    for (Repo r : response.body()){
                        repositorios.add(r);
                        re.add(r.getmFullName());
                        Log.d("Allef","result OKK  " + r.getmName() + repositorios.size());

                    }
                    lv.setAdapter(adapter);

                }
            }

            @Override
            public void onFailure(Call<List<Repo>> call, Throwable t) {
                Log.d("Allef","result" +t.getStackTrace());

            }
        });

    }
}
