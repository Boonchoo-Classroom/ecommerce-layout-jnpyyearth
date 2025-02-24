package scisrc.mobiledev.ecommercelayout.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import scisrc.mobiledev.ecommercelayout.R
import scisrc.mobiledev.ecommercelayout.databinding.FragmentBasketBinding

class basketFragment : Fragment() {

    private var _binding: FragmentBasketBinding? = null
    private val binding get() = _binding!!

    // Mockup สินค้าในตะกร้า
    private val basketProducts = listOf(
        ProductModel("สูทดำเข้ม", "2000฿", R.drawable.ic_suit),
        ProductModel("ดินสอ", "12฿", R.drawable.ic_pencil),
        ProductModel("หูฟังบลูทูธ", "7500฿",R.drawable.ic_earphone),
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBasketBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // ตั้งค่า RecyclerView
        binding.recyclerViewCart.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewCart.adapter = ProductAdapter(basketProducts)

        // คำนวณราคารวม
        val totalPrice = basketProducts.sumOf { it.price.replace("฿", "").toInt() }
        binding.cartTotalPrice.text = "รวม: ${totalPrice}฿"

        // ปุ่มชำระเงิน
        binding.btnCheckout.setOnClickListener {
            // TODO: ทำให้ไปหน้า Checkout (ตอนนี้ยังไม่ต้องมีฟังก์ชันจริง)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}