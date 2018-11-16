package fr.android.androidexercises

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class LibraryActivity : AppCompatActivity(), Step0Fragment.OnNextStep0Listener {

    override fun onClick() {
        supportFragmentManager.beginTransaction()
                .addToBackStack(Step0Fragment::class.java.name) // Ajout a backtake qui permet retour fragment d'avant a appuis sur bouton retour
                .replace(R.id.containerFrameLayout, Step1Fragment())
                .commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_library)

        // TODO replace Step0Fragment in containerFrameLayout
        // Le fragment est placer dans l'élément containerFrameLayout de la vue
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.containerFrameLayout, Step0Fragment())
                .commit()

    }

    // TODO implement onNext() from Step0Fragment.OnNextStep0Listener

}
