package com.masudinn.wsamikom.Model

data class movie(
    val tittle :String,
    val overview : String,
    val release_date:String,
    val poster_Path : String,
    val vote_average : Float
)

data class MovieResponse(
    val results : List<movie>
)
