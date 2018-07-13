package xyz.imei.healthcare.viewholders

import android.support.v7.widget.RecyclerView
import android.view.View

abstract class BaseViewHolder<D>(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

    protected var mData: D? = null

    init {
        itemView.setOnClickListener(this)
    }

    override fun onClick(v: View?) {

    }

    abstract fun bindData(data: D)

}