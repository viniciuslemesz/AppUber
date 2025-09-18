package com.example.appuber

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.appuber.ui.theme.AppUberTheme

class QuartaTela : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppUberTheme {
                AppNavigation()
            }
        }
    }
}

@Composable
fun Atividade(navController: NavHostController) {

    Scaffold(
        topBar = {},
        bottomBar = { BarraNavegar(navController) }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            TelaAtividade()
        }
    }
}

@Composable
fun BarraNavegar(navController: NavHostController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .clip(RoundedCornerShape(16.dp)),
        colors = CardDefaults.cardColors(containerColor = Color.Gray)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {


            Button(
                onClick = { navController.navigate("home") },
                modifier = Modifier
                    .height(60.dp)
                    .width(86.dp)
                    .clip(RoundedCornerShape(16.dp)),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Gray)
            ) {

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Icon(Icons.Outlined.Home,
                        contentDescription = "Home",
                        modifier = Modifier.size(24.dp))
                    Spacer(modifier = Modifier.height(4.dp))
                    Text("Home")
                }
            }

            Spacer(modifier = Modifier.width(10.dp))
            Button(
                onClick = { navController.navigate("opcoes") },
                modifier = Modifier
                    .height(60.dp)
                    .width(93.dp)
                    .clip(RoundedCornerShape(16.dp)),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Gray)
            ) {

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Icon(Icons.Outlined.MoreVert ,
                        contentDescription = "Opcoes",
                        modifier = Modifier.size(24.dp))
                    Spacer(modifier = Modifier.height(4.dp))
                    Text("Opções")
                }
            }
            Spacer(modifier = Modifier.width(10.dp))
            Button(
                onClick = { navController.navigate("perfil") },
                modifier = Modifier
                    .height(60.dp)
                    .width(84.dp)
                    .clip(RoundedCornerShape(16.dp)),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Gray)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Icon(
                        Icons.Outlined.Build,
                        contentDescription = "Atividade",
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(text = "Atv.")
                }
            }

            Button(
                onClick = { navController.navigate("perfil") },
                modifier = Modifier
                    .height(60.dp)
                    .width(90.dp)
                    .clip(RoundedCornerShape(16.dp)),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Gray)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Icon(
                        Icons.Outlined.Person,
                        contentDescription = "Conta",
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(text = "Conta")
                }
            }

        }
    }
}

@Composable
fun TelaAtividade() {
    Column {
        Spacer(modifier = Modifier.height(29.dp))
        Text(text = "Atividade", modifier = Modifier.padding(start = 12.dp, top = 16.dp))
        Spacer(modifier = Modifier.height(15.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .height(120.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(Color.Gray),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.imagem_propaganda_uber),
                contentDescription = "Propaganda Uber",
                modifier = Modifier.fillMaxSize().clip(RoundedCornerShape(16.dp)),
                contentScale = ContentScale.Crop
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .height(120.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(Color.Gray),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.imagem_blackfriday),
                contentDescription = "Promoção Black Friday",
                modifier = Modifier.fillMaxSize().clip(RoundedCornerShape(16.dp)),
                contentScale = ContentScale.Crop
            )
        }
    }
}


@Preview
@Composable
fun PreviewQuartaTela() {
    AppUberTheme {
        val navController = rememberNavController()
        Atividade(navController)
    }
}
