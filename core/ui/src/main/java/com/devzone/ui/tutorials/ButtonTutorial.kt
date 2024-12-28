package com.devzone.ui.tutorials

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.devzone.ui.R
import com.devzone.ui.tutorials.others.CustomChip
import com.devzone.ui.tutorials.others.CustomOutlinedChip
import com.devzone.ui.tutorials.others.FullWidthRow
import com.devzone.ui.tutorials.others.TutorialChip
import com.devzone.ui.tutorials.others.HeaderTextView
import com.devzone.ui.tutorials.others.BodyTextView
import com.devzone.ui.theme.IndicatingIconButton

@Preview(showBackground = true)
@Composable
fun Tutorial2_2Screen() {
    TutorialContent()
}

@Composable
private fun TutorialContent() {

    LazyColumn(Modifier.fillMaxSize()) {

        item {

            val paddingModifier = Modifier.padding(8.dp)

            HeaderTextView(text = "Button")

            BodyTextView(text = "Button")
            ButtonExample(paddingModifier)
            DisabledButtonExample(paddingModifier)
            ButtonWithIconExample(paddingModifier)
            ButtonBackgroundExample(paddingModifier)
            GradientButtonExample(paddingModifier)

            BodyTextView(text = "Icon Button")
            IconButtonExample(paddingModifier)

            BodyTextView(text = "Custom Ripple Icon Button")
            CustomIconButtonExample(paddingModifier)

            HeaderTextView(text = "Floating Action Button")
            FloatingActionButtonExample(paddingModifier)

            HeaderTextView(text = "Chip")
//            ChipExamples()
            HeaderTextView(text = "Custom Chip")
            CustomChipExample(paddingModifier)
        }
    }
}

@Composable
private fun ButtonExample(modifier: Modifier) {
    FullWidthRow {

        Button(onClick = {}, modifier = modifier) {
            Text(text = "Button")
        }

        TextButton(onClick = {}, modifier = modifier) {
            Text(text = "TextButton")
        }

        OutlinedButton(
            onClick = {},
            modifier = modifier,
        ) {
            Text(text = "Outlined")
        }
    }

    FullWidthRow {

        Button(
            onClick = {},
            modifier = modifier,
            shape = RoundedCornerShape(15.dp)
        ) {
            Text(text = "Rounded")
        }

        Button(
            onClick = {},
            modifier = modifier,
            shape = RoundedCornerShape(
                topStartPercent = 30,
                topEndPercent = 0,
                bottomStartPercent = 0,
                bottomEndPercent = 0
            )
        ) {
            Text(text = "Rounded")
        }

        Button(
            onClick = { },
            modifier = modifier,
            shape = CutCornerShape(20)
        ) {
            Text(text = "CutCorner")
        }
    }
}

@Composable
private fun DisabledButtonExample(modifier: Modifier) {
    FullWidthRow {
        Button(
            onClick = {},
            modifier = modifier,
            enabled = false
        ) {
            Text(text = "Button")
        }

        TextButton(
            onClick = {},
            modifier = modifier,
            enabled = false
        ) {
            Text(text = "TextButton")
        }

        OutlinedButton(
            onClick = {},
            modifier = modifier,
            enabled = false
        ) {
            Text(text = "Outlined")
        }
    }
}

@Composable
private fun ButtonWithIconExample(modifier: Modifier) {
    FullWidthRow {
        Button(
            onClick = {},
            modifier = modifier
        ) {
            Row {
                Icon(
                    imageVector = Icons.Default.FavoriteBorder,
                    modifier = Modifier.padding(end = 4.dp),
                    contentDescription = null
                )
                Text(text = "Icon+Text")
            }
        }

        Button(
            onClick = {},
            modifier = modifier
        ) {
            Text(text = "Text+Icon")
            Icon(
                imageVector = Icons.Default.FavoriteBorder,
                modifier = Modifier.padding(start = 4.dp),
                contentDescription = null
            )
        }

        Button(
            onClick = {},
            shape = RoundedCornerShape(20),
            modifier = modifier
        ) {
            Icon(
                imageVector = Icons.Default.FavoriteBorder,
                contentDescription = null
            )
        }
    }

    FullWidthRow {
        OutlinedButton(
            onClick = {},
            modifier = Modifier.padding(8.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Call,
                modifier = Modifier.padding(start = 4.dp, end = 4.dp),
                contentDescription = null
            )
            Text(text = "Icon+Text+Icon")
            Icon(
                imageVector = Icons.Default.FavoriteBorder,
                modifier = Modifier.padding(start = 4.dp),
                contentDescription = null
            )
        }
    }
}

