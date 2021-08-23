package com.nepplus.numberbaseballgame_20210823

import android.os.PersistableBundle
import kotlinx.android.synthetic.main.activity_main.*





import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nepplus.numberbaseballgame_20210823.Adapters.Message_Adapters
import com.nepplus.numberbaseballgame_20210823.Datas.MessageData

class MainActivity : AppCompatActivity() {

    val mMessageList = ArrayList<MessageData>()

    lateinit var mAdapter : Message_Adapters

    //세자리 문제 숫자를 저장하기 위한 Arraylist

    val mQuestionNumers = ArrayList<Int>()

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //세자리 랜덤 문제 만들기

        makeQuestionNumbers()


        mMessageList.add( MessageData("안녕하세요", "CPU"))
        mMessageList.add( MessageData("반갑습니다", "User"))

        mAdapter = MessageAdapter(this, R.layout, list, mMessageList)
        messageListView.adapter = mAdapter

        okBtn.setOnClickListener {

            val inputNumStr = numberEdt.text.toString()

            val msg = MessageData( inputNumStr, "USER")

            mMessageList.add(msg)

            mAdapter.notifyDataSetChanged()

            //numberEdt 문구 비워주기

            numberEdt.setText("")

            //문구 비운 뒤 리스트뷰 최하단으로 내리고 싶다
            messageListView.smoothScrollToPosition(mMessageList.size -1)


        }


    }

    fun makeQuestionNumbers() {

        //고정된 세개 숫자를 임시 문제로

        mQuestionNumers.add(4)
        mQuestionNumers.add(7)
        mQuestionNumers.add(1)

        //환영메세지를 채팅창에 채우자
        //메세지 리스트에 띄어줄 말을 데이터를 추가하자

         mMessageList.add(MessageData("어서오세요", "CPU"))
        mMessageList.add(MessageData("숫자 야구 게임입니다", "CPU"))
        mMessageList.add(MessageData("세자리 숫자를 맞춰주세요", "CPU"))












    }
}