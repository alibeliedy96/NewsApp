package com.example.newsmvp.API;




import com.example.newsmvp.Model.NewsResponse.NewsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Services {



    @GET("everything")
    Call<NewsResponse> getNewsBySourceId(@Query("apiKey") String apikey,
                                         @Query("language") String language,
                                         @Query("sources") String sources);
}
