package com.example.appuber

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.appuber.ui.theme.AppUberTheme

class SegundaTela : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppUberTheme {
                val navController = rememberNavController()
                Opcoes(navController)
            }
        }
    }
}

@Composable
fun Opcoes(navController: NavHostController) {
    Scaffold(
        topBar = {},
        bottomBar = { BarraNavigation(navController) }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(Color.DarkGray)
        ) {
            TelaOpcoes()
        }
    }
}

@Composable
fun BarraNavigation(navController: NavHostController) {
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
fun TelaOpcoes() {
    Column {
        Spacer(modifier = Modifier.height(25.dp))
        Text(
            text = "Sugestões",
            modifier = Modifier.padding(start = 12.dp, top = 16.dp),
            style = MaterialTheme.typography.titleLarge.copy(color = Color.White)
        )
        Spacer(modifier = Modifier.height(15.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .height(140.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(Color(0xFF2A2A2A))
                .shadow(4.dp, RoundedCornerShape(16.dp)),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.imagem_blackfriday),
                contentDescription = "Promoção Black Friday",
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(16.dp)),
                contentScale = ContentScale.Crop
            )
        }

        Spacer(modifier = Modifier.height(15.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            SegundoCardDeSug("Viagem", Icons.Outlined.LocationOn)
            SegundoCardDeSug("Envios", Icons.Outlined.ShoppingCart)
        }

        Spacer(modifier = Modifier.height(10.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            CardDeSug("Viagem", Icons.Outlined.LocationOn)
            CardDeSug("Envios", Icons.Outlined.ShoppingCart)
            CardDeSug("Moto", Icons.Outlined.ArrowForward)
        }

        Spacer(modifier = Modifier.height(15.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(23.dp)
        ) {
            CardVerticalFino()
        }




    }
}

@Composable
fun CardDeSug(texto: String, icone: ImageVector) {
    Column(
        modifier = Modifier
            .width(120.dp)
            .height(110.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color.Black)
            .shadow(2.dp, RoundedCornerShape(16.dp)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(imageVector = icone, contentDescription = texto,
            modifier = Modifier.size(40.dp),
            tint = Color.White)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = texto, color = Color.White)
    }
}

@Composable
fun SegundoCardDeSug(texto: String, icone: ImageVector) {
    Column(
        modifier = Modifier
            .width(200.dp)
            .height(140.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color.Black)
            .shadow(2.dp, RoundedCornerShape(16.dp)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(imageVector = icone, contentDescription = texto, modifier = Modifier.size(40.dp), tint = Color.White)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = texto, color = Color.White)
    }
}

@Composable
fun CardVerticalFino() {
    Card(
        modifier = Modifier
            .width(80.dp)
            .height(180.dp)
            .clip(RoundedCornerShape(12.dp))

            .shadow(2.dp, RoundedCornerShape(12.dp)),
        colors = CardDefaults.cardColors(containerColor = Color.Black),
    ) {
        Image(
            painter = painterResource(id = R.drawable.img1),
            contentDescription = "Cards",
            modifier = Modifier.fillMaxSize().clip(RoundedCornerShape(12.dp)),
            contentScale = ContentScale.Crop
        )
    }

    Card(
        modifier = Modifier
            .width(80.dp)
            .height(180.dp)
            .clip(RoundedCornerShape(12.dp))

            .shadow(2.dp, RoundedCornerShape(12.dp)),
        colors = CardDefaults.cardColors(containerColor = Color.Black),
    ) {
        Image(
            painter = painterResource(id = R.drawable.img2),
            contentDescription = "Cards",
            modifier = Modifier.fillMaxSize().clip(RoundedCornerShape(12.dp)),
            contentScale = ContentScale.Crop
        )
    }

    Card(
        modifier = Modifier
            .width(80.dp)
            .height(180.dp)
            .clip(RoundedCornerShape(12.dp))

            .shadow(2.dp, RoundedCornerShape(12.dp)),
        colors = CardDefaults.cardColors(containerColor = Color.Black),
    ) {
        Image(
            painter = painterResource(id = R.drawable.img3),
            contentDescription = "Cards",
            modifier = Modifier.fillMaxSize().clip(RoundedCornerShape(12.dp)),
            contentScale = ContentScale.Crop
        )
    }

    Card(
        modifier = Modifier
            .width(80.dp)
            .height(180.dp)
            .clip(RoundedCornerShape(12.dp))

            .shadow(2.dp, RoundedCornerShape(12.dp)),
        colors = CardDefaults.cardColors(containerColor = Color.Black),
    ) {
        Image(
            painter = painterResource(id = R.drawable.img4),
            contentDescription = "Cards",
            modifier = Modifier.fillMaxSize().clip(RoundedCornerShape(12.dp)),
            contentScale = ContentScale.Crop
        )
    }
}




@Preview
@Composable
fun PreviewSegundaTela() {
    val navController = rememberNavController()
    AppUberTheme {
        Opcoes(navController)
    }
}
