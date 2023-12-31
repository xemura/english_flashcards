package com.xenia.englishusingflashcards.repositories

import com.xenia.englishusingflashcards.room.daos.WordDao
import com.xenia.englishusingflashcards.room.entities.Category
import com.xenia.englishusingflashcards.room.entities.Word
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WordRepository(private val wordDao: WordDao) {

    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    fun insertListWords(words: List<Word>) {
        coroutineScope.launch(Dispatchers.IO) {
            wordDao.insertAll(words)
        }
    }
}