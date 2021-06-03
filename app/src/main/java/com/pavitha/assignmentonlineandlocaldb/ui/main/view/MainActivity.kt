package com.pavitha.assignmentonlineandlocaldb.ui.main.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.pavitha.assignmentonlineandlocaldb.R
import com.pavitha.assignmentonlineandlocaldb.data.model.Data
import com.pavitha.assignmentonlineandlocaldb.data.model.EmployeeResponse
import com.pavitha.assignmentonlineandlocaldb.data.network.EmployeeService
import com.pavitha.assignmentonlineandlocaldb.data.repository.EmployeeRepository
import com.pavitha.assignmentonlineandlocaldb.databinding.ActivityMainBinding
import com.pavitha.assignmentonlineandlocaldb.di.NetworkModule
import com.pavitha.assignmentonlineandlocaldb.ui.main.view.adapter.EmployeeListAdapter
import com.pavitha.assignmentonlineandlocaldb.ui.main.viewmodel.MainViewModel
import com.pavitha.assignmentonlineandlocaldb.ui.main.viewmodel.MainViewModelFactory
import com.pavitha.assignmentonlineandlocaldb.utils.Status
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var mainActivityMainBinding:ActivityMainBinding
    private lateinit var adapter:EmployeeListAdapter
    private lateinit var viewModel:MainViewModel
    @Inject
    lateinit var  viewModelFactory:MainViewModelFactory


    private lateinit var listAdapter: EmployeeListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivityMainBinding =DataBindingUtil.setContentView(this,R.layout.activity_main)
        mainActivityMainBinding.lifecycleOwner = this
        setupViewModel()
        setupUI()
        setupObservers()


    }
    private fun setupViewModel() {
        viewModel = ViewModelProvider(this,viewModelFactory).get(MainViewModel::class.java)

    }

    private fun setupUI() {
        mainActivityMainBinding.employeeList.layoutManager = LinearLayoutManager(this)
         adapter = EmployeeListAdapter()
        mainActivityMainBinding.employeeList.adapter = adapter
    }

    private fun setupObservers() {
        viewModel.getEmployeesList().observe(this, Observer {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        mainActivityMainBinding.employeeList.visibility = View.VISIBLE
                        mainActivityMainBinding.progressBar.visibility = View.GONE
                        resource.data?.let {
                                users -> retrieveList(users) }
                    }
                    Status.ERROR -> {
                        mainActivityMainBinding.employeeList.visibility = View.VISIBLE
                        mainActivityMainBinding.progressBar.visibility = View.GONE
                        Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                    }
                    Status.LOADING -> {
                        mainActivityMainBinding.progressBar.visibility = View.VISIBLE
                        mainActivityMainBinding.employeeList.visibility = View.GONE
                    }
                }
            }
        })
    }

    private fun retrieveList(users: EmployeeResponse) {
        adapter.apply {
            setList(users.data)
            notifyDataSetChanged()
        }
    }
    private fun listItemClick(selectedItem: Data) {
    //    viewModel.initUpdateOrDelete(user)
        Snackbar.make(
            mainActivityMainBinding.root,
            "id${selectedItem.firstName} and ${selectedItem.email}",
            Snackbar.LENGTH_LONG
        ).show()

    }
}