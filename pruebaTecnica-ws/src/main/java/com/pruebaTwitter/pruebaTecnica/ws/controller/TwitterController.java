package com.pruebaTwitter.pruebaTecnica.ws.controller;

import com.pruebaTwitter.pruebaTecnica.api.dto.TweetDTO;
import com.pruebaTwitter.pruebaTecnica.api.dto.TwitterHashtagRelated;
import com.pruebaTwitter.pruebaTecnica.api.service.TweetsManagementService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/tweetsFunctions")
@ApiOperation("Operations with tweets")
public class TwitterController {

    @Autowired
    TweetsManagementService tweetsManagementServiceService;

    Logger log = LoggerFactory.getLogger(TwitterController.class);

    @GetMapping("/tweets")
    @ApiOperation(value = "Find all tweets on my database")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = TweetDTO.class, responseContainer = "List"),
            @ApiResponse(code = 404, message = "No tweets found"),
            @ApiResponse(code = 500, message = "InternalServerError") })
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public List<TweetDTO> getTweets() {
        return tweetsManagementServiceService.getAll();
    }

    @PostMapping("/validate")
    @ApiOperation(value = "Change to validated the tweet indicated with id")
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public ResponseEntity<?> validate(@ApiParam(value="Id to validate",name="id",required = true) @RequestParam final Integer id){
        log.info("Calling to validate tweet");
        return new ResponseEntity<>(this.tweetsManagementServiceService.validate(id) ? HttpStatus.CREATED : HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/validatedTweets")
    @ApiOperation(value = "Retrieve all the validated tweets")
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public List<TweetDTO> getValidatedTweets(
            @ApiParam(value = "Username", name = "userName", required = true) @RequestParam final String userName){
        log.info("Calling to get validated tweets");
        return tweetsManagementServiceService.getValidatedTweets(userName);
    }

    @GetMapping("/mostUsedHastag")
    @ApiOperation(value = "Retrieve an arrangement of most used hashtags")
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public List<TwitterHashtagRelated> getMostUsedHashtag(
            @ApiParam(value = "The number of hashtags we need to expose", name = "nHashtags", required = true) @RequestParam final Integer nHashtags
    ){
        log.info("Calling to get most used hastags");
        return tweetsManagementServiceService.getMostUsedHashtags(nHashtags);
    }

}
