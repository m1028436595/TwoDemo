package com.example.yang.twodemo.model.biz;



import okhttp3.ResponseBody;
import retrofit2.http.GET;
import rx.Observable;

public interface HomeApiService {
    @GET("")
    Observable<ResponseBody> getInfo();
}
