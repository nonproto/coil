package carloesco.coilsample

import android.content.Context
import android.widget.ImageView
import androidx.annotation.StringRes
import coil.load
import coil.loadAny
import coil.transform.RoundedCornersTransformation
import com.google.android.material.button.MaterialButton
import com.squareup.contour.ContourLayout

class MainView(context: Context) : ContourLayout(context) {
    val urls = listOf("https://mangadex.org/images/covers/39v1.jpg?1545761095", "https://mangadex.org/images/covers/39v2.jpg?1545761109")
    var pos = 0


    val cover = ImageView(context).apply {
        elevation = 10f
        translationZ = 10f
        this.loadAny(urls[pos]) {
            transformations(RoundedCornersTransformation(20f))
        }
    }

    val button  = MaterialButton(context).apply {
        text = "Switch"
        isAllCaps = false
        includeFontPadding = false
    }


    init {
        cover.layoutBy(
            x = leftTo { parent.left() + 8.xdip }.rightTo { parent.right() - 8.xdip },
            y = topTo { parent.top() + 16.ydip }.bottomTo { button.top() - 8.ydip - 8.ydip }
        )
        button.layoutBy(
            x = leftTo { parent.left() }.rightTo { parent.right() },
            y = topTo { parent.centerY() - 16.ydip }
        )

        button.setOnClickListener {
            if(pos == 0){
                pos = 1
            }else{
                pos = 0
            }

            cover.load(urls[pos]) {
                transformations(RoundedCornersTransformation(20f))
            }

        }
    }
}
