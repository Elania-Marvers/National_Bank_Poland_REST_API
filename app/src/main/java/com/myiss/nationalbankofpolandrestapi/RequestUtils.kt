package com.myiss.nationalbankofpolandrestapi

import com.google.gson.Gson
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.InputStreamReader

class RequestUtils {
    companion object {
        /********************************ATTRIBUTE********************************/
        val client = OkHttpClient()
        val gson = Gson()
        val MEDIA_TYPE_JSON = "application/json; charset=utf-8".toMediaType()
        const val URL_API = "http://api.nbp.pl/api/exchangerates/tables/a/?format=json"
        /********************************ATTRIBUTE********************************/


        /********************************GET********************************/
        fun sendGet(url: String): String {
            println("url : $url")
            val request = Request.Builder().url(url).build()
            return client.newCall(request).execute().use {
                if (!it.isSuccessful) {
                    throw Exception("Réponse du serveur incorrect :${it.code}")
                }
                it.body.string() ?: ""
            }
        }
        /********************************GET********************************/

        /********************************POST********************************/
        fun sendPost(url: String, paramJson: String): String {
            println("url : $url")
            val body = paramJson.toRequestBody(MEDIA_TYPE_JSON)
            val request = Request.Builder().url(url).post(body).build()
            return client.newCall(request).execute().use {
                if (!it.isSuccessful) {
                    throw Exception("Réponse du serveur incorrect :${it.code}")
                }
                it.body.string() ?: ""
            }
        }

        /********************************POST********************************/

        /********************************getBeans********************************/
        fun getBeans(): Beans {
            val request = Request.Builder().url(URL_API).build()
            return client.newCall(request).execute().use {
                if (!it.isSuccessful) {
                    throw Exception("Réponse du serveur incorrect :${it.code}")
                }
                val isr = InputStreamReader(it.body.byteStream())
                gson.fromJson(isr, Beans::class.java)

            }
        }
        /********************************getBeans********************************/


    }
}
