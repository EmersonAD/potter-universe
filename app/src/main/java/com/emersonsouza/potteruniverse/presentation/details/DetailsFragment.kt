package com.emersonsouza.potteruniverse.presentation.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import coil.load
import com.emersonsouza.potteruniverse.databinding.FragmentDetailsBinding

class DetailsFragment : Fragment() {

    private lateinit var binding: FragmentDetailsBinding
    private val args: DetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fetchDetails()
    }

    private fun fetchDetails() {
        with(binding) {
            args.details.let { attributes ->
                ivBookDetailsBanner.load(attributes.cover)
                tvBookDetailsTitle.text = attributes.title
                tvBookDetailsAuthor.text = attributes.author
                tvBookDetailsOrderQuantity.text = attributes.order.toString()
                tvBookDetailsPagesQuantity.text = attributes.pages.toString()
                tvBookDetailsReleaseDateQuantity.text = attributes.releaseDate.replace("-", "/")
                tvBookDetailsOverview.text = attributes.summary
            }
        }
    }
}