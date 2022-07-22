package com.nirwal.desimart.ui.composable



import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.shapes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nirwal.desimart.R
import com.nirwal.desimart.ui.theme.*


@Preview(showBackground = true)
@Composable
fun LoginPage() {

    Box() {
        BgCard()
        MainCard()



    }

}


@Composable
fun BgCard() {
    val signupText = buildAnnotatedString{
        append("Don't have an account? ")
        withStyle(SpanStyle(color = orangish)) {
            append("Sign up here!")
        }
    }
    Surface(color = purplish, modifier = Modifier.fillMaxSize()) {
        Column(verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.offset(y = (-30).dp)
        ) {
            Row() {
                Image(
                    painter = painterResource(id = R.drawable.ic_fb),
                    contentDescription = null
                )
                Spacer(modifier = Modifier.padding(horizontal = 4.dp))
                Image(painter = painterResource(id = R.drawable.ic_google),
                    contentDescription = null
                )
                Spacer(modifier = Modifier.padding(horizontal = 4.dp))
                Image(painter = painterResource(id = R.drawable.ic_twitter),
                contentDescription = null
                )

            }
            Spacer(modifier = Modifier.padding(vertical = 8.dp))
            Text(text = signupText, color = Color.White)
        }
    }
}


@Composable
fun MainCard() {
    val emailState = remember { mutableStateOf(TextFieldValue("mtechviral@gmail.com")) }
    val passState = remember { mutableStateOf(TextFieldValue("")) }

    Surface(color = Color.White, modifier = Modifier
        .height(600.dp)
        .fillMaxWidth(),
        shape = RoundedCornerShape(60.dp).copy( topStart = ZeroCornerSize, topEnd = ZeroCornerSize))
        {

        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            val modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)

            Image(painter = painterResource(id = R.drawable.ic_vaccum), contentDescription = null)
            Spacer(modifier = Modifier.padding(16.dp))


            OutlinedTextField(
                value = emailState.value,
                onValueChange = {emailState.value = it},
                label = {Text(text = "Email address")},
                leadingIcon =  {Icon(Icons.Filled.Email, contentDescription = "email")} ,
                modifier = modifier
            )

            Spacer(modifier = Modifier.padding(6.dp))

            OutlinedTextField(
                value = passState.value,
                onValueChange = { passState.value = it },
                label = { Text(text = "Password") },
                leadingIcon = { Icon(Icons.Filled.Lock, contentDescription = "lock") },
                modifier = modifier
               // keyboardType = KeyboardType.Password
            )

            Spacer(modifier = Modifier.padding(vertical = 12.dp))
//            ProvideEmphasis(emphasis = EmphasisAmbient.current.disabled) {
//                Text(text = "Forgot password?", textAlign = TextAlign.End, modifier = modifier)
//            }
            Spacer(modifier = Modifier.padding(vertical = 12.dp))
            Button(onClick = {}, shape = shapes.medium,
                colors = ButtonDefaults.buttonColors(backgroundColor = orangish, contentColor = Color.White),
                modifier = modifier,
                contentPadding = PaddingValues(16.dp)
            ) {
                Text(text = "Log In")
            }
        }
    }
}