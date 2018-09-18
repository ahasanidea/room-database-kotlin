package com.ahasanidea.kotlin.roomdatabase.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import com.ahasanidea.kotlin.roomdatabase.R

import com.ahasanidea.kotlin.roomdatabase.model.User

class UserListAdapter(private var userList: ArrayList<User>) : RecyclerView.Adapter<UserListAdapter.ViewHolder>() {
    interface OnClickListener {
        fun onItemClick(u: User)
        fun onItemDelete(u: User)
    }
    private var onClickListener: OnClickListener? = null

    fun setListener(listener: OnClickListener) {
        this.onClickListener = listener
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false))
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = userList[position]
        holder.bindItems(user, onClickListener)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(user: User,onClickListener:OnClickListener?) {
            val tvName = itemView.findViewById<TextView>(R.id.tvName)
            val tvAddress = itemView.findViewById<TextView>(R.id.tvAddress)
            tvName.text = user.name
            tvAddress.text = user.item

            itemView.setOnClickListener{
                if (onClickListener != null) {
                    onClickListener!!.onItemClick(user)
                }
            }
            itemView.findViewById<ImageButton>(R.id.ibDelete).setOnClickListener{
                if (onClickListener != null) {
                    onClickListener!!.onItemDelete(user)
                }
            }
        }

    }
    fun addItems(users: ArrayList<User>) {
        this.userList = users
        notifyDataSetChanged()
    }
}