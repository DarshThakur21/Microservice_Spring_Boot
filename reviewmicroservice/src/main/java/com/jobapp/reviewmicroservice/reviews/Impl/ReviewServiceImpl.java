package com.jobapp.reviewmicroservice.reviews.Impl;



import com.jobapp.reviewmicroservice.reviews.Review;
import com.jobapp.reviewmicroservice.reviews.ReviewRepo;
import com.jobapp.reviewmicroservice.reviews.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
        private final ReviewRepo reviewRepo;
//        private final CompanyService companyService;
    public ReviewServiceImpl(ReviewRepo reviewRepo) {
        this.reviewRepo = reviewRepo;
//        this.companyService=companyService;
    }

    @Override
    public List<Review> getallreviews(Long companyId) {
        List<Review> reviews=reviewRepo.findByCompanyId(companyId);
        return reviews;
    }

    @Override
    public boolean addreview(Long companyId, Review review) {
//        Company company=companyService.findByid(companyId);

        if(companyId!=null && review!=null){
            review.setCompanyId(companyId);
             reviewRepo.save(review);
             return true;
        }
        return false;

    }

    @Override
    public Review getreview(  Long reviewId) {
//        Review revie
   return reviewRepo.findById(reviewId).orElse(null);
    }

    @Override
    public boolean updatereview( Long reviewId, Review updatedreview) {

        Review review=reviewRepo.findById(reviewId).orElse(null);
        if(reviewId!=null ){
            review.setTitle(updatedreview.getTitle());
            review.setDescription(updatedreview.getDescription());
            review.setRating(updatedreview.getRating());
            review.setCompanyId(updatedreview.getCompanyId());

            reviewRepo.save(review);
            return true;
        }
        else{
            return false;
        }

    }

    @Override
    public boolean deletereview(  Long reviewId) {
        Review review=reviewRepo.findById(reviewId).orElse(null);
        if(review!=null ){
          reviewRepo.delete(review);
//            reviewRepo.deleteById(reviewId);
            return true;
        }

        return false;
    }


}
