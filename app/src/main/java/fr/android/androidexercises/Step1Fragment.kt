package fr.android.androidexercises

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class Step1Fragment : Fragment() {
    // TODO Override onCreateViewMethod
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_step1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // TODO setText(STEP_0)
        val textView = view.findViewById<TextView>(R.id.step1TextView)
        textView.text = getString(R.string.step2_fragment)
    }

}
