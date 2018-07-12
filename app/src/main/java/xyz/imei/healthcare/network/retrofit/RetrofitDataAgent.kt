package xyz.imei.healthcare.network.retrofit

import com.google.gson.Gson
import okhttp3.OkHttpClient
import org.greenrobot.eventbus.EventBus
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import xyz.imei.healthcare.agents.HealthCareDataAgent
import xyz.imei.healthcare.events.DataEvent
import xyz.imei.healthcare.events.ErrorApiEvent
import xyz.imei.healthcare.network.responses.GetHealthCareInfoResponse
import xyz.imei.healthcare.utils.HCInfoConstants
import java.util.concurrent.TimeUnit

class RetrofitDataAgent private constructor() : HealthCareDataAgent {

    companion object {
        private var mInstance: RetrofitDataAgent? = null

        fun getInstance(): RetrofitDataAgent {
            if (mInstance == null) mInstance = RetrofitDataAgent()
            val i = mInstance
            return i!!
        }
    }

    private val mHealhCareApi: HealthCareApi

    init {
        val okHttpClient = OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .readTimeout(15, TimeUnit.SECONDS)
                .build()

        val retrofit = Retrofit.Builder()
                .baseUrl(HCInfoConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(Gson()))
                .client(okHttpClient)
                .build()

        mHealhCareApi = retrofit.create(HealthCareApi::class.java)
    }

    override fun loadHealthCareInfo(token: String) {
        val loadHealthCareInfo = mHealhCareApi.loadHealthCareInfos(token)
        loadHealthCareInfo.enqueue(object : Callback<GetHealthCareInfoResponse> {

            override fun onFailure(call: Call<GetHealthCareInfoResponse>?, t: Throwable?) {
                EventBus.getDefault().post(ErrorApiEvent.ApiErrorEvent(t!!))

            }

            override fun onResponse(call: Call<GetHealthCareInfoResponse>, response: Response<GetHealthCareInfoResponse>) {
                val healthCareInfoResponse : GetHealthCareInfoResponse? = response.body()
                if (healthCareInfoResponse != null
                && healthCareInfoResponse.code == 200
                && healthCareInfoResponse.healthCareInfos.isNotEmpty()){
                    val event = DataEvent.SuccessGetHealthCareInfo(healthCareInfoResponse.healthCareInfos)
                    EventBus.getDefault().post(event)
                }else{
                    if (healthCareInfoResponse != null)
                        EventBus.getDefault().post(DataEvent.EmptyGetHealthCareInfo(healthCareInfoResponse.message))
                    else
                        EventBus.getDefault().post(DataEvent.EmptyGetHealthCareInfo())
                }
            }

        })
    }
}