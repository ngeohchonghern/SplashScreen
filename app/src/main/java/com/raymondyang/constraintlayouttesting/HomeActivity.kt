package com.raymondyang.constraintlayouttesting

import android.app.Application
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.kelin.translucentbar.library.TranslucentBarManager
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        var translucentBarManager = TranslucentBarManager(this)
        translucentBarManager.transparent(this)

        initToolbar()
    }

    private fun initToolbar() {
       val param = appbar.layoutParams as CoordinatorLayout.LayoutParams
        param.topMargin = applicationContext.getStatusBarHeight()

        150f.dpToPx(this)

    }


}

