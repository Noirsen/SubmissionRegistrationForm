// Regenerated to fix preview errors
package com.example.submissionsaplikasi

import android.content.res.Configuration
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.submissionsaplikasi.ui.theme.SubmissionsAplikasiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SubmissionsAplikasiTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    RegistrationScreen()
                }
            }
        }
    }
}

@Composable
fun RegistrationScreen() {
    var firstName by rememberSaveable { mutableStateOf("") }
    var lastName by rememberSaveable { mutableStateOf("") }
    var username by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var gender by rememberSaveable { mutableStateOf("") }
    var agreed by rememberSaveable { mutableStateOf(false) }
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(Color(0xFF81D4FA), Color(0xFFB39DDB))
                )
            )
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Create Account", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))
        Row(modifier = Modifier.fillMaxWidth()) {
            OutlinedTextField(
                value = firstName,
                onValueChange = { firstName = it },
                label = { Text("First Name") },
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.width(8.dp))
            OutlinedTextField(
                value = lastName,
                onValueChange = { lastName = it },
                label = { Text("Last Name") },
                modifier = Modifier.weight(1f)
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Username") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text("Gender")
        Row {
            RadioButton(
                selected = gender == "Male",
                onClick = { gender = "Male" }
            )
            Text("Male", modifier = Modifier.align(Alignment.CenterVertically))
            RadioButton(
                selected = gender == "Female",
                onClick = { gender = "Female" }
            )
            Text("Female", modifier = Modifier.align(Alignment.CenterVertically))
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = agreed,
                onCheckedChange = { agreed = it }
            )
            Text("I agree to the Terms and Conditions.")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row {
            Button(onClick = {
                firstName = ""
                lastName = ""
                username = ""
                password = ""
                gender = ""
                agreed = false
            }) {
                Text("Clear")
            }
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = {
                val message = "Name: $firstName $lastName\nUsername: $username\nGender: $gender"
                Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
            }) {
                Text("Submit")
            }
        }
    }
}

@Preview(showBackground = true, name = "Light Mode")
@Composable
fun RegistrationScreenPreview() {
    SubmissionsAplikasiTheme {
        RegistrationScreen()
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES, name = "Dark Mode")
@Composable
fun RegistrationScreenPreviewDark() {
    SubmissionsAplikasiTheme(darkTheme = true) {
        Surface {
            RegistrationScreen()
        }
    }
}
