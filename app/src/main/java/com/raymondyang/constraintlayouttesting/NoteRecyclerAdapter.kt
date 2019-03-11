package com.raymondyang.constraintlayouttesting

import android.animation.Animator
import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatAutoCompleteTextView
import androidx.core.app.ActivityOptionsCompat
import androidx.core.app.SharedElementCallback
import androidx.core.view.ViewCompat
import androidx.core.widget.ImageViewCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.facebook.drawee.drawable.ScalingUtils
import com.facebook.drawee.view.DraweeTransition
import com.facebook.drawee.view.SimpleDraweeView
import kotlinx.android.synthetic.main.framelayout_item.view.*

class NoteRecyclerAdapter(private val context: AppCompatActivity, private val imagesUrl: ArrayList<ImageData>) :
        RecyclerView.Adapter<NoteRecyclerAdapter.ViewHolder>(){

    private val mDuration: Short = 300
    private val mFrom = .5f

    private val inflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = inflater.inflate(R.layout.framelayout_item, parent, false)
        return ViewHolder(itemView)
    }

//    override fun getItemCount(): Int {
//        return 10
//    }

    override fun getItemCount() = imagesUrl.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        for (anim in getAnimators(holder.itemView.cardview)) {
            anim.setDuration(mDuration.toLong()).start()
        }
        var title = imagesUrl[position].title
        holder.itemView.titletext.setText(title)
        var uri = imagesUrl[position].url
//        holder.simpledrawee?.setImageURI(uri)
        Glide.with(context).load(uri)
                .centerCrop()
                .into(holder.simpledrawee);

        ViewCompat.setTransitionName(holder.itemView.cardview.simpledrawee, "image$position")
        var sharedImageView = holder.itemView.cardview.simpledrawee
        var view = holder.itemView
        holder.itemView.setOnClickListener{view ->
            var intent = Intent(context, DetailActivity::class.java)
            intent.putExtra("IMAGE_URI", uri)
            intent.putExtra("TRANSITION_NAME", holder.itemView.cardview.simpledrawee.transitionName)

//            val window = context.getWindow()

//            if (sharedImageView is SimpleDraweeView) {
//                window.sharedElementEnterTransition = DraweeTransition.createTransitionSet(
//                        ScalingUtils.ScaleType.CENTER_CROP, ScalingUtils.ScaleType.CENTER_CROP)
//                window.sharedElementExitTransition = DraweeTransition.createTransitionSet(
//                        ScalingUtils.ScaleType.CENTER_CROP, ScalingUtils.ScaleType.CENTER_CROP)
//                context.setExitSharedElementCallback(object : SharedElementCallback() {
//
//                   override fun onSharedElementEnd(sharedElementNames: List<String>,
//                                           sharedElements: List<View>,
//                                           sharedElementSnapshots: List<View>) {
//
//                        super.onSharedElementEnd(sharedElementNames, sharedElements,
//                                sharedElementSnapshots)
//
//                        for (sharedImageView in sharedElements) {
//                            sharedImageView.visibility = View.VISIBLE
//                        }
//                    }
//                })
//            }


            var optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(context, sharedImageView, "image$position")

            context.startActivity(intent, optionsCompat.toBundle())
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val simpledrawee = itemView.findViewById<ImageView>(R.id.simpledrawee)
        val titletext = itemView.findViewById<AppCompatAutoCompleteTextView>(R.id.titletext)

//        val scaleY = ObjectAnimator.ofFloat(view, "scaleY", mFrom, 1f)
    }

    protected fun getAnimators(view: View): MutableList<ObjectAnimator> {
        val scaleX = ObjectAnimator.ofFloat(view, "scaleX", mFrom, 1f)
        val scaleY = ObjectAnimator.ofFloat(view, "scaleY", mFrom, 1f)
        val list:MutableList<ObjectAnimator> = ArrayList()
        list.add(scaleX)
        list.add(scaleY)
        return list
    }
}