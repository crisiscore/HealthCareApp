package xyz.imei.healthcare.network.responses

import com.google.gson.annotations.SerializedName
import xyz.imei.healthcare.data.vos.HealthCareInfoVO

class GetHealthCareInfoResponse(@SerializedName("code")val code : Int,
                                @SerializedName("message")val message : String,
                                @SerializedName("healthcare-info")val healthCareInfos: List<HealthCareInfoVO>)
