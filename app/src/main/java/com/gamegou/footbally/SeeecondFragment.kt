package com.gamegou.footbally

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.gamegou.footbally.databinding.FragmentSeeecondBinding
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.delay
import kotlin.random.Random


class SeeecondFragment : Fragment() {

    override fun onPause() {
        onDestroy()
        super.onPause()
    }

    override fun onDestroy() {
        gtgtgthyjhujugtgt = null
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

    private var gtgtgthyjhujugtgt: FragmentSeeecondBinding? = null
    private val frrrr get() = gtgtgthyjhujugtgt ?: throw RuntimeException("FragmentSeeecondBinding = null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        gtgtgthyjhujugtgt = FragmentSeeecondBinding.inflate(inflater, container, false)
        return frrrr.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        try {
            val ftfrrf = "You winn\n${Random.nextInt(from = 100, until = 5000)} points"
            frrrr.tvLoosedTryAgainftgtyh.text = ftfrrf

            lifecycleScope.launchWhenCreated {
                delay(1000)
                findNavController().navigate(R.id.action_seeecondFragment_to_reloadFragment)
            }

        } catch (e: Exception) {
            detdefdfe()
        }


        super.onViewCreated(view, savedInstanceState)
    }

    private fun detdefdfe() {
        Snackbar.make(
            frrrr.root,
            "Oops something went wrong, please try again...",
            Snackbar.LENGTH_LONG
        ).show()
        requireActivity().onBackPressed()
    }
}