package com.ovidiucristurean.clipboardsaver

import platform.UIKit.UIPasteboard

actual class ClipboardSaver {
    actual fun saveToClipboard(text: String) {
        UIPasteboard.generalPasteboard().string = text
    }
}
