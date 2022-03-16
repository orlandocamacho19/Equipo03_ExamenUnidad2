package orlando.camacho.taquerialosportales

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*

class MenuActivity : AppCompatActivity() {
    var categories = ArrayList<Category>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        addCategories()

        var listView: ListView = findViewById(R.id.categories) as ListView
        var adapter: CategoriesAdapter = CategoriesAdapter(this, categories)
        listView.adapter = adapter

        val button: ImageButton = findViewById(R.id.backButton) as ImageButton

        button.setOnClickListener{
            var intent: Intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    fun addCategories(){
        categories.add(Category("Tacos", "Los mejores tacos de la comida mexicana.",R.drawable.tacos, 2))
        categories.add(Category("Antojitos", "Todo lo que puedas imaginar para ese 'antojito'.", R.drawable.antojitos, 6))
        categories.add(Category("Especialidades", "Lo mejor, nuestras especialidades para ti.", R.drawable.especialidades,6))
        categories.add(Category("Caldos", "Quién tras el caldo no bebe, no sabe lo que se pierde.", R.drawable.caldos, 2))
        categories.add(Category("Combinaciones", "Combinaciones de nuestror mejores platillos.", R.drawable.combos, 6))
        categories.add(Category("Tortas", "Un auténtico clasico mexicano, las tortas.", R.drawable.tortas, 5))
        categories.add(Category("Sopas", "Del plato a la boca, no se enfría nuestra sopa.", R.drawable.sopas, 6))
        categories.add(Category("Guarniciones", "Acompaña tus comidas a la mexicana.", R.drawable.guarniciones, 5))
        categories.add(Category("Bebidas", "Para quitarte esa sed.", R.drawable.bebidas, 15))
    }

    private class CategoriesAdapter: BaseAdapter {
        var categories = ArrayList<Category>()
        var context: Context?=null

        constructor(context: Context, categories: ArrayList<Category>){
            this.categories = categories
            this.context = context
        }

        override fun getCount(): Int {
            return categories.size
        }

        override fun getItem(p0: Int): Any {
            return categories[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            var cat = categories[p0]
            var inflator = LayoutInflater.from(context)
            var view = inflator.inflate(R.layout.category_view, null)

            var image = view.findViewById(R.id.categoryImage) as ImageView
            var name = view.findViewById(R.id.categoryName) as TextView
            var desc = view.findViewById(R.id.categoryDesc) as TextView
            var quant = view.findViewById(R.id.dishesQuantity) as TextView

            image.setImageResource(cat.image)
            name.setText(cat.name)
            desc.setText(cat.desc)
            quant.setText(cat.quant.toString())
            return view
        }
    }

}