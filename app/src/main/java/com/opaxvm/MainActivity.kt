package com.opaxvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.foundation.layout.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {

                var name by remember { mutableStateOf("") }
                val vms = remember { mutableStateListOf<String>() }

                Column {

                    Text("OpaxVM")

                    OutlinedTextField(
                        value = name,
                        onValueChange = { name = it }
                    )

                    Button(onClick = {
                        if (name.isNotBlank()) {
                            vms.add(name)
                            name = ""
                        }
                    }) {
                        Text("Create VM")
                    }

                    vms.forEach {
                        Text(it)
                    }
                }
            }
        }
    }
}
