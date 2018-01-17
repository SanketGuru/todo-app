package com.sanketguru.notesapp.apiservice

//import com.sanketguru.notesapp.BuildConfig;


import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


/*retrofit logging
https://stackoverflow.com/questions/32514410/logging-with-retrofit-2*/



class RetrofitHelper {


    /**
     * The CityService communicates with the json api of the city provider.
     */

    val userWebService: LoginService
        get() {
            val retrofit = createRetrofit()
            return retrofit.create(LoginService::class.java)
        }
    val webServiceHeader: NoteServices
        get() {
            val retrofit = createRetrofitHeader()
            return retrofit.create(NoteServices::class.java)
        }


    /**
     * This custom client will append the "username=demo" query after every request.
     */

    private fun createOkHttpClient(): OkHttpClient {
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(RequestInterceptor(true, true))
        return httpClient.build()
    }

    private fun createOkHttpClientHeader(): OkHttpClient {
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(RequestInterceptor(true, true))
        httpClient.addInterceptor(HeaderInterceptor(""))
        return httpClient.build()
    }


    /**
     * Creates a pre configured Retrofit instance
     */


    private fun createRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl(ApiConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create()) // <- add this
                .client(createOkHttpClient())
                .build()
    }

    private fun createRetrofitHeader(): Retrofit {
        return Retrofit.Builder().baseUrl(ApiConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create()) // <- add this
                .client(createOkHttpClientHeader())
                .build()
    }
}

