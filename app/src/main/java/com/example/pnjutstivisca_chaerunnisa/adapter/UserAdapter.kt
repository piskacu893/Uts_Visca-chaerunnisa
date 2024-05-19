package com.example.pnjutstivisca_chaerunnisa.adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pnjutstivisca_chaerunnisa.R
import com.example.pnjutstivisca_chaerunnisa.data.entity.User


class UserAdapter (var list: List<User>) : RecyclerView.Adapter<UserAdapter.ViewHolder>(){
    private lateinit var dialog: Dialog

    fun setDialog(dialog: Dialog){
        this.dialog = dialog
    }
    interface Dialog {
        fun onclick(position: Int)
    }


    inner  class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        var nim: TextView
        var Nama_Alumni: TextView


        init {
            nim = view.findViewById(R.id.nim)
            Nama_Alumni = view.findViewById(R.id.Nama_Alumni)
            view.setOnClickListener{
                dialog.onclick(layoutPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_user, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.Nama_Alumni.text = list[position].Nama_Alumni
    }
}