package com.developer.allef.githubrest;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by allef on 03/09/2017.
 *
 *
 * FORMA SINCRONA DE FAZER A REQUISIÇAO DE DADOS
 */

public class BuscarProdutoAsync extends AsyncTask<Void, Void, Void> {

    private Context context;

    public BuscarProdutoAsync(Context context) {
        this.context = context;
    }

    @Override
    protected Void doInBackground(Void... params) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com")
.addConverterFactory(GsonConverterFactory.create())
                .build();

        GitHubServices services = retrofit.create(GitHubServices.class);

//       // Call<List<Repo>> getRepositorios = services.listRepos( params[0] );
//
//        try {
//            List<Repo> repositorios = getRepositorios.execute().body();
//            for (Repo user : repositorios){
//                Log.i("GitHubServices", user.getmName());
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
      return null;
//
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
    }
}
