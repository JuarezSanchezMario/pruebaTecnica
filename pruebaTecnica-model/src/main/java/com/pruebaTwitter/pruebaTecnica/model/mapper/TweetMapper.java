package com.pruebaTwitter.pruebaTecnica.model.mapper;

import com.pruebaTwitter.pruebaTecnica.api.dto.TweetDTO;
import com.pruebaTwitter.pruebaTecnica.model.repository.entity.Tweet;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface TweetMapper {

    List<Tweet> asTweetList(List<TweetDTO> src);

    List<TweetDTO> asTweetDTOList(List<Tweet> src);

    TweetDTO asTweetDTO(Tweet src);

}
