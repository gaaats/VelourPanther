package com.gamegou.footbally

import android.app.Application
import com.onesignal.OneSignal
import com.orhanobut.hawk.Hawk

class ApppliacttionClass:Application() {


    companion object {
        var linkfrfrrf = "link"
        const val jpjpjpj = "511820ff-4f76-47c5-89ff-8242866da0fa"
        var appsCheckfrfrrf55ggtgt = "appsChecker"
        var MAIN_IDdrfrrf8ftgt: String? = ""
        var DEEPLfrfrrf55fggtghy: String? = "d11"
        var C1ftgtgttggtgtg: String? = "c11"


    }

    override fun onCreate() {
        super.onCreate()

        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)
        OneSignal.initWithContext(this)
        OneSignal.setAppId(jpjpjpj)

        Hawk.init(this).build()


    }

}
