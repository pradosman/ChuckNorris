package com.davidpradosm.chuckjokes;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by David Prados on 09/11/2017.
 */

public interface ChuckJokesServices {
    @GET("jokes/random")
    Call<Joke> getJoke();

    @GET("jokes/search?query=sport")
    Call<Joke> getSports();
}


