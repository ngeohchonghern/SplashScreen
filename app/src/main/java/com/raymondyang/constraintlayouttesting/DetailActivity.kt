package com.raymondyang.constraintlayouttesting

import android.database.Observable
import android.graphics.ImageDecoder
import android.graphics.drawable.Animatable
import android.graphics.drawable.Drawable
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.transition.AutoTransition
import android.transition.TransitionManager
import androidx.constraintlayout.widget.ConstraintSet
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.drawee.controller.BaseControllerListener
import com.facebook.drawee.controller.ControllerListener
import com.facebook.imagepipeline.request.ImageRequestBuilder
import com.kelin.translucentbar.library.TranslucentBarManager
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.activity_detail.*
import org.reactivestreams.Subscriber
import java.util.*
import java.util.concurrent.TimeUnit

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        var translucentBarManager = TranslucentBarManager(this)
        translucentBarManager.transparent(this, android.R.color.transparent);
        supportPostponeEnterTransition()

        var bundle = intent.extras
        simple_drawee.setTransitionName(bundle.getString("TRANSITION_NAME"))
        var uri = Uri.parse(bundle.getString("IMAGE_URI"))
//        GlideDra
        Glide.with(this)
                .load(uri)
                .listener(object : RequestListener<Drawable> {
                    override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<Drawable>?, isFirstResource: Boolean): Boolean {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }

                    override fun onResourceReady(resource: Drawable?, model: Any?, target: Target<Drawable>?, dataSource: DataSource?, isFirstResource: Boolean): Boolean {
                        texttitle.setText("Life  in  a converted grain  silo.")
                        this@DetailActivity.supportStartPostponedEnterTransition()


                        val constraintSet = ConstraintSet()
                        constraintSet.clone(detailconstraint)

                        constraintSet.connect(texttitle.id, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP)
                        val autoTransition = AutoTransition().setDuration(2000)
                        TransitionManager.beginDelayedTransition(detailconstraint, autoTransition)
                        constraintSet.applyTo(detailconstraint)




                        return false
                    }
                })
                .centerCrop()
                .into(simple_drawee)

//        simple_drawee.setImageURI(uri)

//        val request = ImageRequestBuilder.newBuilderWithSource(uri)
//                .setProgressiveRenderingEnabled(true)
//                .build()
//
//        val controller = Fresco.newDraweeControllerBuilder()
//                .setImageRequest(request)
//                .setOldController(simple_drawee.getController())
////                .setControllerListener(MyControllerListener(this))
//                .build()
//        simple_drawee.setController(controller)
    }


}

