package com.pknuwws.wws.webtoon.presentation;

import com.pknuwws.wws.webtoon.dto.SearchWebtoonListRequest;
import com.pknuwws.wws.webtoon.dto.WebtoonListRequest;
import com.pknuwws.wws.webtoon.application.WebtoonService;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/v1/webtoon")
public class WebtoonController {
    private final WebtoonService webtoonService;

    //3. 전체 웹툰 랭킹 likeProportion높은거순으로 정렬
    @GetMapping("/list")
    private ResponseEntity<List<WebtoonListRequest>> getAllWebtoon(
        @PageableDefault int page)
    {
        return ResponseEntity.ok(webtoonService.getAllWebtoonList(page));
    }

    //웹툰 한개 선택
    @GetMapping("/detail/{webtoonId}")
    private ResponseEntity<WebtoonListRequest> getWebtoon(@PathVariable("webtoonId") Long webtoonId){
        return ResponseEntity.ok(webtoonService.getWebtoon(webtoonId));
    }

    //4. 장르별 웹툰 랭킹 확인
    @GetMapping("/genre-list")
    private ResponseEntity<List<WebtoonListRequest>> getGenreWebtoon(
        @RequestParam("genre") String genre,
        @PageableDefault @Parameter(name="page") int page)
    {
        return ResponseEntity.ok(webtoonService.getGenreWebtoonList(genre, page));
    }

    //5. 신작 웹툰 확인
    @GetMapping("/new-list")
    private ResponseEntity<List<WebtoonListRequest>> getNewWebtoon(
        @PageableDefault @Parameter(name="page") int page)
    {
        return ResponseEntity.ok(webtoonService.getNewWebtoonList(page));
    }
    //7. 검색
    @GetMapping("/search")
    private ResponseEntity<Page<WebtoonListRequest>> searchWebtoon(
        @RequestParam("keyword") String keyword,
        @RequestParam("genre") String genre,
        @RequestParam("week") String week,
        @PageableDefault Pageable page)
    {
        return ResponseEntity.ok(webtoonService.searchWebtoonList(keyword, genre, week, page)) ;
    }

}