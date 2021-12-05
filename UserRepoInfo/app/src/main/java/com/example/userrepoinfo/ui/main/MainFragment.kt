package com.example.userrepoinfo.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.example.userrepoinfo.R
import com.example.userrepoinfo.data.ReposModel

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    private lateinit var reposAdapter: ReposAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel.getRepos()?.observe( viewLifecycleOwner, object : Observer<List<ReposModel>> {
            override fun onChanged(t: List<ReposModel>?) {
                if (t != null) {
                    viewModel.userReposList = t
                    reposAdapter = ReposAdapter(t)
                }
//                reposAdapter = t?.let { ReposAdapter(it) }!!
//                reposAdapter.notifyDataSetChanged()
//                recyclerViewBooks.adapter = booksAdapter
            }

        })

    }

//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
//
////        viewModel.loadUsers()
//
//        viewModel.getRepos()?.observe( viewLifecycleOwner, object : Observer<List<ReposModel>> {
//            override fun onChanged(t: List<ReposModel>?) {
//                if (t != null) {
//                    viewModel.userReposList = t
//                    reposAdapter = ReposAdapter(t)
//                }
////                reposAdapter = t?.let { ReposAdapter(it) }!!
////                reposAdapter.notifyDataSetChanged()
////                recyclerViewBooks.adapter = booksAdapter
//            }
//
//        })

//        if(viewModel.userReposList!= null) {
//            reposAdapter = ReposAdapter(viewModel.userReposList)
//            reposAdapter.notifyDataSetChanged()
//        }
//    }

}