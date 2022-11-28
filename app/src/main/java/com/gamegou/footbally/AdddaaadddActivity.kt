package com.gamegou.footbally

import android.content.Intent
import android.os.Bundle
import com.google.android.gms.ads.identifier.AdvertisingIdClient
import com.orhanobut.hawk.Hawk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import androidx.appcompat.app.AppCompatActivity
import com.gamegou.footbally.ApppliacttionClass.Companion.MAIN_IDffrr
import com.gamegou.footbally.ApppliacttionClass.Companion.appsCheckfrr


class AdddaaadddActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adddaaaddd)
        checkCountry()
    }

    private fun intALonehyhyy() {
        val ddede = Intent(this@AdddaaadddActivity, GaaaameeeHooldeerActivity::class.java)
        Hawk.put(ApppliacttionClass.geomeo, null)
        Hawk.put(ApppliacttionClass.countryCodefrrfr, null)
        Hawk.put(appsCheckfrr, null)
        startActivity(ddede)
        finish()
    }

    private fun ftgthy(): String? {
        val restCheckftgt: String? = Hawk.get(appsCheckfrr)
        return restCheckftgt
    }

    private fun checkCountry() {

        val check = ftgthy()

        if (check == "0") {
            intALonehyhyy()

        } else {
            GlobalScope.launch(Dispatchers.Default) {
                getAdIdgtgt()
            }
            intAfbftgtt()
        }
    }

    private fun getAdIdgtgt() {
        val adInfo = AdvertisingIdClient(applicationContext)
        adInfo.start()
        val adIdInfo = adInfo.info.id
        Hawk.put(MAIN_IDffrr, adIdInfo)
    }

    private fun intAfbftgtt() {
        val intentfrfr = Intent(this@AdddaaadddActivity, AsfActtttttttAcct::class.java)
        startActivity(intentfrfr)
        finish()
    }




}