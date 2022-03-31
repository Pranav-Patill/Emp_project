package com.example.testemp.ui.playlist

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
import com.example.testemp.databinding.FragmentPlaylistBinding

class PlaylistFragment : Fragment() {

  private lateinit var playlistViewModel: PlaylistViewModel
private var _binding: FragmentPlaylistBinding? = null
  // This property is only valid between onCreateView and
  // onDestroyView.
  private val binding get() = _binding!!

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    playlistViewModel =
            ViewModelProvider(this).get(PlaylistViewModel::class.java)

    _binding = FragmentPlaylistBinding.inflate(inflater, container, false)
    val root: View = binding.root

    val textView: TextView = binding.textGallery
    playlistViewModel.text.observe(viewLifecycleOwner, Observer {
      textView.text = it
    })
    binding.topnavbar.setItemSelected(R.id.playlist)
    setUpTab()
    return root
  }

  private fun setUpTab() {
    binding.topnavbar.setOnItemSelectedListener {
      when (it) {
        R.id.home -> findNavController().navigate(R.id.action_nav_playlist_to_nav_home)
        R.id.fav -> findNavController().navigate(R.id.action_nav_playlist_to_nav_favorites)

      }
    }
  }

override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}