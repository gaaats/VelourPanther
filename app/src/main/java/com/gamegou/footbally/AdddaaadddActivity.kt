package com.gamegou.footbally

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.gamegou.footbally.ApppliacttionClass.Companion.MAIN_ID
import com.gamegou.footbally.ApppliacttionClass.Companion.appsCheck
import com.google.android.gms.ads.identifier.AdvertisingIdClient
import com.orhanobut.hawk.Hawk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class AdddaaadddActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adddaaaddd)
        checkCountry()
    }

    private fun getShData(): String? {
        val restCheck: String? = Hawk.get(appsCheck)
        Log.d("ADACt Data", restCheck.toString())
        return restCheck
    }

    private fun checkCountry() {

        val check = getShData()

        if (check == "0") {
            intALone()

        } else {
            GlobalScope.launch(Dispatchers.Default) {
                getAdId()
            }
            intAfb()
        }
    }

    private fun getAdId() {
        val adInfo = AdvertisingIdClient(applicationContext)
        adInfo.start()
        val adIdInfo = adInfo.info.id
        Log.d("getAdvertisingId = ", adIdInfo.toString())
        Hawk.put(MAIN_ID, adIdInfo)
    }

    private fun intALone() {
        val intent = Intent(this@AdddaaadddActivity, GaaaameeeHooldeerActivity::class.java)
        Hawk.put(ApppliacttionClass.geo, null)
        Hawk.put(ApppliacttionClass.countryCode, null)
        startActivity(intent)
        finish()
    }

    private fun intAfb() {
        val intent = Intent(this@AdddaaadddActivity, AsfActtttttttAcct::class.java)
        startActivity(intent)
        finish()
    }
}