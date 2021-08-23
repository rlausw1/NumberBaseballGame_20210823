package Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.nepplus.jikbang_project_20210820.Datas.RoomData
import com.nepplus.jikbang_project_20210820.R
import com.nepplus.numberbaseballgame_20210823.R
import java.text.FieldPosition

class Message_Adapters (

    val mContext : Context,
    val resId : Int,
    val mList : ArrayList<MessageData>) : ArrayAdapter<Messagedata>(mContext, resId, mList) {

    val mInflater = LayoutInflater.from(mContext)


    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

    var tempRow = convertView

        if (tempRow ==null) {
            tempRow = mInflater.inflate(R.layout.message_list_item, null)
    }

    val row = tempRow!!

        val data = mList[position]

        val cpuMessageLayout = row.findViewById(R.id.cpuMessageLayout)
        val cpuMessageTxt = row.findViewById(R.id.cpuMessageTxt)
        val userMessageLayout = row.findViewById(R.id.userMessageLayout)
        val userMessageTxt = row.findViewById(R.id.userMessageTxt)

        if (data.writer == "CPU") {

            userMessageLayout.visibility = View.GONE
            cpuMessageTxt.text = data.content

        }
        else {

            cpuMessageLayout.visibility = View.GONE
            userMessageTxt.text = data.content



        }
        }

        return row





}