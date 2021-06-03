package com.pavitha.assignmentonlineandlocaldb.ui.main.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.pavitha.assignmentonlineandlocaldb.R
import com.pavitha.assignmentonlineandlocaldb.data.model.Data
import com.pavitha.assignmentonlineandlocaldb.data.model.EmployeeResponse
import com.pavitha.assignmentonlineandlocaldb.databinding.ListItemBinding
import javax.inject.Inject

class EmployeeListAdapter  () : RecyclerView.Adapter<EmployeeListAdapter.MyViewHolder>(){
    private var usersList=ArrayList<Data>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater =LayoutInflater.from(parent.context)
        val binding :ListItemBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.list_item, parent, false
        )
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(usersList[position])

    }
    fun setList( list:List<Data> ){
        usersList.clear()
        usersList.addAll(list)
//        usersList.add(Data("https://gari.capgemini.com/#/app/home img/faces/12-image.jpg","pavithasakthi1@gmail.com","Pavitha",1,"Pichaimani"))
//        usersList.add(Data("https://reqres.in/img/faces/9-image.jpg","pavithasakthi1@gmail.com","Pavitha",2,"Pichaimani"))
//        usersList.add(Data("https://reqres.in/img/faces/10-image.jpg","pavithasakthi1@gmail.com","Pavitha",3,"Pichaimani"))
//        usersList.add(Data("https://reqres.in/img/faces/11-image.jpg","pavithasakthi1@gmail.com","Pavitha",4,"Pichaimani"))
//        usersList.add(Data("https://reqres.in/img/faces/8-image.jpg","pavithasakthi1@gmail.com","Pavitha",5,"Pichaimani"))
    }

    override fun getItemCount(): Int {
        return usersList.size
    }

    class MyViewHolder(private val listItemBinding: ListItemBinding) :RecyclerView.ViewHolder(
        listItemBinding.root
    ) {
        fun bind(users: Data) {
            val name = "${users.firstName} ${users.lastName}"
            listItemBinding.name.text = name
            listItemBinding.email.text = users.email
            loadImage(listItemBinding.userImage, users.avatar)
            listItemBinding.layoutItem.setOnClickListener {
               // clickListener(users)
            }
        }

        private fun loadImage(view: ImageView, imagePath: String) {
            Glide.with(view)
                .load(imagePath)
                .into(view)

        }

    }
    }
