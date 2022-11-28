package com.gamegou.footbally

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.*
import android.provider.MediaStore
import android.webkit.*
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.appsflyer.AppsFlyerLib
import com.gamegou.footbally.ApppliacttionClass.Companion.C1gttg
import com.gamegou.footbally.ApppliacttionClass.Companion.DEEPLfrfr
import com.gamegou.footbally.ApppliacttionClass.Companion.MAIN_IDffrr
import com.gamegou.footbally.ApppliacttionClass.Companion.linkfrrr
import com.gamegou.footbally.databinding.ActivityBrovvvssserBinding
import com.google.android.material.snackbar.Snackbar
import com.onesignal.OneSignal
import com.orhanobut.hawk.Hawk
import org.json.JSONException
import org.json.JSONObject
import java.io.File
import java.io.IOException

class BrovvvssserActivity : AppCompatActivity() {
    private val ofjpeorjfperjg = 1

    var hfgjrtgjhkh: ValueCallback<Array<Uri>>? = null
    lateinit var jgidhgjdk: WebView

    var urlfififif = ""
    fun saveUrl(lurlurlurlurlur: String?) {
        if (!lurlurlurlurlur!!.contains("t.me")) {

            if (urlfififif == "") {
                urlfififif = getSharedPreferences(
                    "SP_WEBVIEW_PREFS",
                    AppCompatActivity.MODE_PRIVATE
                ).getString(
                    "SAVED_URL",
                    lurlurlurlurlur
                ).toString()

                val spspspspsppspspsp = getSharedPreferences("SP_WEBVIEW_PREFS", AppCompatActivity.MODE_PRIVATE)
                val ededededededed = spspspspsppspspsp.edit()
                ededededededed.putString("SAVED_URL", lurlurlurlurlur)
                ededededededed.apply()
            }
        }
    }

    lateinit var hrfghrdssxc: ActivityBrovvvssserBinding
    var kgjfhdkxf: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        hrfghrdssxc = ActivityBrovvvssserBinding.inflate(layoutInflater)
        setContentView(hrfghrdssxc.root)

        jgidhgjdk = hrfghrdssxc.viviviviiveeee
        Snackbar.make(
            hrfghrdssxc.root, "Loading...",
            Snackbar.LENGTH_LONG
        ).show()


        val gttgththy = CookieManager.getInstance()
        gttgththy.setAcceptCookie(true)
        gttgththy.setAcceptThirdPartyCookies(jgidhgjdk, true)
        webSettingsffgtgt()
        val activity: Activity = this
        jgidhgjdk.webViewClient = object : WebViewClient() {


            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                try {
                    if (URLUtil.isNetworkUrl(url)) {
                        return false
                    }
                    if (appInstalledOrNot(url)) {

                        val intent = Intent(Intent.ACTION_VIEW)
                        intent.data = Uri.parse(url)
                        startActivity(intent)
                    } else {

                        Toast.makeText(
                            applicationContext,
                            "Application is not installed",
                            Toast.LENGTH_LONG
                        ).show()
                        startActivity(
                            Intent(
                                Intent.ACTION_VIEW,
                                Uri.parse("https://play.google.com/store/apps/details?id=org.telegram.messenger")
                            )
                        )
                    }
                    return true
                } catch (e: Exception) {
                    return false
                }
                view.loadUrl(url)
            }


            override fun onPageFinished(view: WebView, url: String) {
                super.onPageFinished(view, url)
                saveUrl(url)
            }

