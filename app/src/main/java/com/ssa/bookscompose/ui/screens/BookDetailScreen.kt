package com.ssa.bookscompose.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.ssa.bookscompose.R
import com.ssa.bookscompose.data.Book

@Composable
fun BookDetailScreen(
    book: Book,
    modifier: Modifier = Modifier
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        AsyncImage(
            modifier = modifier
                .fillMaxWidth()
                .size(295.dp),
            model = ImageRequest.Builder(LocalContext.current)
                .data(book.imageLink?.replace("http", "https"))
                .crossfade(true)
                .build(),
            error = painterResource(id = R.drawable.ic_book_96),
            placeholder = painterResource(id = R.drawable.loading_img),
            contentDescription = stringResource(id = R.string.content_description),
            contentScale = ContentScale.Crop
        )
        book.title?.let {
            Text(
                text = it,
                textAlign = TextAlign.Center,
                modifier =
                modifier.padding(top = 4.dp, bottom = 8.dp)
            )
        }
        book.description?.let {
            Text(
                text = it,
                textAlign = TextAlign.Center,
                modifier =
                modifier.padding(top = 4.dp, bottom = 8.dp)
            )
        }
    }
}