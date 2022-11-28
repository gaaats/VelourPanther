package com.gamegou.footbally

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.gamegou.footbally.databinding.FragmentStarttttttBinding
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class StarttttttFragment : Fragment() {

    private fun gtttt() {
        AlertDialog.Builder(requireContext())
            .setTitle("Exit")
            .setMessage("Exit, realy?")
            .setPositiveButton("Yes, Exit") { _, _ ->
                requireActivity().finish()
            }
            .setNegativeButton("Deny") { _, _ ->
            }
            .setCancelable(true)
            .create()
            .show()
    }

    var gtgtfgt = 0.8f
    var plfrfgtt = 0.05f

    private var gtufgt: FragmentStarttttttBinding? = null
    private val polafr
        get() = gtufgt ?: throw RuntimeException("FragmentStarttttttBinding = null")


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        gtufgt = FragmentStarttttttBinding.inflate(inflater, container, false)
        return polafr.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        try {

            polafr.root.background.alpha = 220

            polafr.btnImgHelp.setOnClickListener {
                findNavController().navigate(R.id.action_starttttttFragment_to_innnffffooomFragment)
            }
            polafr.btnImgExit.setOnClickListener {
                gtttt()

            }



            polafr.btnElem1.setOnClickListener {
                it.visibility = View.GONE
                polskksgtgtt()
            }
            polafr.btnElem2.setOnClickListener {
                it.visibility = View.GONE
                polskksgtgtt()
            }
            polafr.btnElem3.setOnClickListener {
                it.visibility = View.GONE
                polskksgtgtt()
            }
            polafr.btnElem4.setOnClickListener {
                it.visibility = View.GONE
                polskksgtgtt()
            }
            polafr.btnElem5.setOnClickListener {
                it.visibility = View.GONE
                polskksgtgtt()
            }
            polafr.btnElem6.setOnClickListener {
                it.visibility = View.GONE
                polskksgtgtt()
            }
            polafr.btnElem7.setOnClickListener {
                it.visibility = View.GONE
                polskksgtgtt()
            }
            polafr.btnElem8.setOnClickListener {
                it.visibility = View.GONE
                polskksgtgtt()
            }
            polafr.btnElem9.setOnClickListener {
                it.visibility = View.GONE
                polskksgtgtt()
            }
            polafr.btnElem10.setOnClickListener {
                it.visibility = View.GONE
                polskksgtgtt()
            }
            polafr.btnElem11.setOnClickListener {
                it.visibility = View.GONE
                polskksgtgtt()
            }
            polafr.btnElem12.setOnClickListener {
                it.visibility = View.GONE
                polskksgtgtt()
            }


        } catch (e: Exception) {
            ftgtgtt()
        }

        super.onViewCreated(view, savedInstanceState)
    }

    override fun onPause() {
        onDestroy()
        super.onPause()
    }

    private fun polskksgtgtt() {
        if (isisKfjrgtttt(polafr.btnElem1) && isisKfjrgtttt(polafr.btnElem2) && isisKfjrgtttt(
                polafr.btnElem3
            ) && isisKfjrgtttt(polafr.btnElem4) && isisKfjrgtttt(polafr.btnElem5) && isisKfjrgtttt(
                polafr.btnElem6
            ) && isisKfjrgtttt(polafr.btnElem7) && isisKfjrgtttt(polafr.btnElem8) && isisKfjrgtttt(
                polafr.btnElem9
            ) && isisKfjrgtttt(polafr.btnElem10) && isisKfjrgtttt(polafr.btnElem11) && isisKfjrgtttt(
                polafr.btnElem12
            )
        ) {
            findNavController().navigate(R.id.action_starttttttFragment_to_seeecondFragment)
        }
    }

    override fun onDestroy() {
        gtufgt = null
        super.onDestroy()
    }

    private fun ftgtgtt() {
        Snackbar.make(
            polafr.root,
            "There is some error, try again",
            Snackbar.LENGTH_LONG
        ).show()
        requireActivity().onBackPressed()
    }


    private fun slonnyftgtgt(imageView: ImageView) {
        lifecycleScope.launch {
            while (true) {
                var ismsms = gtgtfgt
                var gtjitji = plfrfgtt
                imageView.alpha = ismsms
                if (ismsms >= 1f) {
                    gtjitji = -0.05f
                }
                if (ismsms <= 0.1f) {
                    gtjitji = 0.05f
                }
                delay(30)
                ismsms += gtjitji
            }
        }
    }

    private fun isisKfjrgtttt(imageView: ImageView): Boolean {
        if (imageView.visibility == View.GONE) {
            return true
        }
        return false
    }



}