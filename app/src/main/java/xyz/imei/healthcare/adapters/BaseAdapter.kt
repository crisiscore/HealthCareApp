package xyz.imei.healthcare.adapters

import android.support.v7.widget.RecyclerView
import xyz.imei.healthcare.viewholders.BaseViewHolder

abstract class BaseAdapter<VH, D> : RecyclerView.Adapter<BaseViewHolder<D>>() {

    protected var mList: List<D>? = null

    init {
        mList = ArrayList()
    }

    override fun getItemCount(): Int {
        return mList!!.size
    }

    override fun onBindViewHolder(holder: BaseViewHolder<D>, position: Int) {
        holder.bindData(mList!![position])
    }

    fun setData(healthCartList : List<D>){
        mList = healthCartList
        notifyDataSetChanged()
    }

}