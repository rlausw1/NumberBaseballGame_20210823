package com.nepplus.numberbaseballgame_20210823

import android.os.PersistableBundle
import kotlinx.android.synthetic.main.activity_main.*





import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
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


            //컴퓨터가 ?S, ?B 인지 판단해서 메세지 추가 (답장)
            checkAnswer()


        }


    }

    fun checkAnswer(inputNum : Int) {

        //사람이 입력한 숫자가 ?S ?B 인지 판단하는 함수
        //사람이 입력한 숫자를 => 각 자리별로 나눠서 => 목록에 대답.

        val userInputNumArr = ArrayList<Int>()

        userInputNumArr.add(  inputNum / 100   ) //100자리가 몇?
        userInputNumArr.add(  inputNum / 10 %  10   )
        userInputNumArr.add(  inputNum % 10   )

        var strikeCount = 0
        var ballCount = 0



        for ( i in0..2 ){

            for ( j in 0..2) {

                //내가 입력한 숫자 i번째랑 , 컴푸터가 낸 숫자 i번째가 같은 값인가?

                if ( userInputNumArr[i] == mQuestionNumers[j] ) {

                    //같은 숫자를 찾았다
                    //위치도 같은 위치였는지> 같으면 s, 다르면 b

                    if ( i==j ) {
                        strikeCount++

                        else {

                            ballCount++


                        }
                    }


                }


            }


        }

        //컴퓨터가 값을 말하는 처리 ?s ?b

        mMessageList.add( MessageData( "${strikeCount}S ${ballCount}B 입니다."))

        mAdapter.notifyDataSetChanged()
        messageListView.smoothScrollToPosition(mMessageList.size - 1)

        //만약 3s 였다 -> 축하한다는 메세지 추가 출력 -> 입력 못하게 막기

        if ( strikeCount == 3) {
            mMessageList.add( MessageData( "축하합니다! 정답입니다."))

            mAdapter.notifyDataSetChanged()
            messageListView.smoothScrollToPosition(mMessageList.size - 1)

            Toast.makeText(this, "게임을 종료합니다", Toast.LENGTH_SHORT).show()

            //입력을 막는다 => numberEdt  enabled : false

            numberEdt.isSaveEnabled = false


        }





    }

    fun makeQuestionNumbers() {

        //고정된 세개 숫자를 임시 문제로

//        mQuestionNumers.add(4)
//        mQuestionNumers.add(7)
//        mQuestionNumers.add(1)

        //랜덤한 3개 숫자를 진짜 문제로
        //1~9 숫자만 사용
        //이미 나온 숫자는 또 나오면 안됨

        for ( i in 0..2) {

            while (true) {

                //1~9사이의 랜덤정수 추출
                val rendomNum = ( Math.random()*9 +1).toInt()

                //mQuestion 에 이미 들어있는지 검사

                var isDuplOK = true

                for ( num in mQuestionNumers ) {


                    if (num == rendomNum ) {

                        isDuplOK = false

                        //중복된 숫자 발견 => 쓰면 안된다




                    }



            }



              if (isDuplOK) {

                  mQuestionNumers.add( rendomNum )
                  //무한반복 탈출

                  break

              }

        }

            for ( num in mQuestionNumers ) {
                Log.d("출제된숫자", num.toString()) }

            }

        }






        //환영메세지를 채팅창에 채우자
        //메세지 리스트에 띄어줄 말을 데이터를 추가하자

         mMessageList.add(MessageData("어서오세요", "CPU"))
        mMessageList.add(MessageData("숫자 야구 게임입니다", "CPU"))
        mMessageList.add(MessageData("세자리 숫자를 맞춰주세요", "CPU"))















    }
}