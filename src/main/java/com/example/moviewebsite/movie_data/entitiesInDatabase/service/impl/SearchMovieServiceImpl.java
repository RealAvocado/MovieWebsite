package com.example.moviewebsite.movie_data.entitiesInDatabase.service.impl;

import com.example.moviewebsite.movie_data.dto.SearchParam;
import com.example.moviewebsite.movie_data.entitiesInDatabase.entity.BasicMovieInfo;
import com.example.moviewebsite.movie_data.entitiesInDatabase.repository.BasicMovieInfoRepository;
import com.example.moviewebsite.movie_data.entitiesInDatabase.repository.MovieCastPairRepository;
import com.example.moviewebsite.movie_data.entitiesInDatabase.repository.MovieCountryPairRepository;
import com.example.moviewebsite.movie_data.entitiesInDatabase.repository.MovieGenrePairRepository;
import com.example.moviewebsite.movie_data.entitiesInDatabase.service.SearchMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder.In;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SearchMovieServiceImpl implements SearchMovieService {

    private final BasicMovieInfoRepository basicMovieInfoRepository;

    //external service
    private final MovieGenrePairRepository movieGenrePairRepository;

    private final MovieCountryPairRepository movieCountryPairRepository;

    private final MovieCastPairRepository movieCastPairRepository;

    @Autowired
    public SearchMovieServiceImpl(BasicMovieInfoRepository basicMovieInfoRepository,
                                  MovieGenrePairRepository movieGenrePairRepository, MovieCountryPairRepository movieCountryPairRepository,
                                  MovieCastPairRepository movieCastPairRepository) {
        this.basicMovieInfoRepository = basicMovieInfoRepository;
        this.movieGenrePairRepository = movieGenrePairRepository;
        this.movieCountryPairRepository = movieCountryPairRepository;
        this.movieCastPairRepository = movieCastPairRepository;
    }

    @Override
    public Page<BasicMovieInfo> search(SearchParam searchParam) {
        Pageable pageable = PageRequest.of(searchParam.getPage() - 1, searchParam.getSize());

        Specification<BasicMovieInfo> specification = (root, query, builder) -> {
            List<Predicate> predicateList = new ArrayList<>();

            //filter years
            if (searchParam.getYear().size() > 0) {
                In<Object> yearIn = builder.in(root.get("year"));
                for (Integer year : searchParam.getYear()) {
                    yearIn.value(year);
                }
                predicateList.add(yearIn);
            }

            //filter languages
            if (StringUtils.hasText(searchParam.getLanguage())) {
                Predicate infoPre = builder.equal(root.get("language"), searchParam.getLanguage());
                predicateList.add(infoPre);
            }

            //filter services
            if(StringUtils.hasText(searchParam.getService())){
                Predicate servicePre = builder.isNotNull(root.get(searchParam.getService() + "Link"));
                predicateList.add(servicePre);
            }

            //query genres
            Join<Object, Object> infoJoin = root.join("movieGenrePairList", JoinType.LEFT);
            if (searchParam.getGenres().size() > 0) {
                In<Object> genreIn = builder.in(infoJoin.get("genre"));
                for (Integer genre : searchParam.getGenres()) {
                    genreIn.value(genre);
                }
                predicateList.add(genreIn);
            }

            //query countries
            Join<Object, Object> countryJoin = root.join("movieCountryPairList", JoinType.LEFT);
            if (StringUtils.hasText(searchParam.getCountry())) {
                Predicate countryPre = builder.equal(countryJoin.get("country"), searchParam.getCountry());
                predicateList.add(countryPre);
            }

            //query casts
            Join<Object, Object> castJoin = root.join("movieCastPairList", JoinType.LEFT);
            if (StringUtils.hasText(searchParam.getCast().toLowerCase())) {
                Predicate castPre = builder.like(castJoin.get("cast"), "%" + nameConversion(searchParam.getCast()) + "%");
                predicateList.add(castPre);
            }

            return query.distinct(true).where(predicateList.toArray(new Predicate[predicateList.size()]))
                .getRestriction();
        };

        return basicMovieInfoRepository.findAll(specification, pageable);
    }

    private String nameConversion(String name) {
        name = name.toLowerCase();
        String[] nameArr = name.split(" ");
        return Arrays.stream(nameArr).map(v -> v.substring(0, 1).toUpperCase() + v.substring(1))
                .collect(Collectors.joining(" "));
    }


}

