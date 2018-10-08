package com.ahasanidea.kotlin.roomdatabase.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import com.ahasanidea.kotlin.roomdatabase.R

import com.ahasanidea.kotlin.roomdatabase.model.User

class UserListAdapter : RecyclerView.Adapter<UserListAdapter.ViewHolder>() {
    private var userList: ArrayList<User>? = null

    init {
        userList = ArrayList()
    }

    interface OnClickListener {
        fun onItemClick(u: User)
        fun onItemDelete(u: User)
    }

    private lateinit var onClickListener: OnClickListener

    fun setListener(listener: OnClickListener) {
        this.onClickListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false))
    }

    override fun getItemCount(): Int {
        return userList!!.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = userList!![position]
        holder.bindItems(user, onClickListener)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(user: User, onClickListener: OnClickListener) {
            val tvName = itemView.findViewById<TextView>(R.id.tvName)
            val tvAddress = itemView.findViewById<TextView>(R.id.tvAddress)
            tvName.text = user.name
            tvAddress.text = user.address

            itemView.setOnClickListener {
                onClickListener.onItemClick(user)
            }
            itemView.findViewById<ImageButton>(R.id.ibDelete).setOnClickListener {
                onClickListener.onItemDelete(user)
            }
        }

    }

    fun addItems(users: ArrayList<User>) {
        this.userList = users
        notifyDataSetChanged()
    }
}