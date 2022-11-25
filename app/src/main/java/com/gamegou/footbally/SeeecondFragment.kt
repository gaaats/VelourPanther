package com.gamegou.footbally

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.gamegou.footbally.databinding.FragmentInnnffffooomBinding
import com.gamegou.footbally.databinding.FragmentSeeecondBinding
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.delay
import kotlin.random.Random


class SeeecondFragment : Fragment() {
    private var gtgtgthyjhuju: FragmentSeeecondBinding? = null
    private val gtgyhujuju get() = gtgtgthyjhuju ?: throw RuntimeException("FragmentSeeecondBinding = null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        gtgtgthyjhuju = FragmentSeeecondBinding.inflate(inflater, container, false)
        return gtgyhujuju.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        try {
            val crftgt = "You winn\n${Random.nextInt(from = 100, until = 5000)} points"
            gtgyhujuju.tvLoosedTryAgainftgtyh.text = crftgt

            lifecycleScope.launchWhenCreated {
                delay(1000)
                findNavController().navigate(R.id.action_seeecondFragment_to_reloadFragment)
            }

        } catch (e: Exception) {
            detdefdfe()
        }


        super.onViewCreated(view, savedInstanceState)
    }

    override fun onPause() {
        onDestroy()
        super.onPause()
    }

    override fun onDestroy() {
        gtgtgthyjhuju = null
        super.onDestroy()
    }

    private fun kpkpkpkp() {
        AlertDialog.Builder(requireContext())
            .setTitle("Exit")
            .setMessage("Current data will not be saved, EXIT?")
            .setPositiveButton("Yes, Exit") { _, _ ->
                requireActivity().onBackPressed()
            }
            .setNegativeButton("No") { _, _ ->
            }
            .setCancelable(true)
            .create()
            .show()
    }



    private fun detdefdfe() {
        Snackbar.make(
            gtgyhujuju.root,
            "Oops something went wrong, please try again...",
            Snackbar.LENGTH_LONG
        ).show()
        requireActivity().onBackPressed()
    }




}