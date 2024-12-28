package com.devzone.ui.tutorials

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.compose.ui.window.SecureFlagPolicy
import com.devzone.ui.R
import com.devzone.ui.tutorials.others.StyleableTextView
import com.devzone.ui.tutorials.others.HeaderTextView
import com.devzone.ui.tutorials.others.BodyTextView

@Preview(showBackground = true)
@Composable
fun Tutorial2_12Screen() {
    TutorialContent()
}

@Composable
private fun TutorialContent() {
    // To show dialog we set one of the flags to true and set it back to false
    // in onDismissRequest function of dialog.
    var showAlertDialog by remember { mutableStateOf(false) }
    var showAlertDialogWithStyle by remember { mutableStateOf(false) }
    var showDialog by remember { mutableStateOf(false) }
    var showCustomDialog by remember { mutableStateOf(false) }
    var showCustomDialogWithResult by remember { mutableStateOf(false) }

    val context = LocalContext.current
    val isInPreview = false

    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        item {

            HeaderTextView(text = "AlertDialog")
            StyleableTextView(
                text = "1-) Alert dialogs interrupt users with urgent information, details, or actions."
            )

            OutlinedButton(
                modifier = Modifier.fillMaxSize(),
                onClick = {
                    showAlertDialog = !showAlertDialog
                }) {
                Text("AlertDialog")

                if (showAlertDialog) {
                    AlertDialogExample {
                        showAlertDialog = !showAlertDialog
                    }
                }
            }
        }

        item {
            OutlinedButton(
                modifier = Modifier.fillMaxSize(),
                onClick = {
                    showAlertDialogWithStyle = !showAlertDialogWithStyle
                }) {
                Text("AlertDialog with Style")

                if (showAlertDialogWithStyle) {
                    AlertDialogExample2 {
                        showAlertDialogWithStyle = !showAlertDialogWithStyle
                    }
                }
            }
        }

        item {

            HeaderTextView(text = "Dialog")
            StyleableTextView(
                text = "2-) Unlike **AlertDialog**, **Dialog** does not have slots fo " +
                        "**dismissButton, confirmButton, or buttons**. " +
                        "Allows customization of everything inside it."
            )
            OutlinedButton(
                modifier = Modifier.fillMaxSize(),
                onClick = {
                    showDialog = !showDialog
                }) {
                Text("Dialog")

                if (showDialog) {
                    DialogExample {
                        showDialog = !showDialog
                    }
                }
            }

            BodyTextView(text = "Custom Dialog")

            OutlinedButton(
                modifier = Modifier.fillMaxSize(),
                onClick = {
                    showCustomDialog = !showCustomDialog
                }) {

                Text("Custom Dialog")

                if (showCustomDialog) {
                    CustomDialogExample(
                        onDismiss = {
                            showCustomDialog = !showCustomDialog
                            if (!isInPreview) {
                                Toast.makeText(context, "Dialog dismissed!", Toast.LENGTH_SHORT)
                                    .show()
                            }
                        },
                        onNegativeClick = {
                            showCustomDialog = !showCustomDialog
                            if (!isInPreview) {
                                Toast.makeText(
                                    context,
                                    "Negative Button Clicked!",
                                    Toast.LENGTH_SHORT
                                )
                                    .show()
                            }
                        },
                        onPositiveClick = {
                            showCustomDialog = !showCustomDialog
                            if (!isInPreview) {
                                Toast.makeText(
                                    context,
                                    "Positive Button Clicked!",
                                    Toast.LENGTH_SHORT
                                )
                                    .show()
                            }
                        }
                    )
                }
            }
        }

        item {
            BodyTextView(text = "Custom Dialog with Result")
            OutlinedButton(
                modifier = Modifier.fillMaxSize(),
                onClick = {
                    showCustomDialogWithResult = !showCustomDialogWithResult
                }) {
            }
        }
    }
}

@Composable
private fun AlertDialogExample(onDismiss: () -> Unit) {
    AlertDialog(
        onDismissRequest = onDismiss,
        dismissButton = {
            TextButton(
                onClick = onDismiss,
                modifier = Modifier
                    .padding(8.dp)
            ) {
                Text(text = "Cancel")
            }
        },
        confirmButton = {
            TextButton(
                onClick = onDismiss,
                modifier = Modifier
                    .padding(8.dp)
            ) {
                Text(text = "OK")
            }
        },
        title = {
            Text(text = "AlertDialog Title", fontSize = 18.sp, fontWeight = FontWeight.Bold)
        },
        text = {
            Text(text = dialogText)
        }
    )
}