            override fun onReceivedError(
                view: WebView,
                errorCode: Int,
                description: String,
                failingUrl: String
            ) {
                Toast.makeText(activity, description, Toast.LENGTH_SHORT).show()
            }


        }
        jgidhgjdk.webChromeClient = object : WebChromeClient() {
            override fun onShowFileChooser(
                webView: WebView, filePathCallback: ValueCallback<Array<Uri>>,
                fileChooserParams: FileChooserParams
            ): Boolean {
                hfgjrtgjhkh?.onReceiveValue(null)
                hfgjrtgjhkh = filePathCallback
                var takePictureIntent: Intent? = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                if (takePictureIntent!!.resolveActivity(packageManager) != null) {

                    var photoFile: File? = null
                    try {
                        photoFile = jujujiii()
                        takePictureIntent.putExtra("PhotoPath", kgjfhdkxf)
                    } catch (ex: IOException) {
                        // Error occurred while creating the File
                    }

                    if (photoFile != null) {
                        kgjfhdkxf = "file:" + photoFile.absolutePath
                        takePictureIntent.putExtra(
                            MediaStore.EXTRA_OUTPUT,
                            Uri.fromFile(photoFile)
                        )
                    } else {
                        takePictureIntent = null
                    }
                }
                val hyhyyy = Intent(Intent.ACTION_GET_CONTENT)
                hyhyyy.addCategory(Intent.CATEGORY_OPENABLE)
                hyhyyy.type = "image/*"
                val gtgtgtt: Array<Intent?> =
                    takePictureIntent?.let { arrayOf(it) } ?: arrayOfNulls(0)
                val opopopop = Intent(Intent.ACTION_CHOOSER)
                opopopop.putExtra(Intent.EXTRA_INTENT, hyhyyy)
                opopopop.putExtra(Intent.EXTRA_TITLE, getString(R.string.dfgtimage_chooserefrgtgttt))
                opopopop.putExtra(Intent.EXTRA_INITIAL_INTENTS, gtgtgtt)
                startActivityForResult(
                    opopopop, ofjpeorjfperjg
                )
                return true
            }

            @Throws(IOException::class)
            private fun jujujiii(): File {
                var frfrrfr = File(
                    Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),
                    "DirectoryNameHere"
                )
                if (!frfrrfr.exists()) {
                    frfrrfr.mkdirs()
                }

                frfrrfr =
                    File(frfrrfr.toString() + File.separator + "IMG_" + System.currentTimeMillis() + ".jpg")
                return frfrrfr
            }

        }

        jgidhgjdk.loadUrl(ururururururururffr())
    }


    private fun pushToOneSignalyhyyhy(string: String) {
        OneSignal.setExternalUserId(
            string,
            object : OneSignal.OSExternalUserIdUpdateCompletionHandler {
                override fun onSuccess(results: JSONObject) {
                    try {
                        if (results.has("push") && results.getJSONObject("push").has("success")) {
                            val frrfrfrrf = results.getJSONObject("push").getBoolean("success")
                            OneSignal.onesignalLog(
                                OneSignal.LOG_LEVEL.VERBOSE,
                                "Set external user id for push status: $frrfrfrrf"
                            )
                        }
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                    try {
                        if (results.has("email") && results.getJSONObject("email").has("success")) {
                            val frfrfrfr =
                                results.getJSONObject("email").getBoolean("success")
                            OneSignal.onesignalLog(
                                OneSignal.LOG_LEVEL.VERBOSE,
                                "Set external user id for email status: $frfrfrfr"
                            )
                        }
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                    try {
                        if (results.has("sms") && results.getJSONObject("sms").has("success")) {
                            val frfrfr = results.getJSONObject("sms").getBoolean("success")
                            OneSignal.onesignalLog(
                                OneSignal.LOG_LEVEL.VERBOSE,
                                "Set external user id for sms status: $frfrfr"
                            )
                        }
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                }

                override fun onFailure(error: OneSignal.ExternalIdError) {
                    OneSignal.onesignalLog(
                        OneSignal.LOG_LEVEL.VERBOSE,
                        "Set external user id done with error: $error"
                    )
                }
            })
    }

    private fun webSettingsffgtgt() {
        val wstwstwstwstfrfrr = jgidhgjdk.settings
        wstwstwstwstfrfrr.javaScriptEnabled = true

        wstwstwstwstfrfrr.useWideViewPort = true

        wstwstwstwstfrfrr.loadWithOverviewMode = true
        wstwstwstwstfrfrr.allowFileAccess = true
        wstwstwstwstfrfrr.domStorageEnabled = true
        wstwstwstwstfrfrr.userAgentString = wstwstwstwstfrfrr.userAgentString.replace("; wv", "")

        wstwstwstwstfrfrr.javaScriptCanOpenWindowsAutomatically = true
        wstwstwstwstfrfrr.setSupportMultipleWindows(false)

        wstwstwstwstfrfrr.displayZoomControls = false
        wstwstwstwstfrfrr.builtInZoomControls = true
        wstwstwstwstfrfrr.setSupportZoom(true)

        wstwstwstwstfrfrr.pluginState = WebSettings.PluginState.ON
        wstwstwstwstfrfrr.mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
        wstwstwstwstfrfrr.setAppCacheEnabled(true)

        wstwstwstwstfrfrr.allowContentAccess = true
    }

    private fun ururururururururffr(): String {

        val ftgttg = getSharedPreferences("SP_WEBVIEW_PREFS", AppCompatActivity.MODE_PRIVATE)

        val packfrfrrfr = "com.gamegou.footbally"

        val cpOnefgtgt:String? = Hawk.get(C1gttg, "null")
        val mainIdfrfrr: String? = Hawk.get(MAIN_IDffrr, "null")
        val dpOnefrfrr: String? = Hawk.get(DEEPLfrfr, "null")

        val afIdfrfrrf = AppsFlyerLib.getInstance().getAppsFlyerUID(this)


        AppsFlyerLib.getInstance().setCollectAndroidID(true)



        val frfrrrf = "deviceID="
        val frfrfrfr = "sub_id_1="
        val adidddddd = "ad_id="
        val sub4frfrr = "sub_id_4="
        val sub5frfr = "sub_id_5="
        val sub6frfr = "sub_id_6="


        val namingggggg = "naming"
        val deppfrfrf = "deeporg"


        val kiokjjlikjhmkijfrfr = Build.VERSION.RELEASE

        val gtlpgtp = Hawk.get(linkfrrr, "null")

        var hylphlyplhly = ""
        if (cpOnefgtgt != "null"){
            hylphlyplhly = "$gtlpgtp$frfrfrfr$cpOnefgtgt&$frfrrrf$afIdfrfrrf&$adidddddd$mainIdfrfrr&$sub4frfrr$packfrfrrfr&$sub5frfr$kiokjjlikjhmkijfrfr&$sub6frfr$namingggggg"
            pushToOneSignalyhyyhy(afIdfrfrrf.toString())
        } else {
            hylphlyplhly = "$gtlpgtp$frfrfrfr$dpOnefrfrr&$frfrrrf$afIdfrfrrf&$adidddddd$mainIdfrfrr&$sub4frfrr$packfrfrrfr&$sub5frfr$kiokjjlikjhmkijfrfr&$sub6frfr$deppfrfrf"
            pushToOneSignalyhyyhy(afIdfrfrrf.toString())
        }
        return ftgttg.getString("SAVED_URL", hylphlyplhly).toString()
    }


    private fun appInstalledOrNot(uri: String): Boolean {

        val gtplgltpgtl = packageManager
        try {

            gtplgltpgtl.getPackageInfo("org.telegram.messenger", PackageManager.GET_ACTIVITIES)

            return true
        } catch (e: PackageManager.NameNotFoundException) {

        }
        return false
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode != ofjpeorjfperjg || hfgjrtgjhkh == null) {
            super.onActivityResult(requestCode, resultCode, data)
            return
        }
        var fnrnfnrf: Array<Uri>? = null

        if (resultCode == AppCompatActivity.RESULT_OK) {
            if (data == null || data.data == null) {
                fnrnfnrf = arrayOf(Uri.parse(kgjfhdkxf))
            } else {
                val dataString = data.dataString
                if (dataString != null) {
                    fnrnfnrf = arrayOf(Uri.parse(dataString))
                }
            }
        }
        hfgjrtgjhkh?.onReceiveValue(fnrnfnrf)
        hfgjrtgjhkh = null
    }


    private var frrfrfrf = false
    override fun onBackPressed() {


        if (jgidhgjdk.canGoBack()) {
            if (frrfrfrf) {
                jgidhgjdk.stopLoading()
                jgidhgjdk.loadUrl(urlfififif)
            }
            this.frrfrfrf = true
            jgidhgjdk.goBack()
            Handler(Looper.getMainLooper()).postDelayed(Runnable {
                frrfrfrf = false
            }, 2000)

        } else {
            super.onBackPressed()
        }
    }


}