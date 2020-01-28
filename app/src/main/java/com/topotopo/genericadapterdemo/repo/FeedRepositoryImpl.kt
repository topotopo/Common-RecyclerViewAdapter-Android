package com.topotopo.genericadapterdemo.repo

import com.topotopo.genericadapterdemo.model.MovieModel
import com.topotopo.genericadapterdemo.model.StatusModel
import com.topotopo.genericadapterdemo.service.FeedApi

class FeedRepositoryImpl(val feedApi: FeedApi) : FeedRepository, BaseRepository() {
    override suspend fun fetchAllFeed(): List<Any> {
        return listOf(
            MovieModel(
                "00",
                "Parasite",
                "",
                "All unemployed, Ki-taek and his family take peculiar interest in the wealthy and glamorous Parks, as they ingratiate themselves into their lives and get entangled in an unexpected incident."
            ),
            StatusModel(
                "01",
                "Golden Mile Complex: preserve or demolish?",
                "The Golden Mile Complex has been put up for sale since Oct 31 last year for S\$800 million, after eighty percent of its owners agreed to have an en bloc sale."
            ),
            MovieModel(
                "02",
                "Knives Out",
                "",
                "When renowned crime novelist Harlan Thrombey (Christopher Plummer) is found dead at his estate just after his 85th birthday, the inquisitive and debonair Detective Benoit Blanc (Daniel Craig) is mysteriously enlisted to investigate."
            ),
            MovieModel(
                "03",
                "Little Women",
                "",
                "Jo March reflects back and forth on her life, telling the beloved story of the March sisters - four young women each determined to live life on their own terms."
            ),
            MovieModel(
                "05",
                "1917",
                "",
                "Two young British soldiers during the First World War are given an impossible mission: deliver a message deep in enemy territory that will stop 1,600 men, and one of the soldiers' brothers, from walking straight into a deadly trap."
            ),
            StatusModel(
                "06",
                "2020 Oscars scorecard",
                "Once Upon a Time’ still out front but watch out for ‘1917’ and ‘Parasite’"
            )
        )
    }
}