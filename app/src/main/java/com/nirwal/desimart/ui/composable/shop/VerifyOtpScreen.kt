package com.nirwal.desimart.ui.composable.shop

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.nirwal.desimart.ui.component.MyTopBar

@Composable
fun VerifyOTPScreen(mobileNumber:String,onBack:()->Unit, onOtpSubmit:(String)->Unit) {

    var otp by remember {
        mutableStateOf("")
    }

    Column {
        MyTopBar(title = "", iconBack = Icons.Default.ArrowBack, onBackClick = onBack)

        ConstraintLayout(
            Modifier
                .fillMaxSize()
                .padding(32.dp)
        ) {
            val (veryNuberTxt, otpSentText, OtpField, otpSentMsg, verifyBtn) = createRefs()

            Text(
                modifier = Modifier.constrainAs(veryNuberTxt){
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                },
                text = "Verify Phone Number",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            )

            Text(
                modifier = Modifier.constrainAs(otpSentText){
                    top.linkTo(veryNuberTxt.bottom,8.dp)
                    start.linkTo(parent.start)
                },
                lineHeight = 24.sp,
                text = "An SMS with 6-digit OTP was sent to \n$mobileNumber Change"
            )

            OtpTextField(
                modifier = Modifier.constrainAs(OtpField){
                    top.linkTo(otpSentText.bottom,16.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(verifyBtn.top)
                },
                otpText = otp, onOtpTextChange = { value, _ ->
                    otp =value
                }
            )
            Text(
                modifier = Modifier.constrainAs(otpSentMsg){
                    top.linkTo(OtpField.bottom,16.dp)
                    start.linkTo(OtpField.start)
                    end.linkTo(OtpField.end)

                },
                text = "Waiting for OTP ..22 seconds"
            )

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .constrainAs(verifyBtn) {
                        bottom.linkTo(parent.bottom, 16.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    },
                onClick = {onOtpSubmit.invoke(otp)},
                shape = RoundedCornerShape(50)
            ) {
                Text(text = "Verify")
            }
        }
    }

}



@Composable
fun OtpTextField(
    modifier: Modifier = Modifier,
    otpText: String,
    otpCount: Int = 6,
    onOtpTextChange: (String, Boolean) -> Unit
) {
    LaunchedEffect(Unit) {
        if (otpText.length > otpCount) {
            throw IllegalArgumentException("Otp text value must not have more than otpCount: $otpCount characters")
        }
    }

    BasicTextField(
        modifier = modifier,
        value = TextFieldValue(otpText, selection = TextRange(otpText.length)),
        onValueChange = {
            if (it.text.length <= otpCount) {
                onOtpTextChange.invoke(it.text, it.text.length == otpCount)
            }
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
        decorationBox = {
            Row(horizontalArrangement = Arrangement.Center) {
                repeat(otpCount) { index ->
                    CharView(
                        index = index,
                        text = otpText
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                }
            }
        }
    )
}



@Composable
private fun CharView(
    index: Int,
    text: String
) {
    val isFocused = text.length == index
    val char = when {
        index == text.length -> "0"
        index > text.length -> ""
        else -> text[index].toString()
    }
    Text(
        modifier = Modifier
            .width(40.dp)
            .border(
                1.dp, when {
                    isFocused -> Color.DarkGray
                    else -> Color.LightGray
                }, RoundedCornerShape(8.dp)
            )
            .padding(2.dp),
        text = char,
        style = MaterialTheme.typography.titleLarge,
        color = if (isFocused) {
            Color.LightGray
        } else {
            Color.DarkGray
        },
        textAlign = TextAlign.Center
    )
}
