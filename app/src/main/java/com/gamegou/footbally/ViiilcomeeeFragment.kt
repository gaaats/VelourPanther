package com.gamegou.footbally

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.gamegou.footbally.databinding.FragmentViiilcomeeeBinding
import com.google.android.material.snackbar.Snackbar

class ViiilcomeeeFragment : Fragment() {


    private fun afrhgthUygtgtgttt() {
        Snackbar.make(
            polafgttt.root,
            "I have error, try again",
            Snackbar.LENGTH_LONG
        ).show()
        requireActivity().onBackPressed()
    }

    private var gtugtttt: FragmentViiilcomeeeBinding? = null
    private val polafgttt
        get() = gtugtttt ?: throw RuntimeException("FragmentViiilcomeeeBinding = null")


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        gtugtttt = FragmentViiilcomeeeBinding.inflate(inflater, container, false)
        return polafgttt.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        try {

            polafgttt.root.background.alpha = 220

            polafgttt.btnPlayGame.setOnClickListener {
                findNavController().navigate(R.id.action_viiilcomeeeFragment_to_starttttttFragment)
            }

        } catch (e: Exception) {
            afrhgthUygtgtgttt()
        }

        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroy() {
        gtugtttt = null
        super.onDestroy()
    }

    override fun onPause() {
        onDestroy()
        super.onPause()
    }




}