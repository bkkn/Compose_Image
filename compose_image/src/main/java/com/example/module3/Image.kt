package com.example.module3.ui.img

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.ImageLoader
import coil.bitmap.BitmapPool
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import coil.decode.DataSource
import coil.memory.MemoryCache
import coil.request.*
import coil.transform.BlurTransformation
import coil.transform.CircleCropTransformation
import coil.transform.RoundedCornersTransformation
import com.example.module3.App
import com.example.module3.R
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun ImgTextStab(text: String) {
    Text(text = text, fontSize = 48.sp, textAlign = TextAlign.Center)
}

@Composable
fun ImgLandcapistExt() {

    GlideImage(
        imageModel = "https://picsum.photos/400/600",
        Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop,
        // shows a progress indicator when loading an image.
        loading = {
            Text(text = "aaa")
        },
        // shows an error text message when request failed.
        failure = {
            Text(text = "image request failed.")
        })
}

@Composable
fun ImgLandcapist() {

    GlideImage(
        imageModel = "https://picsum.photos/400/600",
        // Crop, Fit, Inside, FillHeight, FillWidth, None
        contentScale = ContentScale.Crop,
        // shows an image with a circular revealed animation.
        // shows a placeholder ImageBitmap when loading.
//        placeHolder = ImageBitmap.imageResource(R.drawable.ic_launcher_foreground),
        // shows an error ImageBitmap when the request failed.
//        error = ImageBitmap.imageResource(R.drawable.ic_launcher_background)
    )
}


@Composable
fun ImgFreso() {

//    FrescoImage(
//        imageUrl = "stringImageUrl",
//        // Crop, Fit, Inside, FillHeight, FillWidth, None
//        contentScale = ContentScale.Crop,
//        // shows an image with a circular revealed animation.
//        circularRevealedEnabled = true,
//        // shows a placeholder ImageBitmap when loading.
//        placeHolder = ImageBitmap.imageResource(R.drawable.ic_launcher_background),
//        // shows an error ImageBitmap when the request failed.
//        error = ImageBitmap.imageResource(R.drawable.ic_launcher_foreground)
//    )
}

@Composable
fun ImgCoilExt(url: String) {
    val painter = rememberImagePainter(
        data = url,
        builder = {
            placeholder(R.drawable.ic_launcher_foreground)
            error(R.drawable.ic_launcher_background)
            crossfade(500)
            transformations(
//                CircleCropTransformation(),
                BlurTransformation(LocalContext.current),
                RoundedCornersTransformation(50f)
            )
        }
    )
    val painterState = painter.state
    Image(painter = painter, contentDescription = "Image")

    if (painterState is ImagePainter.State.Loading) {
        CircularProgressIndicator()
    }
}


//@Composable
//fun ImgCoil(url: String) {
//    Card(
//        modifier = Modifier
//            .wrapContentSize(Alignment.Center),
//        shape = RectangleShape,
//        elevation = 2.dp
//    ) {
//        Row(
//            modifier = Modifier,
////            horizontalArrangement = Arrangement.Center,
////            verticalAlignment = Alignment.CenterVertically
//        ) {
//            val imageLoader = ImageLoader.Builder(App as Context)
//                .availableMemoryPercentage(0.25)
//                .crossfade(true)
//                .build()
//
//            // enqueue
//            val request1 = ImageRequest.Builder(App as Context)
//                .data("https://www.example.com/image.jpg")
//                .target(imageView)
//                .build()
//            val disposable = imageLoader.enqueue(App as Context)
//
//// execute
//            val request = ImageRequest.Builder(App as Context)
//                .data("https://www.example.com/image.jpg")
//                .build()
//            val result = imageLoader.execute(request)
//
//            imageLoader.execute()
//            Image(
//
////                painter = rememberImagePainter(url),
//                contentDescription = null,
//                modifier = Modifier
//            )
//        }
//    }
//}

//
//val fakeImageLoader = object : ImageLoader {
//
//    private val disposable = object : Disposable {
//        override val isDisposed get() = true
//        override fun dispose() {}
//        override suspend fun await() {}
//    }
//
//    override val defaults = DefaultRequestOptions()
//
//    // Optionally, you can add a custom fake memory cache implementation.
//    override val memoryCache get() = throw UnsupportedOperationException()
//
//    override val bitmapPool = BitmapPool(0)
//
//    override fun enqueue(request: ImageRequest): Disposable {
//        // Always call onStart before onSuccess.
//        request.target?.onStart(placeholder = ColorDrawable(Color.BLACK))
//        request.target?.onSuccess(result = ColorDrawable(Color.BLACK))
//        return disposable
//    }
//
//    override suspend fun execute(request: ImageRequest): ImageResult {
//        return SuccessResult(
//            drawable = ColorDrawable(Color.BLACK),
//            request = request,
//            metadata = ImageResult.Metadata(
//                memoryCacheKey = MemoryCache.Key(""),
//                isSampled = false,
//                dataSource = DataSource.MEMORY_CACHE,
//                isPlaceholderMemoryCacheKeyPresent = false
//            )
//        )
//    }
//
//    override fun shutdown() {}
//
//    override fun newBuilder() = ImageLoader.Builder(App.getAppContext())
//}