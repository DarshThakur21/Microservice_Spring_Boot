package com.jobapp.reviewmicroservice.reviews;


//import com.company.first_jobappproject.Company.CompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
        private ReviewService reviewService;


    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;

    }

    @GetMapping
    public ResponseEntity<List<Review>> getallreviews(@RequestParam Long companyId){
        return new ResponseEntity<>(reviewService.getallreviews(companyId), HttpStatus.OK);
    }
    @PostMapping
    public  ResponseEntity<String> addreveiew(@RequestBody Review review,@RequestParam Long companyId){

            boolean isreviewsaved=reviewService.addreview(companyId,review);
            if(isreviewsaved){

        return new ResponseEntity<>("review added",HttpStatus.CREATED);
            }
        return new ResponseEntity<>("review not saved",HttpStatus.NOT_FOUND );


    }

    @GetMapping("/{reviewsId}")
    public ResponseEntity<Review> getreview(@PathVariable Long reviewsId){
            return new ResponseEntity<>( reviewService.getreview(reviewsId),HttpStatus.OK);

    }

    @PutMapping("/{reviewId}")
    public ResponseEntity<String > updatereview(
                                                @PathVariable Long reviewId,
                                                @RequestBody Review review){
        boolean isreviewupdate=reviewService.updatereview(reviewId,review);
        if(isreviewupdate){
            return new ResponseEntity<>("review updated",HttpStatus.OK);
        }
        return new ResponseEntity<>("No update taken ",HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{reviewId}")
    public ResponseEntity<String> deletereview(@PathVariable Long reviewId){

        boolean isreviewdeleted=reviewService.deletereview(reviewId);

        if(isreviewdeleted){
            return new ResponseEntity<>("review deleted",HttpStatus.OK);
        }
        return new ResponseEntity<>("NO Delete",HttpStatus.NOT_FOUND);
    }


}
