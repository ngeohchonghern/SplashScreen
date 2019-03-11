package com.raymondyang.constraintlayouttesting

import android.content.Context
import android.graphics.ImageDecoder
import android.graphics.drawable.Animatable
import androidx.appcompat.app.AppCompatActivity
import com.facebook.drawee.controller.BaseControllerListener
import com.facebook.imagepipeline.image.ImageInfo

class MyControllerListener(private val context: AppCompatActivity) : BaseControllerListener<ImageInfo>() {
    override fun onFinalImageSet(id: String?, imageInfo: ImageInfo?, animatable: Animatable?) {
        context.supportStartPostponedEnterTransition()

    }
//    override fun onFinalImageSet(id: String?, imageInfo: ImageDecoder.ImageInfo?, animatable: Animatable?) {
//        context.supportStartPostponedEnterTransition()
//    }

}