package com.tec.frontend

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tec.frontend.ui.theme.FrontendTheme

class Registro : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FrontendTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Registros()
                }
            }
        }
    }
}

@Composable
fun Registros() {
    var text1 by remember { mutableStateOf("") }
    var text2 by remember { mutableStateOf("") }
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFF4169CF),
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .size(600.dp)
                    .background(Color.White),
                contentAlignment = Alignment.TopCenter
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                    )
                {
                    Text(
                        text = "Registro",
                        style = TextStyle(
                            fontSize = 65.sp,
                            fontWeight = FontWeight.Bold
                        ),
                        modifier = Modifier
                            .padding(16.dp)
                    )
                    BasicTextField(
                        modifier = Modifier
                            .width(550.dp)
                            .padding(top = 45.dp)
                            .border(2.dp, Color.Gray, MaterialTheme.shapes.medium),
                        value = text1,
                        onValueChange = {
                            text1 = it
                        },
                        textStyle = TextStyle(
                            color = Color.Black,
                            fontSize = 35.sp
                        ),
                        decorationBox = { innerTextField ->
                            if (text1.isEmpty()) {
                                Text(
                                    text = "Introduce tu nombre de usuario",
                                    color = Color.Gray,
                                    style = TextStyle(
                                        fontSize = 35.sp
                                    ),
                                    modifier = Modifier
                                        .padding(16.dp)
                                )
                            }
                            innerTextField()
                        }
                    )
                    BasicTextField(
                        modifier = Modifier
                            .width(550.dp)
                            .padding(top = 35.dp)
                            .border(2.dp, Color.Gray, MaterialTheme.shapes.medium),
                        value = text2,
                        onValueChange = {
                            text2 = it
                        },
                        textStyle = TextStyle(
                            color = Color.Black,
                            fontSize = 35.sp
                        ),
                        decorationBox = { innerTextField ->
                            if (text2.isEmpty()) {
                                Text(
                                    text = "Introduce tu contraseña",
                                    color = Color.Gray,
                                    style = TextStyle(
                                        fontSize = 35.sp
                                    ),
                                    modifier = Modifier
                                        .padding(16.dp)
                                )
                            }
                            innerTextField()
                        }
                    )
                    Spacer(modifier = Modifier.padding(top = 25.dp))
                    TwoOptionsCheckBox()

                    val context = LocalContext.current
                    Button(
                        modifier = Modifier
                            .padding(top = 15.dp),
                        shape = RoundedCornerShape(30.dp),
                        colors = ButtonDefaults.buttonColors(Color(0xFFEE6B11)),
                        onClick = {
                            context.startActivity(Intent(context, InfoAlumno::class.java))
                        }
                    )
                    {
                        Text(text = "Registrar",
                            style = TextStyle(
                                fontSize = 35.sp
                            )
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun TwoOptionsCheckBox() {
    var option1CheckedState by remember { mutableStateOf(false) }
    var option2CheckedState by remember { mutableStateOf(false) }

    Column {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Titulo     ", style = TextStyle(fontSize = 35.sp), modifier = Modifier.padding(25.dp))
            Text(text = "Admin", style = TextStyle(fontSize = 35.sp),  modifier = Modifier.padding(25.dp))
            Checkbox(
                checked = option1CheckedState,
                onCheckedChange = { option1CheckedState = it },
                modifier = Modifier
                    .weight(1f)
                    .padding(25.dp)
            )
            Text(text = "Padre", style = TextStyle(fontSize = 35.sp), modifier = Modifier.padding(25.dp))
            Checkbox(
                checked = option2CheckedState,
                onCheckedChange = { option2CheckedState = it },
                modifier = Modifier
                    .weight(1f)
                    .padding(25.dp)
            )
        }

        // Acciones basadas en la selección de opciones (puedes agregar lógica aquí)
        if (option1CheckedState) {
            // Opción 1 seleccionada
        }

        if (option2CheckedState) {
            // Opción 2 seleccionada
        }
    }
}