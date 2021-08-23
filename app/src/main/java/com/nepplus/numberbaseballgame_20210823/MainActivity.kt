package com.nepplus.numberbaseballgame_20210823

import android.os.PersistableBundle
import kotlinx.android.synthetic.main.activity_main.*


class MessageData(
    val content : String
    val writer : String ) {




}


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    val mMessageList = ArrayList<MessageData>()

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mMessageList.add( MessageData("안녕하세요", "CPU"))
        mMessageList.add( MessageData("반갑습니다", "User"))

        madapter = MessageAdapter(this, R.layout, Message_list_item, mMessageList)
        messageListView.adapter





    }
}