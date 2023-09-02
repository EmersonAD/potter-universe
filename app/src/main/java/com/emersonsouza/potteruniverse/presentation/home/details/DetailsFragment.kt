package com.emersonsouza.potteruniverse.presentation.home.details

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.AttrRes
import androidx.annotation.ColorInt
import androidx.core.content.res.use
import androidx.core.view.ViewCompat
import androidx.core.view.doOnPreDraw
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import coil.load
import com.emersonsouza.potteruniverse.R
import com.emersonsouza.potteruniverse.databinding.FragmentDetailsBinding
import com.emersonsouza.potteruniverse.presentation.home.HomeFragmentDirections
import com.emersonsouza.potteruniverse.util.extension.themeColor
import com.google.android.material.R.*
import com.google.android.material.transition.MaterialContainerTransform
import kotlin.LazyThreadSafetyMode.NONE

class DetailsFragment : Fragment() {

    private lateinit var binding: FragmentDetailsBinding
    private val args: com.emersonsouza.potteruniverse.presentation.details.DetailsFragmentArgs by navArgs()
    private val title: String by lazy(NONE) { args.details.title }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sharedElementEnterTransition = MaterialContainerTransform().apply {
            drawingViewId = R.id.nav_host_fragment
            duration = 300L
            scrimColor = Color.TRANSPARENT
            setAllContainerColors(requireContext().themeColor(attr.colorSurface))
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        postponeEnterTransition()
        view.doOnPreDraw { startPostponedEnterTransition() }

        setToolbar()
        setSharedElement()
        fetchDetails()
    }

    private fun setToolbar() = with(binding.bookToolbar) {
        toolbar.setNavigationIcon(R.drawable.ic_back_black)
        toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun setSharedElement() {
        ViewCompat.setTransitionName(binding.cvDetails, "card_book_name_${title}")
    }

    private fun fetchDetails() {
        with(binding) {
            args.details.let { attributes ->
                ivBookDetailsBanner.load(attributes.cover)
                tvBookDetailsTitle.text = attributes.title
                tvBookDetailsAuthor.text = attributes.author
                tvDedicationText.text = attributes.dedication
                tvBookDetailsOrderQuantity.text = attributes.order.toString()
                tvBookDetailsPagesQuantity.text = attributes.pages.toString()
                tvBookDetailsReleaseDateQuantity.text = attributes.releaseDate.replace("-", "/")
                tvBookDetailsOverview.text = attributes.summary
                tvMoreInformation.setOnClickListener {
                Intent(Intent.ACTION_VIEW, Uri.parse(attributes.wiki)).also { startActivity(it) }
                }
            }
        }
    }

}