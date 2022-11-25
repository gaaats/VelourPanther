package com.gamegou.footbally

import android.app.Application
import com.onesignal.OneSignal
import com.orhanobut.hawk.Hawk

class ApppliacttionClass:Application() {

    companion object {
        const val oneS = "511820ff-4f76-47c5-89ff-8242866da0fa"
        var appsCheck = "appsChecker"
        var geo = "geo"
        var C1: String? = "c11"
        var link = "link"
        var MAIN_ID: String? = "mainid"
        var DEEPL: String? = "d11"
        var countryCode: String? = "countryCode"
    }

    override fun onCreate() {
        super.onCreate()
        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)

        OneSignal.initWithContext(this)
        OneSignal.setAppId(oneS)
        Hawk.init(this).build()
    }
}
