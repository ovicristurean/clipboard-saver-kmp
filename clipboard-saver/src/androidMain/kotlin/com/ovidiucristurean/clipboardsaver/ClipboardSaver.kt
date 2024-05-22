package com.ovidiucristurean.clipboardsaver

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context

actual class ClipboardSaver(
    private val context: Context
) {
    actual fun saveToClipboard(text: String) {
        val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clip = ClipData.newPlainText("copied text", text)
        clipboard.setPrimaryClip(clip)
    }
}
