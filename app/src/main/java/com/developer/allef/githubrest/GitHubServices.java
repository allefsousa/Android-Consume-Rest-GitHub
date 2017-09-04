package com.developer.allef.githubrest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by allef on 03/09/2017.
 */

public interface GitHubServices {
    /**
     * especificando o tipo de Requisição para a lib Retrofit
     * @param user o usuario que vamos pegar os repositorios nesse caso
     * @return
     * o paramentro Path tem a função de mostrar para o Retrofit que um determinado parâmetro deve
     * ser usado na Uri da requisição, por isso além de definir à
     * anotação devemos colocar entre chaves a parte que será substituída no parâmetro da anotação @GET
     */
    @GET("users/{user}/repos")
    Call<List<Repo>>listRepos(@Path("user")String user);
}
