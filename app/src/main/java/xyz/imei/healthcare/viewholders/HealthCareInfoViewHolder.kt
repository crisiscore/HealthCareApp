package xyz.imei.healthcare.viewholders

import android.view.View
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.view_holder_health_care_info.view.*
import xyz.imei.healthcare.data.vos.HealthCareInfoVO

class HealthCareInfoViewHolder(itemView: View) : BaseViewHolder<HealthCareInfoVO>(itemView) {

    override fun bindData(data : HealthCareInfoVO) {

        itemView.tv_care_title.text = data.title

        itemView.tv_care_publisher.text = data.author.name

        Glide.with(itemView.context)
                .load(data.image)
                .into(itemView.iv_care_image)

    }

    override fun onClick(v: View?) {
        super.onClick(v)
    }

}