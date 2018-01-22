package com.example.hanyr.smack.Adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.hanyr.smack.Model.Message
import com.example.hanyr.smack.R
import com.example.hanyr.smack.Services.UserDataService

/**
 * Created by Hanyr on 22-Jan-18.
 */
class MessageAdapter(val contex:Context, val messages: ArrayList<Message>): RecyclerView.Adapter<MessageAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(contex).inflate(R.layout.message_list_view, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return messages.count()
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.bindMessage(contex, messages[position])
    }

    inner class ViewHolder(itemView: View?): RecyclerView.ViewHolder(itemView){
        val userImage = itemView?.findViewById<ImageView>(R.id.messageUserImage)
        val timeStamp = itemView?.findViewById<TextView>(R.id.timeStampLbl)
        val userName = itemView?.findViewById<TextView>(R.id.messageUserNameLbl)
        val messageBody = itemView?.findViewById<TextView>(R.id.messageBodyLbl)

        fun bindMessage(contex: Context, message: Message){
            val resourceId = contex.resources.getIdentifier(message.userAvatar,
                    "drawable", contex.packageName)
            userImage?.setImageResource(resourceId)
            userImage?.setBackgroundColor(UserDataService.returnAvatarColor(message.userAvatarColor))
            timeStamp?.text = message.timeStamp
            messageBody?.text = message.message
        }
    }

}