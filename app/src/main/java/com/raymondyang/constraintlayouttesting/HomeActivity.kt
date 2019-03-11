package com.raymondyang.constraintlayouttesting

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kelin.translucentbar.library.TranslucentBarManager
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        initActionBar()
        var translucentBarManager = TranslucentBarManager(this)
        translucentBarManager.transparent(this, android.R.color.transparent);

        initToolbar()
    }


    private fun initActionBar() {
        toolbar
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(true)


    }

    private fun initToolbar() {
//        toolbar.title = "!!!!!!!!!!!!!!!!!!!"
//        toolbar.titleMarginBottom= applicationContext.getStatusBarHeight()
//        var toolbarPara = toolbar.layoutParams as ViewGroup.MarginLayoutParams
//        toolbarPara.topMargin = applicationContext.getStatusBarHeight()
//        var viewPara = view.layoutParams as ViewGroup.MarginLayoutParams
//       viewPara.topMargin = applicationContext.getStatusBarHeight()
//       var appbarPara = appbar.layoutParams as CoordinatorLayout.LayoutParams
//        appbarPara.topMargin = applicationContext.getStatusBarHeight()
//        appbarPara.height = toolbarPara.height * 2

//        toolbar.requestLayout()
//        param = appbar.layoutParams as ViewGroup.MarginLayoutParams
//        param.height = 180f.dpToPx(this).toInt()

        150f.dpToPx(this)

//        recyclerview.addOnLayoutChangeListener{}
//        var param = recyclerview.layoutParams as CoordinatorLayout.LayoutParams
//        param.bottomMargin = (applicationContext.getStatusBarHeight() * 3.25).toInt()
        recyclerview.layoutManager = LinearLayoutManager(this) as RecyclerView.LayoutManager?
        recyclerview.adapter = NoteRecyclerAdapter(this, DataManager.imagesUrl)

    }


}

