
package com.example.eka_3tie.Message

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.bumptech.glide.Glide
import com.example.eka_3tie.databinding.ItemMessageBinding
import com.google.android.material.snackbar.Snackbar

class MessageAdapter(
    context: Context,
    private val messages: List<MessageModel>
) : ArrayAdapter<MessageModel>(context, 0, messages) {

    private class ViewHolder(
        val binding: ItemMessageBinding
    )

    override fun getView(
        position: Int,
        convertView: View?,
        parent: ViewGroup
    ): View {

        val holder: ViewHolder
        val view: View

        if (convertView == null) {
            val binding = ItemMessageBinding.inflate(
                LayoutInflater.from(context),
                parent,
                false
            )

            holder = ViewHolder(binding)
            view = binding.root
            view.tag = holder
        } else {
            view = convertView
            holder = view.tag as ViewHolder
        }

        val message = messages[position]

        Glide.with(context)
            .load(message.avatarUrl)
            .into(holder.binding.avatarImg)

        holder.binding.textSender.text = message.senderName
        holder.binding.textMessage.text = message.messageText

        view.setOnClickListener {
            Snackbar.make(
                parent,
                "Pesan dari ${message.senderName}: ${message.messageText}",
                Snackbar.LENGTH_SHORT
            ).show()
        }

        return view
    }
}
