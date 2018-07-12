package xyz.imei.healthcare.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import xyz.imei.healthcare.R
import xyz.imei.healthcare.data.vos.HealthCareInfoVO
import xyz.imei.healthcare.delegates.HealthCareDelegate
import xyz.imei.healthcare.viewholders.HealthCareInfoViewHolder

class HealthCareAdapter(private val mDelegate : HealthCareDelegate) : RecyclerView.Adapter<HealthCareInfoViewHolder>() {

    var mItems : List<HealthCareInfoVO> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HealthCareInfoViewHolder {
        val healthCareItemView = LayoutInflater.from(parent.context).inflate(R.layout.view_holder_health_care_info , parent , false)
        return HealthCareInfoViewHolder(healthCareItemView , mDelegate )
    }

    override fun onBindViewHolder(holder: HealthCareInfoViewHolder, position: Int) {
        holder.bindData(mItems[position])
    }

    override fun getItemCount(): Int {
        return mItems.size
    }

    fun setData(items :List<HealthCareInfoVO>){
        mItems = items
        notifyDataSetChanged()
    }
}