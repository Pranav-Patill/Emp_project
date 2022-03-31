package com.example.testemp.ui.favorites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.testemp.R
import com.example.testemp.databinding.FragmentFavoritesBinding

class FavoritesFragment : Fragment() {

  private lateinit var favoritesViewModel: FavoritesViewModel
private var _binding: FragmentFavoritesBinding? = null
  // This property is only valid between onCreateView and
  // onDestroyView.
  private val binding get() = _binding!!

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    favoritesViewModel =
            ViewModelProvider(this).get(FavoritesViewModel::class.java)

    _binding = FragmentFavoritesBinding.inflate(inflater, container, false)
    val root: View = binding.root

    val textView: TextView = binding.textSlideshow
    favoritesViewModel.text.observe(viewLifecycleOwner, Observer {
      textView.text = it
    })
    binding.topnavbar.setItemSelected(R.id.fav)
    setUpTab()
    return root
  }

  private fun setUpTab() {
    binding.topnavbar.setOnItemSelectedListener {
      when (it) {
        R.id.playlist -> findNavController().navigate(R.id.action_nav_favorites_to_nav_playlist)
        R.id.home -> findNavController().navigate(R.id.action_nav_favorites_to_nav_home)
      }
    }
  }

override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}