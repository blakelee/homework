package net.blakelee.homework.utils

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.jetbrains.anko.AlertBuilder
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import com.raizlabs.android.dbflow.data.Blob
import java.io.ByteArrayOutputStream

fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)
}

fun AlertBuilder<DialogInterface>.multiItems(ctx: Context, items: List<CharSequence>, checked: BooleanArray, onItemSelected: (dialog: DialogInterface, index: Int, isChecked: Boolean) -> Unit) {
    val builder = AlertDialog.Builder(ctx)
    builder.setMultiChoiceItems(Array(items.size){ i -> items[i].toString() }, checked) {dialog, which, isChecked ->
        onItemSelected(dialog, which, isChecked)
    }
    builder.create()
    builder.show()
}

fun BitmapToBlob(bitmap: Bitmap) : Blob {
    val baos = ByteArrayOutputStream()
    bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos)
    return Blob(baos.toByteArray())
}

fun BlobToBitmap(blob: Blob) : Bitmap {
    return BitmapFactory.decodeByteArray(blob.blob, 0, blob.blob.size)
}