package com.hb4u.myhealthmanagerver01_beta.api_repository;

import android.icu.text.DecimalFormat;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import com.hb4u.myhealthmanagerver01_beta.classes.*;


public interface UsersApi {
@GET("/CalculatorWebService.asmx/get_UserHealthInfo?userId=1")
//@GET("/CalculatorWebService.asmx/get_UserName")
    Call<ResponseBody> getUser(
            //Add if Necessary @Query("q") String cityName,  @Query("APPID") String appId);
            );
}
