package com.example.kphotoalbum.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.example.kphotoalbum.R
import com.example.kphotoalbum.model.Photo
import com.squareup.picasso.Picasso
import java.util.ArrayList

class PhotoPagerAdapter(context: Context) : PagerAdapter() {

    private val mLayoutInflater: LayoutInflater
    private var mPhotoList: List<Photo> = ArrayList<Photo>()

    init {
        mLayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }

    fun setImageList(photos: List<Photo>) {
        this.mPhotoList = photos
        notifyDataSetChanged()
    }

    override fun getCount(): Int {
        return mPhotoList.size
    }

    override fun isViewFromObject(view: View, obj: Any): Boolean {
        return view === obj
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val itemView = mLayoutInflater.inflate(R.layout.fullscreen_photo_item, container, false)

        val photo = mPhotoList[position]
        val imageView = itemView.findViewById<ImageView>(R.id.photo_view)
        Picasso.get().load(photo.url).into(imageView)
        val titleView = itemView.findViewById<TextView>(R.id.title_view)
        titleView.setText(photo.name)
        container.addView(itemView)
        return itemView
    }

    override fun destroyItem(container: ViewGroup, position: Int, obj: Any) {
        container.removeView(obj as RelativeLayout)
    }

}