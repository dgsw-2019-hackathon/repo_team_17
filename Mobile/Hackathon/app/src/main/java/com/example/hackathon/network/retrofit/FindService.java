package com.example.hackathon.network.retrofit;

import com.example.hackathon.model.Product;
import com.example.hackathon.network.response.Response;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

public interface FindService {

    @GET("/product/{barcode}")
    Single<retrofit2.Response<Response<Product>>> getProduct(
            @Header("x-access-token") String token,
            @Path("barcode") String barcode
    );

}
