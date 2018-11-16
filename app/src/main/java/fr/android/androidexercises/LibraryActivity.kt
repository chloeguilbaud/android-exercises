package fr.android.androidexercises

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber

class LibraryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_library)

        // Plant logger cf. Android Timber
        // Indique comment on va logger
        Timber.plant(Timber.DebugTree());

        // TODO build Retrofit
        val retrofit = Retrofit.Builder()
                .baseUrl("http://henri-potier.xebia.fr/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        // TODO create a service
        val api = retrofit.create(Api::class.java)

        // TODO listBooks()

        Timber.i("BEFORE GETTING BOOKS")

        // TODO enqueue call and display book title
        api.listBooks().enqueue(object : Callback<Array<Book>> {

            override fun onResponse(call: Call<Array<Book>>?, response: Response<Array<Book>>?) {
                response!!.body()!!.forEach {
                    // TODO log books
                    Timber.i("Book: %s", it.toString())
                    // it : itérateur disponible dans l'itération
                }
                // !! : check not null
                        //Timber.i(book.getTitle())
            }

            override fun onFailure(call: Call<Array<Book>>?, t: Throwable?) {
                Timber.e("FAILLURE \n%s\ncall: %s", t.toString(), call)
            }

        })



        // TODO display book as a list
    }

}
