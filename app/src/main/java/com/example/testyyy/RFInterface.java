package com.example.testyyy;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RFInterface {

    @GET ("/users/{user}/repos")
    Call<List<GHRepos>> reposUser (@Path("user") String user );
}
