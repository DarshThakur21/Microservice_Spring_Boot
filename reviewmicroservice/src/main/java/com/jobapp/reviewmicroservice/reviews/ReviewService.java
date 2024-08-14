package com.jobapp.reviewmicroservice.reviews;


import java.util.List;


public interface ReviewService {
    List<Review> getallreviews(Long companyId);

    boolean addreview(Long companyId, Review review);
    Review getreview( Long reviewId);
    boolean  updatereview(Long reviewId,Review review);
    boolean deletereview( Long reviewId);
}
