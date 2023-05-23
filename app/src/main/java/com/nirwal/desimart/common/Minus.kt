package com.nirwal.desimart.common


import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.materialIcon
import androidx.compose.material.icons.materialPath
import androidx.compose.ui.graphics.vector.ImageVector

val Icons.Filled.Minus: ImageVector
    get() {
        if (_minus != null) {
            return _minus!!
        }
        _minus = materialIcon(name = "Filled.Minus") {

            materialPath {
                moveTo(3.0f, 12.0f)
                horizontalLineToRelative(18.0f)
                verticalLineToRelative(2.0f)
                horizontalLineToRelative(-18.0f)
                close()
            }

        }
        return _minus!!
    }

private var _minus: ImageVector? = null
