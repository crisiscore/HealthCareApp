package xyz.imei.healthcare.events

import xyz.imei.healthcare.data.vos.HealthCareInfoVO

class DataEvent {

    class SuccessGetHealthCareInfo(val infos: List<HealthCareInfoVO>)

    class EmptyGetHealthCareInfo(val message: String? = "Empty Data")
}