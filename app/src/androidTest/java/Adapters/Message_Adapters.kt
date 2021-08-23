package Adapters

import android.content.Context
import android.view.LayoutInflater
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

        val priceTxt = row.findViewById<TextView>(R.id.priceTxt)
        val addressAndFloorTxt = row.findViewById<TextView>(R.id.addressAndFloorTxt)
        val descriptionTxt = row.findViewById<TextView>(R.id. descriptionTxt)

        descriptionTxt.text = data.getFormattedPrice()

        descriptionTxt.text = data.description

        addressAndFloorTxt.text = "${data.address}, ${data.getFormattedFloor()}"

        return row





}