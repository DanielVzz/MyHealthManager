package com.hb4u.myhealthmanagerver01_beta.api_repository;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import com.hb4u.myhealthmanagerver01_beta.classes.*;


public interface UsersApi {
@GET("/get_UserObject")
    Call<Users> getUser(
            //Add if Necessary @Query("q") String cityName,  @Query("APPID") String appId);
            );
}
