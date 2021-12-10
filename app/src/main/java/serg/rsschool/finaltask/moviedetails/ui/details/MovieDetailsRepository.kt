package serg.rsschool.finaltask.moviedetails.ui.details

import serg.rsschool.finaltask.moviedetails.data.moviedetails.MovieDetails
import serg.rsschool.finaltask.moviedetails.remote.MovieInterface
import serg.rsschool.finaltask.moviedetails.utils.Constants
import serg.rsschool.finaltask.moviedetails.utils.Result
import serg.rsschool.finaltask.moviedetails.utils.Status

class MovieDetailsRepository(private val movieInterface: MovieInterface) {


    suspend fun getMovieDetails(imdbId: String): Result<MovieDetails> {


        return try {

            val response = movieInterface.getMovieDetails(imdbId, Constants.API_KEY)
            if (response.isSuccessful) {

                Result(Status.SUCCESS, response.body(), null)

            } else {
                Result(Status.ERROR, null, null)
            }


        } catch (e: Exception) {
            Result(Status.ERROR, null, null)
        }


    }


}