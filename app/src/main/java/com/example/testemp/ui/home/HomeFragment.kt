package com.example.testemp.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.testemp.R
import com.example.testemp.databinding.FragmentHomeBinding
import android.provider.MediaStore
import androidx.core.app.ActivityCompat.startActivityForResult
import androidx.core.app.ActivityCompat.startActivityForResult

class HomeFragment : Fragment() {

  private lateinit var homeViewModel: HomeViewModel
  private var _binding: FragmentHomeBinding? = null
  // This property is only valid between onCreateView and
  // onDestroyView.
  private val binding get() = _binding!!

        override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

    _binding = FragmentHomeBinding.inflate(inflater, container, false)
    val root: View = binding.root
      binding.topnavbar.setItemSelected(R.id.home)
      setUpTab()
            val button: Unit = binding.btCaptureMood.setOnClickListener {
                val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                startActivity(intent)           }
    return root

  }

    private fun setUpTab(){
        binding.topnavbar.setOnItemSelectedListener {
            when (it) {
                R.id.playlist -> findNavController().navigate(R.id.action_nav_home_to_nav_playlist)
                R.id.fav -> findNavController().navigate(R.id.action_nav_home_to_nav_favorites)

            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}