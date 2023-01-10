package org.avstream.mvp_simple

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity(), MainContract.View {

    private val textView: TextView by lazy { findViewById(R.id.textView) }
    private val button: Button by lazy { findViewById(R.id.button) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        MainPresenter(MainRepository, this)
        button.setOnClickListener {
            presenter.start()
        }
    }

    override fun showProgress(isShow: Boolean) {
        textView.isVisible = isShow
    }

    override fun setData(str: String) {
        textView.text = str
    }

    override lateinit var presenter: MainContract.Presenter

}