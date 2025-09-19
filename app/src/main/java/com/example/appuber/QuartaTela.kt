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
                onClick = { navController.navigate("atividade") },
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
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.DarkGray)
            .padding(12.dp)
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Atividade",
            color = Color.White,
            style = MaterialTheme.typography.titleLarge
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Agendadas",
            color = Color.White,
            style = MaterialTheme.typography.bodyMedium
        )
        Spacer(modifier = Modifier.height(8.dp))
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp),
            colors = CardDefaults.cardColors(containerColor = Color.Gray),
            shape = RoundedCornerShape(16.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.imagem_propaganda_uber),
                contentDescription = "Propaganda Uber",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }
        Spacer(modifier = Modifier.height(18.dp))
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(210.dp),
            colors = CardDefaults.cardColors(containerColor = Color.Gray),
            shape = RoundedCornerShape(16.dp)
        ) {
            CardImagem()
        }
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = "Anteriores",
            color = Color.White,
            style = MaterialTheme.typography.bodyMedium
        )
        Spacer(modifier = Modifier.height(8.dp))
        CardAnterior(texto = "R. TalTal, 270\n 12 de jul. - 17:28\n R$37,83")
        Spacer(modifier = Modifier.height(8.dp))
        CardAnterior(texto = "R. Blabla, 270\n 5 de set. - 12:38\n R$46,33")
    }
}

@Composable
fun CardAnterior(texto: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp),
        colors = CardDefaults.cardColors(containerColor = Color.Gray),
        shape = RoundedCornerShape(16.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Text(text = texto, color = Color.White)
        }
    }
    Spacer(modifier = Modifier.height(16.dp))
}

@Composable
fun CardImagem() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(240.dp),
        colors = CardDefaults.cardColors(containerColor = Color.Gray),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.imagemcard),
                contentDescription = "Imagem Mapa Uber",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(160.dp)
                    .clip(RoundedCornerShape(16.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "R. TalTal, 270, 12 de jul. - 17:28 - R$37,83",
                color = Color.White,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(start = 8.dp)
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
