package com.gamegou.footbally

import com.orhanobut.hawk.Hawk
import android.app.Application
import com.onesignal.OneSignal

class ApppliacttionClass:Application() {

    companion object {
        const val oneSfrgt = "511820ff-4f76-47c5-89ff-8242866da0fa"
        var appsCheckfrr = "appsChecker"
        var geomeo = "geo"
        var C1gttg: String? = "c11"
        var linkfrrr = "link"
        var MAIN_IDffrr: String? = "mainid"
        var DEEPLfrfr: String? = "d11"
        var countryCodefrrfr: String? = "countryCode"
    }

    override fun onCreate() {
        super.onCreate()
        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)

        OneSignal.initWithContext(this)
        OneSignal.setAppId(oneSfrgt)
        Hawk.init(this).build()
    }
}
