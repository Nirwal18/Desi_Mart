package com.nirwal.desimart.ui.composable.auth

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.nirwal.desimart.ui.navigation.MyNavGraph

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout


@Preview(showBackground = true)
@Composable
fun SignInScreenPreview() {
    SignInScreen ({},{},{},{})
}

@Composable
fun SignInScreen(
    onGetOtp:(phone:String)->Unit,
    onSkip:()->Unit,
    showTermAndCondition:()->Unit,
    showPrivacyPolicy:()->Unit
){
    var mobileNumber by remember{ mutableStateOf("") }

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(32.dp)
    ) {
        val (skipBtn, title, msg, termCondiMsg, otpBtn,otpInput) = createRefs()

        TextButton(
            modifier = Modifier.constrainAs(skipBtn){
                top.linkTo(parent.top)
                end.linkTo(parent.end)
            },
            onClick = onSkip,
            shape = RoundedCornerShape(50)
        ) {
            Text(
                text = "Skip",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Text(
            modifier = Modifier.constrainAs(title){
                top.linkTo(skipBtn.bottom, 48.dp)
                start.linkTo(parent.start)
            },
            text = "Sign in \nto DesiMart",
            fontSize = 32.sp,
            fontWeight = FontWeight.ExtraBold
        )

        Text(
            modifier = Modifier.constrainAs(msg){
                top.linkTo(title.bottom)
                start.linkTo(parent.start)

            },
            text = "to access your Addresses, Orders & Wishlist."
        )

        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(otpInput) {
                    top.linkTo(msg.bottom, 16.dp)
                    bottom.linkTo(otpBtn.top, 16.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
            keyboardActions = KeyboardActions(onDone = {onGetOtp(mobileNumber)}),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.Transparent,
                focusedIndicatorColor =  Color.Blue,
                unfocusedIndicatorColor = Color.DarkGray,
                cursorColor = Color.Black
            ),
            leadingIcon = {
                Text(text = "+91 -"
                )
            },
            value = mobileNumber, onValueChange = {mobileNumber = it }
        )

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(otpBtn) {
                    bottom.linkTo(termCondiMsg.top, 16.dp)
                    start.linkTo(parent.start)
                },
            onClick = { onGetOtp(mobileNumber) },
            shape = RoundedCornerShape(50)
        ) {
            Text(text = "Get OTP")
        }


        val tnc = "Terms and Condition"
        val privacyPolicy = "Privacy & Legal Policy"
        val annotatedString = buildAnnotatedString {
            append("By continuing you agree to our ")
            withStyle(style = SpanStyle(color = Color.Blue), ) {
                pushStringAnnotation(tag = tnc, annotation = tnc)
                append(tnc)
            }
            append(" and \n")
            withStyle(style = SpanStyle(color = Color.Blue), ) {
                pushStringAnnotation(tag = privacyPolicy, annotation = privacyPolicy)
                append(privacyPolicy)
            }
        }
        ClickableText(
            modifier = Modifier.constrainAs(termCondiMsg){
                bottom.linkTo(parent.bottom, 16.dp)
                start.linkTo(parent.start)
            },
            text = annotatedString, onClick = { offset ->
                annotatedString.getStringAnnotations(offset, offset)
                    .firstOrNull()?.let { span ->
                        println("Clicked on ${span.item}")
                    }
            })


    }

}