@Composable
private fun AlertDialogExample2(onDismiss: () -> Unit) {
    // This example uses button Composable to create buttons instead of confirmButton and dismissButton

    AlertDialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(
            dismissOnBackPress = true,
            dismissOnClickOutside = false,
            securePolicy = SecureFlagPolicy.Inherit
        ),
        title = {
            Text("AlertDialog with Style", fontWeight = FontWeight.Bold)
        },
        text = {
            Text(text = "This dialog has buttons with custom style and aligned vertically as in Column. Properties set custom behaviour of a dialog such as dismissing when back button pressed or pressed outside of dialog")
        },
        confirmButton = {
            OutlinedButton(
                shape = RoundedCornerShape(percent = 30),
                onClick = onDismiss,
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
            ) {
                Text(text = "Cancel")
            }
            Spacer(modifier = Modifier.width(8.dp))
            OutlinedButton(
                shape = RoundedCornerShape(percent = 30),
                onClick = onDismiss,
                colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = Color(0xff8BC34A),
                    contentColor = Color.White
                ),
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
            ) {
                Text(text = "OK")
            }
        }
    )
}

@Composable
private fun DialogExample(onDismiss: () -> Unit) {
    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties()
    ) {
        Surface(tonalElevation = 8.dp, shape = RoundedCornerShape(12.dp)) {
            Column(
                modifier = Modifier
                    .width(400.dp)
                    .wrapContentHeight()
                    .background(Color.White)
                    .padding(8.dp)
            ) {

                Text(
                    text = "Dialog Title",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(8.dp)
                )

                CompositionLocalProvider(LocalContentColor provides MaterialTheme.colorScheme.onSurfaceVariant) {
                    Text(dialogText, modifier = Modifier.padding(8.dp))
                }

                Spacer(modifier = Modifier.height(8.dp))
                DialogButtons(onDismiss)
            }
        }
    }
}

@Composable
private fun CustomDialogExample(
    onDismiss: () -> Unit,
    onNegativeClick: () -> Unit,
    onPositiveClick: () -> Unit
) {
    Dialog(onDismissRequest = onDismiss) {
        val color = Color(0xff4DB6AC)
        Card(elevation = CardDefaults.cardElevation( 8.dp),
            shape = RoundedCornerShape(12.dp)) {
            Column {
                // Header
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(160.dp)
                        .background(color)
                ) {
                    Icon(
                        tint = Color.White,
                        painter = painterResource(id = R.drawable.ic_baseline_location_on_48),
                        contentDescription = null,
                        modifier = Modifier
                            .graphicsLayer(scaleX = 1.2f, scaleY = 1.2f)
                            .align(
                                Alignment.Center
                            )
                    )
                }

                Column(modifier = Modifier.padding(16.dp)) {
                    CompositionLocalProvider(LocalContentColor provides MaterialTheme.colorScheme.onSurfaceVariant) {
                        Text("To send a nearby place or your location, allow access to your location.")
                    }
                    Row(
                        horizontalArrangement = Arrangement.End,
                        modifier = Modifier.fillMaxWidth()
                    ) {

                        Text(
                            text = "NOT NOW", color = color,
                            modifier = Modifier
                                .clickable(
                                    interactionSource = remember { MutableInteractionSource() },
                                    indication = ripple(color = Color.DarkGray),
                                    onClick = onNegativeClick
                                )
                                .padding(8.dp)
                        )

                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = "CONTINUE", color = color,
                            modifier = Modifier
                                .clickable(
                                    interactionSource = remember { MutableInteractionSource() },
                                    indication = ripple(color = Color.DarkGray),
                                    onClick = onPositiveClick
                                )
                                .padding(8.dp)
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun DialogButtons(onDismiss: () -> Unit) {
    Row {
        TextButton(
            onClick = onDismiss,
            modifier = Modifier.padding(8.dp)
        ) {
            Text(text = "Cancel")
        }
        TextButton(
            onClick = onDismiss,
            modifier = Modifier.padding(8.dp)
        ) {
            Text(text = "OK")
        }
    }
}

val dialogText = """
    Lorem Ipsum is simply dummy text of the printing and typesetting industry. 
    Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown 
    printer took a galley of type and scrambled it to make a type specimen book.
""".trimIndent()

@Preview
@Composable
fun AlertDialogExamplePreview() {
    AlertDialogExample(onDismiss = { })
}

@Preview
@Composable
fun AlertDialogExample2Preview() {
    AlertDialogExample2(onDismiss = { })
}

@Preview
@Composable
fun DialogExamplePreview() {
    DialogExample(onDismiss = { })
}

@Preview
@Composable
fun CustomDialogExamplePreview() {
    CustomDialogExample(onDismiss = {}, onNegativeClick = {}, onPositiveClick = {})
}