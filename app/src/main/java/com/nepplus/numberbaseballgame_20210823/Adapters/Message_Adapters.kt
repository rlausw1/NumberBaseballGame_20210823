package com.nepplus.numberbaseballgame_20210823.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import com.nepplus.numberbaseballgame_20210823.Datas.MessageData
import com.nepplus.numberbaseballgame_20210823.R

class Message_Adapters(

    val mContext: Context,
    val resId: Int,
    val mList: ArrayList<MessageData>
) : ArrayAdapter<MessageData>(mContext, resId, mList) {

    val mInflater = LayoutInflater.from(mContext)


    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var tempRow = convertView

        if (tempRow == null) {
            tempRow = mInflater.inflate(R.layout.list, null)
        }

        val row = tempRow!!

        val data = mList[position]

        val cpuMessageLayout = row.findViewById<LinearLayout>(R.id.computermessageLayout)
        val cpuMessageTxt = row.findViewById<LinearLayout>(R.id.computerMessageTxt)
        val userMessageLayout = row.findViewById<LinearLayout>(R.id.usemessageLayout)
        val userMessageTxt = row.findViewById<LinearLayout>(R.id.usemessageTxt)

        if (data.writer == "CPU") {

            userMessageLayout.visibility = View.GONE
            computerMessageTxt.text = data.content

        } else {

            computermessageLayout.visibility = View.GONE
            usemessageTxt.text = data.content


        }
    }

    return row


}