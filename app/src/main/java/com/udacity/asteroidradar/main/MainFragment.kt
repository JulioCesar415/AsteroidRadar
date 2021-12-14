package com.udacity.asteroidradar.main

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.udacity.asteroidradar.R
import com.udacity.asteroidradar.database.AsteroidDatabase
import com.udacity.asteroidradar.database.DatabaseEntities
import com.udacity.asteroidradar.databinding.FragmentMainBinding

class MainFragment : Fragment() {

//    private val viewModel: MainViewModel by lazy {
//        ViewModelProvider(this).get(MainViewModel::class.java)
//    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
//        val binding = FragmentMainBinding.inflate(inflater)

//        bind to resource layout file
        val binding: FragmentMainBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_main, container, false
        )

//        get reference to application
        val application = requireNotNull(this.activity).application
//        get reference to DAO of database
        val dataSource = AsteroidDatabase.getInstance(application).asteroidDatabaseDao
//        create instance of viewModelFactory
        val viewModelFactory = MainViewModelFactory(dataSource, application)

//        reference to MainViewModel
        val viewModel = ViewModelProvider(
            this, viewModelFactory
        ).get(MainViewModel::class.java)

//        pass mainViewModel binding variable to mainViewModel
        binding.viewModel = viewModel

//        set current activity as the lifecycle owner of the binding
        binding.lifecycleOwner = this

//        tell RecyclerView about adapter.
        val adapter = AsteroidMainAdapter()
//        use adapter to display views on the screen
        binding.asteroidRecycler.adapter = adapter

//        tell adapter what data it should adapt
        viewModel.asteroids.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.submitList(it)
            }
        })

        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_overflow_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return true
    }
}