@Composable
private fun ButtonBackgroundExample(modifier: Modifier) {
    FullWidthRow {

        Button(
            onClick = {},
            modifier = modifier,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xffF57C00),
                contentColor = Color(0xffB2EBF2)
            )
        ) {
            Text(text = "Button")
        }

        TextButton(
            onClick = {},
            modifier = modifier,
            colors = ButtonDefaults.textButtonColors(
                contentColor = Color(0xff8BC34A)
            )
        ) {
            Text(text = "TextButton")
        }

        OutlinedButton(
            onClick = {},
            modifier = modifier,
            colors = ButtonDefaults.outlinedButtonColors(
                contentColor = Color(0xff795548)
            )
        ) {
            Text(text = "Outlined")
        }
    }
}

@Composable
private fun GradientButtonExample(modifier: Modifier) {

    val horizontalGradientBrush = Brush.horizontalGradient(
        colors = listOf(
            Color(0xffF57F17),
            Color(0xffFFEE58),
            Color(0xffFFF9C4)
        )
    )

    val verticalGradientBrush = Brush.verticalGradient(
        colors = listOf(
            Color(0xff4E342E),
            Color(0xff8D6E63),
            Color(0xffD7CCC8)
        )
    )

    FullWidthRow {
        Column(
            modifier = modifier
                .clip(RoundedCornerShape(20))
                .background(brush = horizontalGradientBrush)
                .clickable(onClick = { })
                .then(modifier)
        ) {
            Text(text = "Horizontal Gradient")
        }

        Column(
            modifier = modifier
                .clip(RoundedCornerShape(20))
                .background(brush = verticalGradientBrush)
                .clickable(onClick = { })
                .then(modifier)
        ) {
            Text(text = "Vertical Gradient")
        }
    }
}

@Composable
private fun IconButtonExample(modifier: Modifier) {

    FullWidthRow {
        IconButton(onClick = {}, modifier = modifier) {
            Icon(
                Icons.Filled.Favorite,
                contentDescription = null
            )
        }

        var checked by remember { mutableStateOf(false) }

        IconToggleButton(
            checked = checked,
            onCheckedChange = { checked = it },
            modifier = modifier
        ) {

            val tint by animateColorAsState(
                targetValue = if (checked) Color(0xffE91E63) else Color(0xffB0BEC5),
                animationSpec = tween(durationMillis = 400)
            )

            Icon(
                Icons.Filled.Favorite, tint = tint,
                contentDescription = null
            )
        }
    }
}

@Composable
private fun CustomIconButtonExample(modifier: Modifier) {

    // rememberRipple of this custom button defines ripple radius, color and if it will be bounded

    FullWidthRow(modifier.padding(horizontal = 30.dp)) {
        IndicatingIconButton(
            onClick = { /*TODO*/ },
            indication = ripple(
                bounded = false,
                radius = 40.dp,
                color = Color(
                    0xff42A5F5
                )
            )
        ) {
            Icon(
                Icons.Filled.Favorite,
                contentDescription = null,
                tint = Color(0xffE91E63)
            )
        }

        Spacer(modifier = Modifier.width(40.dp))

        IndicatingIconButton(
            onClick = { /*TODO*/ },
            indication = ripple(
                bounded = false,
                radius = 30.dp,
                color = Color(0xffBF360C)
            )
        ) {
            Icon(
                Icons.Filled.Favorite,
                contentDescription = null,
                tint = Color(0xffE91E63)
            )
        }

        Spacer(modifier = Modifier.width(40.dp))

        // this one's ripple is bounded
        IndicatingIconButton(
            onClick = { /*TODO*/ },
            indication = ripple(
                bounded = true,
                radius = 30.dp,
                color = Color(0xff311B92)
            )
        ) {
            Icon(
                Icons.Filled.Favorite,
                contentDescription = null,
                tint = Color(0xffE91E63),
                modifier = Modifier.size(36.dp)
            )
        }

        Spacer(modifier = Modifier.width(40.dp))

        IndicatingIconButton(
            onClick = { /*TODO*/ },
            indication = ripple(
                bounded = false,
                radius = 50.dp,
                color = Color(0xff43A047)
            )
        ) {
            Icon(
                Icons.Filled.Favorite,
                contentDescription = null,
                tint = Color(0xffE91E63),
                modifier = Modifier.size(36.dp)
            )
        }
    }
}

