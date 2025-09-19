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

class PrimeiraTela : ComponentActivity() {
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
fun Home(navController: NavHostController) {
    var pesquisas by remember { mutableStateOf(listOf("Último Destino Pesquisado:")) }

    Scaffold(
        topBar = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Gray)
                    .padding(top = 34.dp, start = 16.dp, end = 16.dp)
            ) {
                Text(
                    text = "Uber",
                    color = Color.Black,
                    style = MaterialTheme.typography.headlineMedium,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                BarraPesquisa(aoPesquisar = { novaMensagem ->
                    pesquisas = pesquisas + novaMensagem
                })
            }
        },
        bottomBar = { BarraNav(navController) }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(Color.DarkGray)
        ) {
            Spacer(modifier = Modifier.height(20.dp))
            LazyColumn {
                items(pesquisas) { item ->
                    Pesquisar(item)
                    Spacer(modifier = Modifier.height(5.dp))
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            TelaPrincipal()
        }
    }
}

@Composable
fun BarraNav(navController: NavHostController) {
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
                    Icon(
                        Icons.Outlined.Home,
                        contentDescription = "Home",
                        modifier = Modifier.size(24.dp)
                    )
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
                    Icon(
                        Icons.Outlined.MoreVert,
                        contentDescription = "Opcoes",
                        modifier = Modifier.size(24.dp)
                    )
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

            Spacer(modifier = Modifier.width(10.dp))

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
fun BarraPesquisa(aoPesquisar: (String) -> Unit) {
    var textoInput by remember { mutableStateOf("") }
    Spacer(modifier = Modifier.height(25.dp))
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Gray)
            .clip(RoundedCornerShape(16.dp))
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextField(
            value = textoInput,
            onValueChange = { textoInput = it },
            modifier = Modifier.weight(1f),
            placeholder = { Text("Pesquisar Destino...") }
        )
        Spacer(modifier = Modifier.width(8.dp))
        Button(
            onClick = {
                if (textoInput.isNotBlank()) {
                    aoPesquisar(textoInput)
                    textoInput = ""
                }
            }
        ) {
            Icon(
                Icons.Outlined.Search,
                contentDescription = "Icone Pesquisa",
                modifier = Modifier.size(30.dp)
            )
        }
    }
    Spacer(modifier = Modifier.height(20.dp))
}

@Composable
fun Pesquisar(texto: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 4.dp)
            .height(50.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color.Gray),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            Icons.Outlined.Refresh,
            contentDescription = "Icone pesquisa",
            modifier = Modifier.size(25.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = texto)
    }
}

@Composable
fun TelaPrincipal() {
    Column {
        Spacer(modifier = Modifier.height(29.dp))
        Text(
            text = "Sugestões",
            modifier = Modifier.padding(start = 12.dp, top = 16.dp)
        )
        Spacer(modifier = Modifier.height(15.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            CardDeSugestao("Viagem", Icons.Outlined.LocationOn)
            CardDeSugestao("Envios", Icons.Outlined.ShoppingCart)
            CardDeSugestao("Moto", Icons.Outlined.ArrowForward)
        }

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
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(16.dp)),
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
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(16.dp)),
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Composable
fun CardDeSugestao(texto: String, icone: ImageVector) {
    Column(
        modifier = Modifier
            .width(110.dp)
            .height(100.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color.Gray),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            imageVector = icone,
            contentDescription = texto,
            modifier = Modifier.size(33.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = texto)
    }
}

@Preview
@Composable
fun PreviewPrimeiraTela() {
    AppUberTheme {
        val navController = rememberNavController()
        Home(navController)
    }
}
