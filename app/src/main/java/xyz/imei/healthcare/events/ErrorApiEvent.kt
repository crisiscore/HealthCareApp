package xyz.imei.healthcare.events

class ErrorApiEvent {

    class ApiErrorEvent(val throwable: Throwable) {

        fun getMessage(): String {
            return throwable.message!!
        }

    }

}