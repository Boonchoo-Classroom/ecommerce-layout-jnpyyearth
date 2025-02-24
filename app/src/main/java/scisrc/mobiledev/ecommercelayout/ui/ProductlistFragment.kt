package scisrc.mobiledev.ecommercelayout.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import scisrc.mobiledev.ecommercelayout.R
import scisrc.mobiledev.ecommercelayout.databinding.FragmentProductListBinding

class ProductlistFragment : Fragment() {

    private var _binding: FragmentProductListBinding? = null
    private val binding get() = _binding!!

    private lateinit var category: String
    private lateinit var products: List<ProductModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        category = arguments?.getString("category") ?: "Unknown"

        // Mockup รายการสินค้าในแต่ละหมวดหมู่
        products = when (category) {
            "อุปกรณ์เครื่องเขียน" -> listOf(
                ProductModel("ปากกา", "50฿",R.drawable.ic_pen),
                ProductModel("ดินสอ", "12฿", R.drawable.ic_pencil),
                ProductModel("แฟ้มเอกสาร", "25฿", R.drawable.ic_file),
            )
            "อุปกรณ์กีฬา" -> listOf(
                ProductModel("ไม้แบดมินตัน", "500฿",R.drawable.ic_badminton),
                ProductModel("ลูกบาสเกตบอล", "250฿",R.drawable.ic_basketball),
                ProductModel("ดัมเบล 5 kg", "200฿",R.drawable.ic_dumbell)
            )
            "Gadget" -> listOf(
                ProductModel("หูฟังบลูทูธ", "7500฿",R.drawable.ic_earphone),
                ProductModel("Smartwatch", "3000฿",R.drawable.ic_watch)
            )
            "เสื้อผ้า" -> listOf(
                ProductModel("เสื้อยืด", "200฿", R.drawable.ic_cloth),
                ProductModel("กางเกงยีนส์", "800฿", R.drawable.ic_jean),
                ProductModel("สูทดำเข้ม", "2000฿", R.drawable.ic_suit),
                ProductModel("เสื้อเชิ้ตขาว", "650฿", R.drawable.ic_shirt),
            )
            "อุปกรณ์ไอที" -> listOf(
                ProductModel("เมาส์เกมมิ่ง", "1200฿",R.drawable.ic_mouse ),
                ProductModel("คีย์บอร์ดCustom", "15,000฿",R.drawable.ic_keyboard),
                ProductModel("ที่วางโน้ตบุ๊คพับได้", "780฿",R.drawable.ic_notebook)
            )
            else -> emptyList()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProductListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.categoryTitle.text = category
        binding.recyclerViewProducts.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewProducts.adapter = ProductAdapter(products)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}