package net.radish.crawler.rest;


import net.radish.crawler.model.Category;
import net.radish.crawler.model.GoodUrl;
import net.radish.crawler.service.GoodUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/goodurl/")
public class GoodUrlRestController {
    @Autowired
    private GoodUrlService goodUrlService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GoodUrl> getCategory(@PathVariable("id") Long categoryId) {
        if (categoryId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        GoodUrl goodUrl = goodUrlService.getById(categoryId);
        if (goodUrl == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(goodUrl, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GoodUrl> saveGood(@RequestBody @Valid GoodUrl id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        HttpHeaders headers = new HttpHeaders();
        this.goodUrlService.save(id);
        return new ResponseEntity<>(id, headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GoodUrl> updateGood(@RequestBody @Valid GoodUrl goodUrl, UriComponentsBuilder builder) {
        if (goodUrl == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        HttpHeaders headers = new HttpHeaders();
        this.goodUrlService.save(goodUrl);
        return new ResponseEntity<>(goodUrl, headers, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GoodUrl> deleteGood(@PathVariable("id") Long id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        GoodUrl goodUrl = goodUrlService.getById(id);
        if (goodUrl == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.goodUrlService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<GoodUrl>> getAllGoods() {
        List<GoodUrl> goodUrls = this.goodUrlService.getAll();
        if (goodUrls.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(goodUrls, HttpStatus.OK);
    }
}
