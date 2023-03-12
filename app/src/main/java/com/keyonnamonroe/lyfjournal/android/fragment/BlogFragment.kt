package com.keyonnamonroe.lyfjournal.android.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.keyonnamonroe.lyfjournal.android.databinding.FragmentBlogBinding

class BlogFragment : BaseFragment() {

    // view binding
    private var _binding: FragmentBlogBinding? = null

    // this property is only valid between onCreateView and onDestroyView
    private val binding: FragmentBlogBinding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBlogBinding.inflate(inflater, container, false)

        // initialize views and handlers
        initializeViews()
        initializeHandlers()
        // return root
        return binding.root
    }

    /**
     * Method is used to initialize views.
     */
    private fun initializeViews() {

    }

    /**
     * Method is used to set click listeners.
     */
    private fun initializeHandlers() {

    }


}
