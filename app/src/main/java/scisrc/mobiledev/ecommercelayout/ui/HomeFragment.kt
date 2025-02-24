package scisrc.mobiledev.ecommercelayout


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import scisrc.mobiledev.ecommercelayout.R
import scisrc.mobiledev.ecommercelayout.databinding.FragmentHomeBinding
import scisrc.mobiledev.ecommercelayout.ui.ProductAdapter
import scisrc.mobiledev.ecommercelayout.ui.ProductModel

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val recommendedProducts = listOf(
        ProductModel("หูฟังบลูทูธ", "7500฿",R.drawable.ic_earphone),
        ProductModel("กางเกงยีนส์", "800฿", R.drawable.ic_jean),
    )
    private val promotions = listOf(
        ProductModel("ลด 50% สำหรับสินค้ากลุ่ม Gadget", "เฉพาะวันนี้!", R.drawable.ic_home),
        ProductModel("ซื้อ 1 แถม 1 เสื้อผ้า", "จำนวนจำกัด!", R.drawable.ic_home)
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // ตั้งค่าแบนเนอร์
        binding.bannerImage.setImageResource(R.drawable.banner)

        // ตั้งค่า RecyclerView สินค้าแนะนำ
        binding.recyclerViewRecommended.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerViewRecommended.adapter = ProductAdapter(recommendedProducts)

        // ตั้งค่า RecyclerView โปรโมชั่น
        binding.recyclerViewPromotions.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerViewPromotions.adapter = ProductAdapter(promotions)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}