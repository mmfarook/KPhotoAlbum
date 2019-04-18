package com.example.kphotoalbum.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.kphotoalbum.R
import com.example.kphotoalbum.model.Photo
import com.squareup.picasso.Picasso

class PhotoAdapter(private val mItemClickListener: ItemClickListener?) :
    ListAdapter<Photo, PhotoAdapter.PhotoViewHolder>(diffCallback) {

    interface ItemClickListener {
        fun onItemClick(position: Int)
    }

    inner class PhotoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageView: ImageView
        private val titleView: TextView?

        init {
            imageView = itemView.findViewById(R.id.photo_view)
            titleView = itemView.findViewById(R.id.title_view)
        }

        fun bindTo(position: Int, photo: Photo) {
            if (mItemClickListener != null) {
                imageView.setOnClickListener { v: View -> mItemClickListener.onItemClick(position) }
            }
            titleView?.setText(photo.name)
            Picasso.get().load(photo.url).placeholder(R.drawable.placeholder_image).into(imageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.photo_item, parent, false)
        return PhotoViewHolder(itemView)
    }

    override fun onBindViewHolder(mholder: PhotoViewHolder, position: Int) {
        val photo = getItem(position)
        mholder.bindTo(position, photo)
    }

    companion object {

        private val diffCallback = object : DiffUtil.ItemCallback<Photo>() {
            override fun areItemsTheSame(oldItem: Photo, newItem: Photo): Boolean {
                return oldItem.id.equals(newItem.id)
            }

            override fun areContentsTheSame(oldItem: Photo, newItem: Photo): Boolean {
                return areItemsTheSame(oldItem, newItem)

            }
        }
    }
}
