package xyz.imei.healthcare.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import org.mmtextview.MMFontUtils
import xyz.imei.healthcare.R
import xyz.imei.healthcare.adapters.HealthCareAdapter
import xyz.imei.healthcare.data.models.HealthCareModel
import xyz.imei.healthcare.delegates.HealthCareDelegate
import xyz.imei.healthcare.events.DataEvent
import xyz.imei.healthcare.events.ErrorApiEvent
import xyz.imei.healthcare.utils.HCInfoConstants

class MainActivity : AppCompatActivity(), HealthCareDelegate {

    private lateinit var adapter: HealthCareAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        MMFontUtils.initMMTextView(this)

        supportActionBar!!.title = resources.getString(R.string.app_name)

        rvHealthCareInfo.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)

        adapter = HealthCareAdapter(this)

        rvHealthCareInfo.adapter = adapter

        HealthCareModel.getInstance().getHealthCareInfos(HCInfoConstants.ACCESS_TOKEN)

    }

    override fun onClick() {
        Toast.makeText(applicationContext , "Click" , Toast.LENGTH_SHORT).show()
    }

    override fun onStart() {
        super.onStart()
        if (!EventBus.getDefault().isRegistered(this))
            EventBus.getDefault().register(this)
    }

    override fun onStop() {
        super.onStop()
        if (EventBus.getDefault().isRegistered(this))
            EventBus.getDefault().unregister(this)
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onSuccessGetInfo(successGetInfos: DataEvent.SuccessGetHealthCareInfo) {
        adapter.setData(successGetInfos.infos)
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEmptyGetInfo(emptyGetInfos: DataEvent.EmptyGetHealthCareInfo) {
        Toast.makeText(applicationContext, emptyGetInfos.message, Toast.LENGTH_SHORT).show()
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onErrorGetInfo(errorGetInfos: ErrorApiEvent.ApiErrorEvent) {
        Toast.makeText(applicationContext, errorGetInfos.getMessage(), Toast.LENGTH_SHORT).show()
    }

}
