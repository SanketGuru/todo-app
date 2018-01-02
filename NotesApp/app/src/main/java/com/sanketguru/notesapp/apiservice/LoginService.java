package com.sanketguru.notesapp.apiservice;
import com.sanketguru.notesapp.models.User;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;
/**
 * Created by Sanket Gurav on 1/2/2018.
 */

public interface LoginService {
    @POST("login")
    Observable<ApiResponse<Object>> login(@Body User user);
}
