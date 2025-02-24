package scisrc.mobiledev.ecommercelayout.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import scisrc.mobiledev.ecommercelayout.R
import scisrc.mobiledev.ecommercelayout.databinding.FragmentFavoriteBinding

class FavoriteFragment : Fragment() {

    private var _binding: FragmentFavoriteBinding? = null
    private val binding get() = _binding!!

    private val favoriteProducts = listOf(
        ProductModel("Smartwatch", "3000฿",R.drawable.ic_watch),
        ProductModel("กางเกงยีนส์", "800฿", R.drawable.ic_jean),
        ProductModel("ดัมเบล 5 kg", "200฿",R.drawable.ic_dumbell),
        ProductModel("ไม้แบดมินตัน", "500฿",R.drawable.ic_badminton),
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerViewFavorites.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewFavorites.adapter = ProductAdapter(favoriteProducts)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}