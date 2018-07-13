package xyz.imei.healthcare.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import xyz.imei.healthcare.R
import xyz.imei.healthcare.data.vos.HealthCareInfoVO
import xyz.imei.healthcare.delegates.HealthCareDelegate
import xyz.imei.healthcare.viewholders.BaseViewHolder
import xyz.imei.healthcare.viewholders.HealthCareInfoViewHolder

 class HealthCareAdapter(private val mDelegate : HealthCareDelegate) : BaseAdapter<HealthCareInfoViewHolder, HealthCareInfoVO>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<HealthCareInfoVO> {
        val healthCareItemView = LayoutInflater.from(parent.context).inflate(R.layout.view_holder_health_care_info , parent , false)
        return HealthCareInfoViewHolder(healthCareItemView)
    }

}