package com.example.testapp.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testapp.R
import com.example.testapp.data.model.Result
import com.example.testapp.databinding.FragmentBanklistBinding
import com.example.testapp.ui.adapter.BankAdapter
import com.example.testapp.ui.viewmodel.BankViewModel
import com.example.testapp.utils.Resource
import com.example.testapp.utils.handleApiError
import com.example.testapp.utils.hide
import com.example.testapp.utils.show
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BankListFragment: Fragment(R.layout.fragment_banklist),ItemClick{

    lateinit var binding: FragmentBanklistBinding
    private val viewModel by viewModels<BankViewModel> ()
    lateinit var bankAdapter:BankAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentBanklistBinding.bind(view)

        setUpUi()
        setUpObserver()

    }

    private fun setUpUi()
    {
        binding.recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(requireContext())
        }
        bankAdapter = BankAdapter(this)
        binding.recyclerView.adapter = bankAdapter


    }

    private fun setUpObserver()
    {
        viewModel.bankListItemsLiveData.observe(viewLifecycleOwner, Observer { result->

            when(result)
            {
                is Resource.Loading -> binding.progressBar.show()

                is Resource.Failure -> {

                    binding.progressBar.hide()
                    handleApiError(result)

                }
                is Resource.Success -> {
                    binding.progressBar.hide()
                    bankAdapter.item = result.value.results
                }

            }

        })


    }

    override fun itemClick(result: Result) {

        val bundle = Bundle()
        bundle.putString("name",result.name)
        findNavController().navigate(R.id.list_to_home,bundle)

    }
}