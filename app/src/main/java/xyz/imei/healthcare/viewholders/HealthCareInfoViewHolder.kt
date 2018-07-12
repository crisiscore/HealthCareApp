package xyz.imei.healthcare.viewholders

import android.support.v7.widget.RecyclerView
import android.view.View
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.view_holder_health_care_info.view.*
import xyz.imei.healthcare.data.vos.HealthCareInfoVO
import xyz.imei.healthcare.delegates.HealthCareDelegate

class HealthCareInfoViewHolder(itemView: View , private val delegate : HealthCareDelegate) : RecyclerView.ViewHolder(itemView) , View.OnClickListener {

    init {
        itemView.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        delegate.onClick()
    }

    fun bindData(healthCareInfoVO : HealthCareInfoVO) {

        itemView.tv_care_title.text = healthCareInfoVO.title

        Glide.with(itemView.context)
                .load(healthCareInfoVO.image)
                .into(itemView.iv_care_image)

    }

}