package com.gamegou.footbally

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import com.gamegou.footbally.databinding.FragmentInnnffffooomBinding
import com.google.android.material.snackbar.Snackbar

class InnnffffooomFragment : Fragment() {
    private var gtgtgthyjhuju: FragmentInnnffffooomBinding? = null
    private val gtgyhujuju get() = gtgtgthyjhuju ?: throw RuntimeException("FragmentInnnffffooomBinding = null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        gtgtgthyjhuju = FragmentInnnffffooomBinding.inflate(inflater, container, false)
        return gtgyhujuju.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        try {

            gtgyhujuju.root.background.alpha = 190
            gtgyhujuju.btnImgExitInfo.setOnClickListener {
                kpkpkpkp()
            }
            gtgyhujuju.btnUnderstandGameRules.setOnClickListener {
                requireActivity().onBackPressed()
            }

        } catch (e: Exception) {
            detdefdfe()
        }


        super.onViewCreated(view, savedInstanceState)
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

    override fun onPause() {
        onDestroy()
        super.onPause()
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