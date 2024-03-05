package gaur.himanshu.performance

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import gaur.himanshu.performance.ui.theme.PerformanceTheme
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PerformanceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    ContactDetails(
                        contact = persistentListOf(
                            Contact(
                                name = "Himanshu",
                                number = "1234567890"
                            )
                        )
                    )
                }
            }
        }
    }
}


@Immutable
data class Fake(var a: String, val b: String)

@Stable
class Contact(name: String, val number: String) {
    val name: MutableState<String> = mutableStateOf("")

    init {
        this.name.value = name
    }
}

@Composable
fun ContactDetails(contact: ImmutableList<Contact>) {

    val selected = remember {
        mutableStateOf(false)
    }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ContactRow(contact[0])
        Spacer(modifier = Modifier.height(20.dp))
        Switch(checked = selected.value, onCheckedChange = {
            contact[0].name.value = "Gaur"
            selected.value = !selected.value
        })
    }
}

@Composable
fun ContactRow(contact: Contact) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = contact.name.value)
        Spacer(modifier = Modifier.width(20.dp))
        Text(text = contact.number)
    }
}




























