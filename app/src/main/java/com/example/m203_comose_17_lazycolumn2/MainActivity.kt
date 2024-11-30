package com.example.m203_comose_17_lazycolumn2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import com.example.m203_comose_17_lazycolumn2.ui.theme.M203_Comose_17_LazyColumn2Theme

data class PC(val id: Int, val nom: String, val prix: Double, val image: String)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            M203_Comose_17_LazyColumn2Theme {
                PCListScreen()
            }
        }
    }
}

@Composable
fun PCListScreen() {
    // Liste de PC avec noms, prix et URL d'image
    val pcList = listOf(
        PC(1, "Dell Inspiron", 5990.99, "https://m.media-amazon.com/images/I/61zRDADh+YS._AC_SL1500_.jpg"),
        PC(2, "HP Pavilion", 6990.99, "https://ssl-product-images.www8-hp.com/digmedialib/prodimg/lowres/c08249162.png"),
        PC(3, "MacBook Pro", 12990.99, "https://cdsassets.apple.com/live/SZLF0YNV/images/sp/111972_SP748-mbp13touch-gray.jpeg"),
        PC(4, "Lenovo ThinkPad", 799.99, "https://p1-ofp.static.pub//fes/cms/2024/03/27/gltpzpugr1fm6p15xm2ux29kqkbsxo004184.png"),
        PC(5, "Asus ROG", 1499.99, "https://via.placeholder.com/150"),
        PC(6, "Acer Predator", 1199.99, "https://via.placeholder.com/150"),
        PC(7, "MSI Stealth", 1399.99, "https://via.placeholder.com/150"),
        PC(8, "Surface Laptop", 999.99, "https://via.placeholder.com/150"),
        PC(9, "Alienware Aurora", 1799.99, "https://via.placeholder.com/150"),
        PC(10, "Samsung Galaxy Book", 1099.99, "https://via.placeholder.com/150")
    )

    Column(modifier = Modifier.fillMaxSize()) {
        // Titre
        Text(
            text = "Liste de PC",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(16.dp)
        )

        // LazyColumn pour afficher les éléments
        LazyColumn(
            modifier = Modifier.height(250.dp)
        ) {
            items(pcList) { pc ->
                PCItem(pc)
            }
        }
    }
}

@Composable
fun PCItem(pc: PC) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Image du PC
        Image(
            painter = rememberAsyncImagePainter(model = pc.image),
            contentDescription = "Image de ${pc.nom}",
            modifier = Modifier
                .size(64.dp)
                .padding(end = 16.dp)
        )

        // Détails du PC
        Column {
            Text(
                text = pc.nom,
                style = MaterialTheme.typography.bodyLarge
            )
            Text(
                text = "${pc.prix} €",
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}