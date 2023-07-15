package com.ankur.shoppinglist.ui.shoppingList

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.ankur.shoppinglist.data.db.entities.ShoppingItem
import com.ankur.shoppinglist.databinding.DialogAddShopppingItemBinding


class AddShoppingDialogItem(context: Context, private var AddShoppingListener:AddShoppingDialogInterface):AppCompatDialog(context) {
    private lateinit var binding: DialogAddShopppingItemBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DialogAddShopppingItemBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            val name = binding.Name.text.toString()
            val amount = binding.Amount.text.toString()

            if (name.isEmpty() || amount.isEmpty())
            {

                Toast.makeText(context, "Please Fill Details", Toast.LENGTH_SHORT).show()

                return@setOnClickListener
            }
            val item = ShoppingItem(name,amount.toInt())
                AddShoppingListener.onAddButtonClick(item)
                dismiss()
        }

        binding.button2.setOnClickListener {
            cancel()
        }



    }
}