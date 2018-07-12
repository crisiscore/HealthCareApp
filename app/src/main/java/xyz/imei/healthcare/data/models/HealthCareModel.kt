package xyz.imei.healthcare.data.models

import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import xyz.imei.healthcare.data.vos.HealthCareInfoVO
import xyz.imei.healthcare.events.DataEvent
import xyz.imei.healthcare.network.retrofit.RetrofitDataAgent

class HealthCareModel private constructor() {

    companion object {

        private var mInstance: HealthCareModel? = null

        fun getInstance(): HealthCareModel {
            if (mInstance == null)
                mInstance = HealthCareModel()
            val i = mInstance
            return i!!
        }

    }

    private val dataAgent: RetrofitDataAgent = RetrofitDataAgent.getInstance()
    private var mHealthCareInfos: HashMap<String, HealthCareInfoVO> = HashMap()

    init {
        EventBus.getDefault().register(this)
    }

    fun getHealthCareInfos(token: String) {
        dataAgent.loadHealthCareInfo(token)
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    fun onSuccessGetInfos(event: DataEvent.SuccessGetHealthCareInfo) {
        for (healCareVO: HealthCareInfoVO in event.infos) {
            mHealthCareInfos.put(healCareVO.id.toString(), healCareVO)
        }
    }
}