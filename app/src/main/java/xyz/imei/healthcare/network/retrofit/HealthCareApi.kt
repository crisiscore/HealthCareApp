package xyz.imei.healthcare.network.retrofit

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import xyz.imei.healthcare.network.responses.GetHealthCareInfoResponse
import xyz.imei.healthcare.utils.HCInfoConstants

interface HealthCareApi {

    @FormUrlEncoded
    @POST(HCInfoConstants.GET_HC_INFO)
    fun loadHealthCareInfos(@Field(HCInfoConstants.PARAM_ACCESS_TOKEN)accessToken : String) : Call<GetHealthCareInfoResponse>

}