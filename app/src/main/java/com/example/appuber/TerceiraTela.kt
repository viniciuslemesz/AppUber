package com.example.appuber

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.appuber.ui.theme.AppUberTheme

class TerceiraTela : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppUberTheme {
                val navController = rememberNavController()
                Perfil(navController)
            }
        }
    }
}

@Composable
fun Perfil(navController: NavHostController) {
    Scaffold(
        topBar = {},
        bottomBar = { BarraNavigationPerfil(navController) }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(Color(0xFF1E1E1E))
        ) {
            TelaPerfil()
        }
    }
}

@Composable
fun BarraNavigationPerfil(navController: NavHostController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .clip(RoundedCornerShape(16.dp)),
        colors = CardDefaults.cardColors(containerColor = Color.Gray)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
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
                    Icon(Icons.Outlined.Home, contentDescription = "Home", modifier = Modifier.size(24.dp))
                    Text("Home", style = MaterialTheme.typography.labelSmall, color = Color.White)
                }
            }

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
                    Icon(Icons.Outlined.MoreVert, contentDescription = "Opcoes", modifier = Modifier.size(24.dp))
                    Text("Opções", style = MaterialTheme.typography.labelSmall, color = Color.White)
                }
            }

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
                    Icon(Icons.Outlined.Build, contentDescription = "Atividade", modifier = Modifier.size(24.dp))
                    Text("Atv.", style = MaterialTheme.typography.labelSmall, color = Color.White)
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
                    Icon(Icons.Outlined.Person, contentDescription = "Conta",
                        modifier = Modifier.size(24.dp))
                    Text("Conta", style = MaterialTheme.typography.labelSmall, color = Color.White)
                }
            }
        }
    }
}

@Composable
fun TelaPerfil() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        CardPerfil("VINICIUS LEMES")

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            CardsPequenosTela("Ajuda", Icons.Outlined.AddCircle)
            CardsPequenosTela("Carteira", Icons.Outlined.Email)
            CardsPequenosTela("Mensagem", Icons.Outlined.Email)
        }

        CardsGrandeTela("Pacotes Uber", Icons.Outlined.DateRange)
        CardsGrandeTela("Experimentar", Icons.Outlined.Done)
        CardsMedioTela("Checagem de Segurança", Icons.Outlined.Lock)
        CardsMedioTela("Redução Estimada de CO2", Icons.Outlined.ThumbUp)
    }
}

@Composable
fun CardPerfil(texto: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF2C2C2C)),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(texto, style = MaterialTheme.typography.titleLarge, color = Color.White)
                Icon(Icons.Outlined.Person,
                    contentDescription = "Conta",
                    modifier = Modifier.size(80.dp))
            }

            Row {
                Box(
                    modifier = Modifier
                        .background(Color(0xFF3A3A3A), RoundedCornerShape(12.dp))
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                ) {
                    Text("5.00", color = Color.White)
                }
                Spacer(modifier = Modifier.width(8.dp))
                Box(
                    modifier = Modifier
                        .background(Color(0xFF3A3A3A), RoundedCornerShape(12.dp))
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                ) {
                    Text("Não verificado", color = Color.White)
                }
            }
        }

        Spacer(modifier = Modifier.height(10.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(text = "Teste", color = Color.White)
        }
    }
}

@Composable
fun CardsPequenosTela(texto: String, icone: ImageVector) {
    Card(
        modifier = Modifier
            .width(110.dp)
            .height(110.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF3A3A3A)),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                imageVector = icone,
                contentDescription = texto,
                modifier = Modifier.size(32.dp),
                tint = Color(0xFFFFC107)
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(text = texto, color = Color.White)
        }
    }
}

@Composable
fun CardsGrandeTela(texto: String, icone: ImageVector) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF3A3A3A)),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = texto, color = Color.White)
            Icon(
                imageVector = icone,
                contentDescription = texto,
                modifier = Modifier.size(56.dp),
                tint = Color(0xFFFFC107)
            )
        }
    }
}

@Composable
fun CardsMedioTela(texto: String, icone: ImageVector) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF3A3A3A)),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = texto, color = Color.White)
            Icon(
                imageVector = icone,
                contentDescription = texto,
                modifier = Modifier.size(42.dp),
                tint = Color(0xFFFFC107)
            )
        }
    }
}

@Composable
//@Preview
fun PreviewTerceiraTela() {
    val navController = rememberNavController()
    AppUberTheme {
        Perfil(navController)
    }
}