@Composable
private fun FloatingActionButtonExample(modifier: Modifier) {

    FullWidthRow {

        FloatingActionButton(
            onClick = {},
            modifier = modifier,
        ) {
            Icon(
                Icons.Filled.Favorite,
                contentDescription = null
            )
        }

        FloatingActionButton(
            onClick = {},
            modifier = modifier,
            containerColor = Color(0xffFFA000)
        ) {
            Icon(
                Icons.Filled.Done, tint = Color.White,
                contentDescription = null
            )
        }

        ExtendedFloatingActionButton(
            onClick = {},
            modifier = modifier,
            content = { Text("Extended") }
        )

        ExtendedFloatingActionButton(
            icon = {
                Icon(
                    imageVector = Icons.Filled.Favorite,
                    tint = Color.White,
                    contentDescription = null
                )
            },
            text = { Text("Like", color = Color.White) },
            containerColor = Color(0xffEC407A),
            onClick = {},
            modifier = modifier
        )
    }
}

/*@Preview
@Composable
private fun ChipExamples() {

    val context = LocalContext.current

    FlowRow(
        modifier = Modifier.fillMaxWidth()
    ) {

        Chip(
            onClick = {
                Toast.makeText(context, "I'm clicked", Toast.LENGTH_SHORT).show()
            }
        ) {
            Text("Chip")
        }


        Chip(
            enabled = false,
            onClick = {},
            labelColor = Color.White
        ) {
            Text("Disabled Chip")
        }

        Chip(
            onClick = {},
            border = BorderStroke(1.dp, Green400.copy(alpha = .9f)),
            colors = ChipDefaults.chipColors(
                backgroundColor = Green400,
                contentColor = Color.White
            )
        ) {
            Text("Colored Chip")
        }

        Chip(
            shape = RoundedCornerShape(50),
            onClick = {
                Toast.makeText(context, "I'm clicked", Toast.LENGTH_SHORT).show()
            },
            leadingIcon = {
                Image(
                    painter = painterResource(R.drawable.avatar_1_raster),
                    modifier = Modifier
                        .border(1.dp, Color.Green)
                        .padding(vertical = 4.dp)
                        .size(32.dp)
                        .clip(CircleShape),
                    contentDescription = null
                )
            }
        ) {
            Row(
                modifier = Modifier.border(1.dp, Color.Red),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Chip")
                Spacer(modifier = Modifier.width(ButtonDefaults.IconSpacing))
                Icon(
                    modifier = Modifier
                        .clip(CircleShape)
                        .clickable {
                            Toast.makeText(context, "Cancel clicked", Toast.LENGTH_SHORT).show()
                        }
                        .background(Color.Black.copy(alpha = .6f))
                        .size(20.dp)
                        .padding(4.dp),
                    imageVector = Icons.Filled.Close,
                    tint = Color(0xFFE0E0E0),
                    contentDescription = null
                )
            }
        }

        Chip(
            shape = RoundedCornerShape(50),
            onClick = {
                Toast.makeText(context, "I'm clicked", Toast.LENGTH_SHORT).show()
            },
            border = BorderStroke(1.dp, Green400.copy(alpha = .9f)),
            colors = ChipDefaults.chipColors(
                backgroundColor = Green400,
                contentColor = Color.White
            ),
            leadingIcon = {
                Image(
                    painter = painterResource(R.drawable.avatar_1_raster),
                    modifier = Modifier
                        .padding(vertical = 4.dp)
                        .size(32.dp)
                        .clip(CircleShape),
                    contentDescription = null
                )
            }
        ) {
            Text("Chip")
            Spacer(modifier = Modifier.width(ButtonDefaults.IconSpacing))
            Icon(
                modifier = Modifier
                    .clip(CircleShape)
                    .clickable {
                        Toast.makeText(context, "Cancel clicked", Toast.LENGTH_SHORT).show()
                    }
                    .background(Color.Black.copy(alpha = .6f))
                    .size(20.dp)
                    .padding(4.dp),
                imageVector = Icons.Filled.Close,
                tint = Color(0xFFE0E0E0),
                contentDescription = null
            )
        }
    }
}*/

@Composable
fun CustomChipExample(modifier: Modifier) {
    FullWidthRow {
        TutorialChip(modifier = modifier, text = "Chip")
        CustomChip(
            modifier = modifier,
            text = "CustomChip",
            drawableRes = R.drawable.avatar_1_raster,
            cancelable = true
        )
        CustomOutlinedChip(
            modifier = modifier,
            text = "Outlined",
            drawableRes = R.drawable.avatar_2_raster,
            closable = true
        )
    }
}

