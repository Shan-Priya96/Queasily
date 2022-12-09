package com.example.queasily

import android.app.Application
import android.app.PendingIntent.getActivity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.withContext
import java.security.AccessControlContext
import java.security.AccessController
import java.security.AccessController.getContext



class quizAdapter(private val qlist:ArrayList<quiz_data>, private val context: upcomingFragment): RecyclerView.Adapter<quizAdapter.ViewHolder>()  {

        private lateinit var cont:Context
        private lateinit var rootView:View
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): quizAdapter.ViewHolder{

        val v = LayoutInflater.from(parent.context).inflate(R.layout.quiz_layout, parent, false)

        cont = parent.getContext()
        return ViewHolder(v)

    }

    override fun getItemCount(): Int {
        return qlist.size
    }

    override fun onBindViewHolder(holder:quizAdapter.ViewHolder, position: Int){


        val curr: quiz_data = qlist[position]
        holder.quiz_name.text = curr.quizname
        holder.quiz_publish.text = curr.quiz_publish
        holder.teacher_name.text = curr.teacher_name

        holder.mybutton.setOnClickListener{
            val bundle = Bundle()
            // Context = this.context


            if (getContext() !=null){
                val newIntent = Intent(cont, Questions::class.java)
                startActivity(cont,newIntent, bundle)
            }


        }

    }
    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {


        var quiz_name: TextView = itemView.findViewById(R.id.qname)
        var quiz_publish: TextView = itemView.findViewById(R.id.date_publish)
        var teacher_name: TextView = itemView.findViewById(R.id.teacher)
        var mybutton: Button = itemView.findViewById(R.id.attempt)


//        fun ViewHolder(itemView: View) {
//            mybutton.setOnClickListener() {
//                val newIntent = Intent(itemView.context, PageActivity::class.java)
//                itemView.context.startActivity(newIntent)
//            }
//
//
//        }


    }
}