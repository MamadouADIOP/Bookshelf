package com.example.bookshelf.fake

import com.example.bookshelf.model.Book
import com.example.bookshelf.model.Bookshelf
import com.example.bookshelf.model.ImageLinks
import com.example.bookshelf.model.Item
import com.example.bookshelf.model.VolumeInfo

object FakeDataSource {
    private var items = listOf( Item(
        id = "1",
        volumeInfo = VolumeInfo(imageLinks = ImageLinks(thumbnail = "link1"))),
        Item(
            id = "2",
            volumeInfo = VolumeInfo(imageLinks = ImageLinks(thumbnail = "link2"))),
        Item(
            id = "3",
            volumeInfo = VolumeInfo(imageLinks = ImageLinks(thumbnail = "link3"))))
  val  bookshelf =
      Bookshelf(items, totalItems = items.size)

    val books = items.mapNotNull{t -> t.volumeInfo.imageLinks?.let { Book(t.id, it.thumbnail) } }

}