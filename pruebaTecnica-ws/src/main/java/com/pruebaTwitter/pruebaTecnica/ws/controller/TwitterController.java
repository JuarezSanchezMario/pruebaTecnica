package com.pruebaTwitter.pruebaTecnica.ws.controller;

import com.pruebaTwitter.pruebaTecnica.api.dto.TweetDTO;
import com.pruebaTwitter.pruebaTecnica.api.dto.TwitterHashtagRelated;
import com.pruebaTwitter.pruebaTecnica.api.service.TweetsManagementService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/tweetsFunctions")
@ApiOperation("Operations with tweets")
public class TwitterController {

    @Autowired
    TweetsManagementService tweetsManagementServiceService;

    @Autowired
    Logger log;

    @GetMapping("/tweets")
    @ApiOperation(value = "Find all tweets on my database")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = TweetDTO.class, responseContainer = "List"),
            @ApiResponse(code = 404, message = "No tweets found"),
            @ApiResponse(code = 500, message = "InternalServerError") })
    public List<TweetDTO> getTweets() {
        return tweetsManagementServiceService.getAll();
    }

    @PostMapping("/validate")
    @ApiOperation(value = "Change to validated the tweet indicated with id")
    public ResponseEntity<?> validate(@ApiParam(value="Id to validate",name="Tweet id",required = true) @RequestBody final Integer id){
        log.info("Calling to validate tweet");
        return new ResponseEntity<>(this.tweetsManagementServiceService.validate(id) ? HttpStatus.CREATED : HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/validatedTweets")
    @ApiOperation(value = "Retrieve all the validated tweets")
    public List<TweetDTO> getValidatedTweets(){
        log.info("Calling to get validated tweets");
        return tweetsManagementServiceService.getValidatedTweets();
    }

    @GetMapping("/mostUsedHastag")
    @ApiOperation(value = "Retrieve an arrangement of most used hashtags")
    public List<TwitterHashtagRelated> getMostUsedHashtag(
            @ApiParam(value = "The number of hashtags we need to expose", name = "nHashtag", required = true) @RequestParam final Integer nHashtags
    ){
        log.info("Calling to get most used hastags");
        return tweetsManagementServiceService.getMostUsedHashtags(nHashtags);
    }

}
